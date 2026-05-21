package fan.fancy.iam.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import fan.fancy.api.iam.pojo.entity.UserIdentityDO;
import fan.fancy.iam.mapper.UserIdentityMapper;
import fan.fancy.iam.mapper.UserMapper;
import fan.fancy.iam.pojo.entity.UserDO;
import fan.fancy.iam.pojo.query.UserQuery;
import fan.fancy.iam.service.UserService;
import fan.fancy.toolkit.id.IdUtils;
import fan.fancy.toolkit.lang.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    private final UserIdentityMapper userIdentityMapper;

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

    @Override
    public UserIdentityDO getByIdentifier(String identifier) {
        LambdaQueryWrapper<UserIdentityDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserIdentityDO::getIdentifier, identifier);
        return userIdentityMapper.selectOne(queryWrapper);
    }

    @Override
    @Transactional
    public Integer createUser(UserDO userDO, List<UserIdentityDO> userIdentities) {
        UserIdentityDO userIdentityDO = userIdentities.getFirst();
        UserIdentityDO userIdentity = getByIdentifier(userIdentityDO.getIdentifier());
        if (userIdentity == null) {
            long id = IdUtils.generateSnowflakeId();
            userDO.setId(id);
            create(userDO);

            userIdentityDO.setUserId(id);
            return userIdentityMapper.insert(userIdentityDO);
        }

        userIdentityDO.setId(userIdentity.getId());
        userIdentityDO.setUserId(userIdentity.getUserId());
        return userIdentityMapper.updateById(userIdentityDO);
    }
}
