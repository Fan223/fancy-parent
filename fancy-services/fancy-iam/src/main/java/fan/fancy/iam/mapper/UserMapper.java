package fan.fancy.iam.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import fan.fancy.api.iam.pojo.bo.UserBO;
import fan.fancy.iam.pojo.entity.UserDO;

/**
 * 用户表 Mapper 接口
 *
 * @author Fan
 */
public interface UserMapper extends BaseMapper<UserDO> {

    UserBO selectUser(Long userId);
}
