package fan.fancy.api.iam.service;

import fan.fancy.api.iam.pojo.dto.UserDTO;
import fan.fancy.toolkit.http.Response;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

/**
 * 用户 API 服务.
 *
 * @author Fan
 */
//@FeignClient(name = "fancy-iam", path = "/iam/users")
@HttpExchange("http://172.16.63.132:10000/iam/users")
public interface UserApiService {

    /**
     * 创建用户.
     *
     * @param userDTO {@link UserDTO}
     * @return {@link Response}
     */
    @PostExchange
    Response<Integer> create(@RequestBody UserDTO userDTO);
}
