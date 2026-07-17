package fan.fancy.iam.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import fancy.starter.mybatis.plus.entity.MetaDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户角色关联实体类.
 *
 * @author Fan
 */
@TableName("user_role")
@Data
@EqualsAndHashCode(callSuper = true)
public class UserRoleDO extends MetaDO {

    /**
     * 用户ID.
     */
    private Long userId;

    /**
     * 角色ID.
     */
    private Long roleId;
}
