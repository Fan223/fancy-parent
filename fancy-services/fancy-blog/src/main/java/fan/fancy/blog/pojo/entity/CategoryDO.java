package fan.fancy.blog.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import fancy.starter.mybatis.plus.entity.MetaDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 博客分类实体类.
 *
 * @author Fan
 */
@TableName("category")
@Data
@EqualsAndHashCode(callSuper = true)
public class CategoryDO extends MetaDO {

    /**
     * 父分类 ID.
     */
    private Long parentId;

    /**
     * 分类名称.
     */
    private String name;

    /**
     * 排序.
     */
    private Integer sortOrder;

    /**
     * 状态.
     */
    private Integer status;
}
