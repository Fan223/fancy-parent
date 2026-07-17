package fan.fancy.blog.pojo.query;

import fancy.starter.mybatis.plus.query.PageQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 文章查询参数.
 *
 * @author Fan
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ArticleQuery extends PageQuery {

    private String title;

    private String status;
}
