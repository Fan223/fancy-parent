package fan.fancy.iam.pojo.dto;

import lombok.Data;

/**
 * 用户数据传输类.
 *
 * @author Fan
 */
@Data
public class UserDTO {

    /**
     * 用户ID.
     */
    private String id;

    /**
     * 用户名（认证身份标识）.
     */
    private String username;

    /**
     * 密码.
     */
    private String password;

    /**
     * 昵称.
     */
    private String nickname;

    /**
     * 头像.
     */
    private String avatar;

    /**
     * 生日.
     */
    private String birthday;

    /**
     * 性别 0:女 1:男 2:未知.
     */
    private String gender;

    /**
     * 手机号.
     */
    private String phone;

    /**
     * 邮箱.
     */
    private String email;
}
