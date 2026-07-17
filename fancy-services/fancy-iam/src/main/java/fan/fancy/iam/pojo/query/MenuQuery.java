package fan.fancy.iam.pojo.query;

import fancy.starter.mybatis.plus.query.PageQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 菜单查询参数.
 *
 * @author Fan
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MenuQuery extends PageQuery {

    private String name;
}
