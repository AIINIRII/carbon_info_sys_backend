package xyz.aiinirii.carboninfosys.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import xyz.aiinirii.carboninfosys.model.User;

import java.security.Permission;
import java.util.Collection;
import java.util.Collections;

/**
 * 前台用户信息模块
 *
 * @author AIINIRII
 */
public class PortalUserDetails implements UserDetails {

    private final User user;
    private final Permission permission;

    public PortalUserDetails(User user, Permission permission) {
        this.user = user;
        this.permission = permission;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(
                new SimpleGrantedAuthority(permission.getName())
        );
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.getIsEnable() == (byte) 1;
    }
}