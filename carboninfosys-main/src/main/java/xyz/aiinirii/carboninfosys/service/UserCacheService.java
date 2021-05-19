package xyz.aiinirii.carboninfosys.service;


import xyz.aiinirii.carboninfosys.model.User;

/**
 * 会员信息缓存业务类
 *
 * @author AIINIRII
 */
public interface UserCacheService {

    /**
     * 删除用户缓存
     *
     * @param memberId 用户id
     */
    void delMember(Long memberId);

    /**
     * 从缓存获取用户
     *
     * @param username 用户名
     * @return 用户
     */
    User getMember(String username);

    /**
     * 设置会员用户缓存
     *
     * @param member 会员用户
     */
    void setMember(User member);
}