package fan.fancy.iam.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import fancy.starter.mybatis.plus.entity.MetaDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 菜单实体类.
 *
 * @author Fan
 */
@TableName("menu")
@Data
@EqualsAndHashCode(callSuper = true)
public class MenuDO extends MetaDO {

    /**
     * 父菜单ID.
     */
    private Long parentId;

    /**
     * 菜单名称.
     */
    private String name;

    /**
     * 菜单路径.
     */
    private String path;

    /**
     * 权限码.
     */
    private String permission;

    /**
     * 组件.
     */
    private String component;

    /**
     * 图标.
     */
    private String icon;

    /**
     * 类型 0:顶栏 1:侧栏.
     */
    private Byte type;

    /**
     * 排序.
     */
    private Integer sortOrder;
}
