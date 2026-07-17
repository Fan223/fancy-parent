package fan.fancy.iam.pojo.vo;

import lombok.Data;

/**
 * 用户展示类.
 *
 * @author Fan
 */
@Data
public class UserVO {

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
