package fan.fancy.iam.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import fancy.starter.mybatis.plus.entity.MetaDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 用户实体类.
 *
 * @author Fan
 */
@TableName("user")
@Data
@EqualsAndHashCode(callSuper = true)
public class UserDO extends MetaDO {

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
    private Integer gender;

    /**
     * 生日.
     */
    private LocalDateTime birthday;
}
