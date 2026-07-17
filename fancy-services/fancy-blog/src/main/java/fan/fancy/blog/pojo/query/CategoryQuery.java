package fan.fancy.blog.pojo.query;

import fancy.starter.mybatis.plus.query.PageQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 分类查询参数.
 *
 * @author Fan
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CategoryQuery extends PageQuery {

    private String name;

    private String status;
}
