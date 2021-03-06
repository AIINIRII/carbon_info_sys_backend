package xyz.aiinirii.carboninfosys.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import xyz.aiinirii.carboninfosys.common.exception.Asserts;
import xyz.aiinirii.carboninfosys.domain.PortalUserDetails;
import xyz.aiinirii.carboninfosys.domain.UpdateMemberPasswordParam;
import xyz.aiinirii.carboninfosys.domain.UserRegisterParam;
import xyz.aiinirii.carboninfosys.mapper.UserMapper;
import xyz.aiinirii.carboninfosys.model.User;
import xyz.aiinirii.carboninfosys.model.UserExample;
import xyz.aiinirii.carboninfosys.security.util.JwtTokenUtil;
import xyz.aiinirii.carboninfosys.service.UserCacheService;
import xyz.aiinirii.carboninfosys.service.UserService;

import javax.annotation.Resource;
import javax.security.auth.AuthPermission;
import java.util.Date;
import java.util.List;

/**
 * @author AIINIRII
 */
@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    private PasswordEncoder passwordEncoder;
    private UserMapper userMapper;
    private UserCacheService memberCacheService;
    private JwtTokenUtil jwtTokenUtil;

    @Resource
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void setMemberCacheService(UserCacheService memberCacheService) {
        this.memberCacheService = memberCacheService;
    }

    @Autowired
    public void setJwtTokenUtil(JwtTokenUtil jwtTokenUtil) {
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Override
    public User getMemberByUsername(String username) {
        // ???????????????
        User member = memberCacheService.getMember(username);
        if (member != null) {
            return member;
        }
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameLike(username);
        List<User> users = userMapper.selectByExample(userExample);
        if (users != null && users.size() > 0) {
            member = users.get(0);
            memberCacheService.setMember(member);
            return member;
        }
        return null;
    }

    @Override
    public User register(UserRegisterParam userRegisterParam) {
        // ???????????????????????????
        UserExample memberExample = new UserExample();
        memberExample.createCriteria().andUsernameLike(userRegisterParam.getUsername());
        List<User> users = userMapper.selectByExample(memberExample);
        if (!CollectionUtils.isEmpty(users)) {
            Asserts.fail("????????????????????????");
        }
        memberExample.clear();
        if (userRegisterParam.getEmail() != null) {
            memberExample.createCriteria().andEmailEqualTo(userRegisterParam.getEmail());
            users = userMapper.selectByExample(memberExample);
            if (!CollectionUtils.isEmpty(users)) {
                Asserts.fail("?????????????????????");
            }
        }
        // ??????????????????????????????????????????
        User user = new User();
        user.setUsername(userRegisterParam.getUsername());
        user.setPassword(passwordEncoder.encode(userRegisterParam.getPassword()));
        user.setEmail(userRegisterParam.getEmail());
        user.setCreateTime(new Date());
        user.setIsAdmin((byte) 0);
        user.setIsEnable((byte) 1);
        // ????????????
        userMapper.insert(user);
        user.setPassword(null);
        return user;
    }

    @Override
    public String login(String username, String password) throws AuthenticationException {
        String token = null;
        try {
            UserDetails userDetails = loadUserByUsername(username);
            if (!userDetails.isEnabled()) {
                throw new BadCredentialsException("?????????????????????");
            }
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                throw new BadCredentialsException("????????????");
            }
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            token = jwtTokenUtil.generateToken(userDetails);
        } catch (AuthenticationException e) {
            LOGGER.warn("???????????????{}", e.getMessage());
        }
        return token;
    }

    @Override
    public String refreshToken(String oldToken) {
        return jwtTokenUtil.refreshHeadToken(oldToken);
    }

    @Override
    public User getItem(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(User member) {
        // ???????????????????????????
        UserExample memberExample = new UserExample();
        memberExample.createCriteria().andUsernameLike(member.getUsername());
        List<User> users = userMapper.selectByExample(memberExample);
        if (!CollectionUtils.isEmpty(users)) {
            Asserts.fail("????????????????????????");
        }
        memberExample.clear();
        if (member.getEmail() != null) {
            memberExample.createCriteria().andEmailEqualTo(member.getEmail());
            users = userMapper.selectByExample(memberExample);
            if (!CollectionUtils.isEmpty(users)) {
                Asserts.fail("?????????????????????");
            }
        }
        memberCacheService.delMember(member.getId());
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        return userMapper.updateByPrimaryKeySelective(member);
    }

    @Override
    public int delete(Long id) {
        memberCacheService.delMember(id);
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updatePassword(UpdateMemberPasswordParam updateMemberPasswordParam) {
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(updateMemberPasswordParam.getUserName());
        List<User> users = userMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(users)) {
            User member = users.get(0);
            if (passwordEncoder.matches(updateMemberPasswordParam.getOldPassword(), member.getPassword())) {
                // ??????????????????????????????????????????????????????
                member.setPassword(passwordEncoder.encode(updateMemberPasswordParam.getNewPassword()));
                userMapper.updateByPrimaryKeySelective(member);
                memberCacheService.delMember(member.getId());
                return 1;
            } else {
                Asserts.fail("????????????");
            }
        } else {
            Asserts.fail("?????????????????????");
        }
        return 0;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        // ??????????????????
        User user = getMemberByUsername(username);
        if (user != null) {
            return new PortalUserDetails(user, new AuthPermission(user.getIsAdmin().intValue() == 0 ? "USER" : "ADMINISTRATOR"));
        }
        throw new UsernameNotFoundException("????????????????????????");
    }

    @Override
    public PageInfo<User> getUsersByPageNum(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        UserExample userExample = new UserExample();
        userExample.createCriteria().andIsAdminEqualTo((byte) 0);
        List<User> userList = userMapper.selectByExample(userExample);
        return new PageInfo<>(userList);
    }

    @Override
    public boolean changeUserPassword(Long userId, String password) {
        memberCacheService.delMember(userId);
        User user = userMapper.selectByPrimaryKey(userId);
        user.setPassword(passwordEncoder.encode(password));
        int updateLineNumber = userMapper.updateByPrimaryKey(user);
        return updateLineNumber == 1;
    }

    @Override
    public int updateUserStatus(Long userId, byte enable) {
        memberCacheService.delMember(userId);
        User user = userMapper.selectByPrimaryKey(userId);
        user.setIsEnable(enable);
        return userMapper.updateByPrimaryKey(user);
    }

}