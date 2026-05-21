package fan.fancy.api.iam.pojo.bo;

import fan.fancy.api.iam.pojo.entity.UserIdentityDO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户业务类.
 *
 * @author Fan
 */
@Data
public class UserBO {

    /**
     * 用户ID.
     */
    private String id;

    /**
     * 头像.
     */
    private String avatar;

    /**
     * 昵称.
     */
    private String nickname;

    /**
     * 性别 0:女 1:男 2:未知.
     */
    private String gender;

    /**
     * 生日.
     */
    private String birthday;

    /**
     * 用户身份列表.
     */
    private List<UserIdentityDO> userIdentities = new ArrayList<>();
}
