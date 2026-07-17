package fan.fancy.blog.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import fancy.starter.mybatis.plus.entity.MetaDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 博客标签实体类.
 *
 * @author Fan
 */
@TableName("tag")
@Data
@EqualsAndHashCode(callSuper = true)
public class TagDO extends MetaDO {

    /**
     * 标签名称.
     */
    private String name;
}
