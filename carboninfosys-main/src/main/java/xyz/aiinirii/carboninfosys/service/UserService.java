package xyz.aiinirii.carboninfosys.service;

import com.github.pagehelper.PageInfo;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;
import xyz.aiinirii.carboninfosys.domain.UpdateMemberPasswordParam;
import xyz.aiinirii.carboninfosys.domain.UserRegisterParam;
import xyz.aiinirii.carboninfosys.model.User;

/**
 * @author AIINIRII
 */
public interface UserService {
    /**
     * 根据用户名获取后台用户
     *
     * @param username 用户名
     * @return 用户
     */
    User getMemberByUsername(String username);

    /**
     * 用户注册
     *
     * @param userRegisterParam 用户注册参数
     * @return 注册成功用户
     */
    @Transactional
    User register(UserRegisterParam userRegisterParam);

    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 生成的JWT token
     * @throws AuthenticationException 登录异常
     */
    String login(String username, String password) throws AuthenticationException;

    /**
     * 刷新Token
     *
     * @param oldToken 旧的token
     * @return 新的token
     */
    String refreshToken(String oldToken);

    /**
     * 根据id获取用户
     *
     * @param id 用户id
     * @return 用户
     */
    User getItem(Long id);

    /**
     * 根据用户id更改用户数据
     *
     * @param member 用户数据
     * @return 是否成功
     */
    @Transactional
    int update(User member);

    /**
     * 删除指定用户
     *
     * @param id 删除用户id
     * @return 是否成功
     */
    int delete(Long id);

    /**
     * 修改用户密码
     *
     * @param updateMemberPasswordParam 修改用户密码时的参数
     * @return 是否成功
     */
    @Transactional
    int updatePassword(UpdateMemberPasswordParam updateMemberPasswordParam);

    /**
     * 获取用户信息
     *
     * @param username 用户名
     * @return 用户信息
     */
    UserDetails loadUserByUsername(String username);

    /**
     * 分页获取用户信息
     *
     * @param pageNum  页数
     * @param pageSize 页面大小
     * @return 该页用户信息
     */
    PageInfo<User> getUsersByPageNum(int pageNum, int pageSize);

    /**
     * 更改用户密码
     * @param userId 用户的id
     * @param password 更改之后的用户密码
     * @return 更改成功与否
     */
    @Transactional
    boolean changeUserPassword(Long userId, String password);

    @Transactional
    int updateUserStatus(Long userId, byte enable);
}