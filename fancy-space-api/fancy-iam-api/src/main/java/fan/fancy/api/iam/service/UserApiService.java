package fan.fancy.api.iam.service;

import fan.fancy.api.iam.pojo.bo.UserBO;
import fan.fancy.toolkit.http.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 用户 API 服务.
 *
 * @author Fan
 */
@FeignClient(name = "fancy-iam", path = "/iam/users/auth")
public interface UserApiService {

    /**
     * 根据身份标识获取用户.
     *
     * @param identifier 身份标识
     * @return 用户业务对象
     */
    @GetMapping("/{identifier}")
    UserBO getByIdentifier(@PathVariable String identifier);

    /**
     * 创建用户.
     *
     * @param userBO 用户业务对象
     * @return 影响行数
     */
    @PostMapping("/creatUser")
    Response<Integer> createUser(@RequestBody UserBO userBO);
}
