package fan.fancy.iam.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import fan.fancy.api.iam.pojo.bo.UserBO;
import fan.fancy.api.iam.pojo.entity.UserIdentityDO;
import fan.fancy.iam.converter.IamConverter;
import fan.fancy.iam.pojo.dto.UserDTO;
import fan.fancy.iam.pojo.entity.UserDO;
import fan.fancy.iam.pojo.query.UserQuery;
import fan.fancy.iam.pojo.vo.UserVO;
import fan.fancy.iam.service.UserService;
import fan.fancy.toolkit.http.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户控制器.
 *
 * @author Fan
 */
@RestController
@RequestMapping("/iam/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final IamConverter iamConverter;

    @GetMapping
    public Response<Page<UserVO>> page(UserQuery query) {
        Page<UserDO> users = userService.page(query);
        return Response.success(iamConverter.convertUsers(users));
    }

    @GetMapping("/{id}")
    public Response<UserVO> getById(@PathVariable String id) {
        UserDO userDO = userService.getById(id);
        return Response.success(iamConverter.convertUser(userDO));
    }

    @PostMapping
    public Response<Integer> create(@RequestBody UserDTO userDTO) {
        UserDO userDO = iamConverter.convertUser(userDTO);
        return Response.success(userService.create(userDO));
    }

    @PutMapping("/{id}")
    public Response<Integer> update(@PathVariable String id, @RequestBody UserDTO userDTO) {
        if (!id.equals(userDTO.getId())) {
            return Response.fail("数据不匹配");
        }
        UserDO userDO = iamConverter.convertUser(userDTO);
        return Response.success(userService.update(userDO));
    }

    @DeleteMapping("/{id}")
    public Response<Integer> deleteById(@PathVariable String id) {
        return Response.success(userService.deleteById(id));
    }

    @DeleteMapping
    public Response<Integer> deleteByIds(@RequestParam List<String> ids) {
        return Response.success(userService.deleteByIds(ids));
    }

    @GetMapping("/auth/{identifier}")
    public UserBO getByIdentifier(@PathVariable String identifier) {
        UserIdentityDO userIdentityDO = userService.getByIdentifier(identifier);
        if (userIdentityDO == null) {
            return null;
        }
        UserDO userDO = userService.getById(String.valueOf(userIdentityDO.getUserId()));
        UserBO userBO = iamConverter.convertUserBO(userDO);
        userBO.getUserIdentities().add(userIdentityDO);
        return userBO;
    }

    @PostMapping("/auth/creatUser")
    public Response<Integer> createUser(@RequestBody UserBO userBO) {
        UserDO userDO = iamConverter.convertUserBO(userBO);
        return Response.success(userService.createUser(userDO, userBO.getUserIdentities()));
    }
}
