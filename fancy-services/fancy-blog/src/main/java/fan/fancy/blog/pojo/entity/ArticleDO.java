package fan.fancy.blog.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import fancy.starter.mybatis.plus.entity.MetaDO;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * 博客文章实体类.
 *
 * @author Fan
 */
@TableName("article")
@Data
@EqualsAndHashCode(callSuper = true)
public class ArticleDO extends MetaDO {

    /**
     * 封面.
     */
    private String cover;

    /**
     * 标题.
     */
    private String title;

    /**
     * 摘要.
     */
    private String summary;

    /**
     * 内容.
     */
    private String content;

    /**
     * 状态.
     */
    private Integer status;

    /**
     * 浏览量.
     */
    private Integer view;
}
