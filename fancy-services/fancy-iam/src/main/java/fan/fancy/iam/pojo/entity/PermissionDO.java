package fan.fancy.iam.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import fancy.starter.mybatis.plus.entity.MetaDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 权限实体类.
 *
 * @author Fan
 */
@TableName("permission")
@Data
@EqualsAndHashCode(callSuper = true)
public class PermissionDO extends MetaDO {

    /**
     * 权限编码.
     */
    private String code;

    /**
     * 权限名称.
     */
    private String name;
}
