package fan.fancy.iam.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import fan.fancy.iam.pojo.dto.UserDTO;
import fan.fancy.iam.pojo.entity.UserDO;
import fan.fancy.iam.pojo.query.UserQuery;

import java.util.List;

/**
 * 用户接口.
 *
 * @author Fan
 */
public interface UserService {

    Page<UserDO> page(UserQuery query);

    UserDO getById(String id);

    int create(UserDO userDO);

    int update(UserDO userDO);

    int deleteById(String id);

    int deleteByIds(List<String> ids);

    /**
     * 创建业务用户 + 绑定认证账号.
     */
    Long createUserWithAuth(UserDTO userDTO);
}