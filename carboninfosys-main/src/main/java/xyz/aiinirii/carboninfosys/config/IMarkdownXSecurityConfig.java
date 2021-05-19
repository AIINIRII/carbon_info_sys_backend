package xyz.aiinirii.carboninfosys.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import xyz.aiinirii.carboninfosys.security.config.SecurityConfig;
import xyz.aiinirii.carboninfosys.service.UserService;

/**
 * Spring security的配置类
 *
 * @author AIINIRII
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class IMarkdownXSecurityConfig extends SecurityConfig {

    private UserService memberService;

    @Autowired
    public void setMemberService(UserService memberService) {
        this.memberService = memberService;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> memberService.loadUserByUsername(username);
    }

}