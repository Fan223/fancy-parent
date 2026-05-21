package fan.fancy.api.iam.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import fan.fancy.starter.mybatis.plus.entity.MetaDO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * 用户身份实体类.
 *
 * @author Fan
 */
@TableName("user_identity")
@Data
@EqualsAndHashCode(callSuper = true)
public class UserIdentityDO extends MetaDO {

    /**
     * 用户ID.
     */
    private Long userId;

    /**
     * 身份类型 0:系统内部身份 1:第三方身份.
     */
    private Integer type;

    /**
     * 身份 {@link IdentityType}.
     */
    private Integer identity;

    /**
     * 身份标识(用户名/手机号/邮箱/第三方ID).
     */
    private String identifier;

    /**
     * 凭证(password/access_token).
     */
    private String credential;

    @Getter
    @AllArgsConstructor
    public enum IdentityType {

        USERNAME(1),
        PHONE(2),
        EMAIL(3),
        GITHUB(4),
        WECHAT(5),
        QQ(6);

        private final int code;
    }
}
