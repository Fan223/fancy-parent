package fan.fancy.iam.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import fancy.starter.mybatis.plus.entity.MetaDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 角色实体类.
 *
 * @author Fan
 */
@TableName("role")
@Data
@EqualsAndHashCode(callSuper = true)
public class RoleDO extends MetaDO {

    /**
     * 角色编码.
     */
    private String code;

    /**
     * 角色名称.
     */
    private String name;
}
