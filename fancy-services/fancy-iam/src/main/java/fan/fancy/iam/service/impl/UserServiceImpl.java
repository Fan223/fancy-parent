package fan.fancy.iam.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import fan.fancy.api.auth.pojo.dto.AuthBindRequest;
import fan.fancy.api.auth.pojo.enums.IdentityType;
import fan.fancy.api.auth.service.AuthUserApi;
import fan.fancy.iam.mapper.UserMapper;
import fan.fancy.iam.pojo.dto.UserDTO;
import fan.fancy.iam.pojo.entity.UserDO;
import fan.fancy.iam.pojo.query.UserQuery;
import fan.fancy.iam.service.UserService;
import fan.fancy.toolkit.id.IdUtils;
import fan.fancy.toolkit.lang.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 用户接口实现类.
 *
 * @author Fan
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    private final AuthUserApi authUserApi;

    @Override
    public Page<UserDO> page(UserQuery query) {
        LambdaQueryWrapper<UserDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(query.getUsername()), UserDO::getNickname, query.getUsername());
        return userMapper.selectPage(new Page<>(query.getCurrentPage(), query.getPageSize()), queryWrapper);
    }

    @Override
    public UserDO getById(String id) {
        return userMapper.selectById(id);
    }

    @Override
    public int create(UserDO userDO) {
        return userMapper.insert(userDO);
    }

    @Override
    public int update(UserDO userDO) {
        return userMapper.updateById(userDO);
    }

    @Override
    public int deleteById(String id) {
        return userMapper.deleteById(id);
    }

    @Override
    public int deleteByIds(List<String> ids) {
        return userMapper.deleteByIds(ids);
    }

    /**
     * 创建业务用户 + 绑定认证账号.
     *
     * <p>两步在同一事务中：若 auth.bind 失败，IAM 业务用户也会回滚。
     */
    @Transactional
    public Long createUserWithAuth(UserDTO userDTO) {
        long userId = IdUtils.generateSnowflakeId();
        UserDO userDO = new UserDO();
        userDO.setId(userId);
        userDO.setNickname(userDTO.getNickname());
        userDO.setAvatar(userDTO.getAvatar());
        if (userDTO.getGender() != null) {
            userDO.setGender(Integer.valueOf(userDTO.getGender()));
        }
        if (userDTO.getBirthday() != null && !userDTO.getBirthday().isBlank()) {
            userDO.setBirthday(LocalDateTime.parse(userDTO.getBirthday()));
        }
        userMapper.insert(userDO);

        AuthBindRequest bindReq = new AuthBindRequest();
        bindReq.setUserId(userId);
        bindReq.setIdentityType(IdentityType.USERNAME);
        bindReq.setIdentifier(userDTO.getUsername());
        bindReq.setCredential(userDTO.getPassword());
        authUserApi.bind(bindReq);

        return userId;
    }
}