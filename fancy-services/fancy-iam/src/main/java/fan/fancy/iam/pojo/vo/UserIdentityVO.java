package fan.fancy.iam.pojo.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import fan.fancy.api.iam.pojo.entity.UserIdentityDO;
import fan.fancy.starter.mybatis.plus.entity.MetaDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户身份实体类.
 *
 * @author Fan
 */
@TableName("user_identity")
@Data
@EqualsAndHashCode(callSuper = true)
public class UserIdentityVO extends MetaDO {

    /**
     * 用户ID.
     */
    private String userId;

    /**
     * 身份类型 0:系统内部身份 1:第三方身份.
     */
    private String type;

    /**
     * 身份 {@link UserIdentityDO.IdentityType}.
     */
    private String identity;

    /**
     * 身份标识(用户名/手机号/邮箱/第三方ID).
     */
    private String identifier;
}
