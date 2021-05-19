package xyz.aiinirii.carboninfosys.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import xyz.aiinirii.carboninfosys.common.service.RedisService;
import xyz.aiinirii.carboninfosys.mapper.UserMapper;
import xyz.aiinirii.carboninfosys.model.User;
import xyz.aiinirii.carboninfosys.service.UserCacheService;

import javax.annotation.Resource;

/**
 * 会员信息缓存业务类
 *
 * @author AIINIRII
 */
@Service
public class UserCacheServiceImpl implements UserCacheService {

    private RedisService redisService;

    private UserMapper userMapper;
    @Value("${redis.database}")
    private String REDIS_DATABASE;
    @Value("${redis.key.member}")
    private String REDIS_KEY_MEMBER;

    @Resource
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Autowired
    public void setRedisService(RedisService redisService) {
        this.redisService = redisService;
    }

    @Override
    public void delMember(Long memberId) {
        User user = userMapper.selectByPrimaryKey(memberId);
        if (user != null) {
            String key = REDIS_DATABASE + ":" + REDIS_KEY_MEMBER + ":" + user.getUsername();
            redisService.del(key);
        }
    }

    @Override
    public User getMember(String username) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_MEMBER + ":" + username;
        return (User) redisService.get(key);
    }

    @Override
    public void setMember(User member) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_MEMBER + ":" + member.getUsername();
        redisService.set(key, member);
    }
}