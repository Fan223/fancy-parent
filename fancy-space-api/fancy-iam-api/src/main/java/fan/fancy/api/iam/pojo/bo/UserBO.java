package fan.fancy.api.iam.pojo.bo;

import lombok.Data;

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
}