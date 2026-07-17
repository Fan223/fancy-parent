package fan.fancy.iam.pojo.query;

import fancy.starter.mybatis.plus.query.PageQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户查询参数.
 *
 * @author Fan
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserQuery extends PageQuery {

    private String username;
}
