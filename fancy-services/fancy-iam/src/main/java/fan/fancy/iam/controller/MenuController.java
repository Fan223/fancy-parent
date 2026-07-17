package fan.fancy.iam.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import fan.fancy.iam.converter.IamConverter;
import fan.fancy.iam.pojo.dto.MenuDTO;
import fan.fancy.iam.pojo.entity.MenuDO;
import fan.fancy.iam.pojo.query.MenuQuery;
import fan.fancy.iam.pojo.vo.MenuVO;
import fan.fancy.iam.service.MenuService;
import fan.fancy.toolkit.builder.TreeBuilder;
import fancy.boot.core.http.Response;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 菜单控制器.
 *
 * @author Fan
 */
@RestController
@RequestMapping("/iam/menus")
@AllArgsConstructor
public class MenuController {

    private final MenuService menuService;

    private final IamConverter iamConverter;

    @GetMapping
    public Response<Page<MenuVO>> page(MenuQuery query) {
        Page<MenuDO> menus = menuService.page(query);
        return Response.success(iamConverter.convertMenus(menus));
    }

    @GetMapping("/list")
    public Response<List<MenuVO>> list(MenuQuery query) {
        List<MenuDO> menuDOList = menuService.list(query);
        List<MenuVO> menus = iamConverter.convertMenus(menuDOList);
        List<MenuVO> menuTree = TreeBuilder.builder(menus, MenuVO::getId, MenuVO::getParentId, MenuVO::getChildren).build();
        return Response.success(menuTree);
    }

    @PostMapping
    public Response<Integer> create(@RequestBody MenuDTO menuDTO) {
        MenuDO menuDO = iamConverter.convertMenu(menuDTO);
        return Response.success(menuService.create(menuDO));
    }

    @PutMapping("/{id}")
    public Response<Integer> update(@PathVariable String id, @RequestBody MenuDTO menuDTO) {
        if (!id.equals(menuDTO.getId())) {
            return Response.fail("数据不匹配");
        }
        MenuDO menuDO = iamConverter.convertMenu(menuDTO);
        return Response.success(menuService.update(menuDO));
    }

    @DeleteMapping("/{id}")
    public Response<Integer> deleteById(@PathVariable String id) {
        return Response.success(menuService.deleteById(id));
    }

    @DeleteMapping
    public Response<Integer> deleteByIds(@RequestParam List<String> ids) {
        return Response.success(menuService.deleteByIds(ids));
    }
}
