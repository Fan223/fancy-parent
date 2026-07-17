package fan.fancy.iam.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import fancy.starter.mybatis.plus.entity.MetaDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 角色权限关联实体类.
 *
 * @author Fan
 */
@TableName("role_permission")
@Data
@EqualsAndHashCode(callSuper = true)
public class RolePermissionDO extends MetaDO {

    /**
     * 角色ID.
     */
    private Long roleId;

    /**
     * 权限ID.
     */
    private Long permissionId;
}
