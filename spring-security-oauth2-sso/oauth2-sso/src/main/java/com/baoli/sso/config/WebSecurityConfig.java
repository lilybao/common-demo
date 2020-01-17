package com.baoli.sso.config;

import com.baoli.sso.model.SysUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @description: security配置类
 * @author: li baojian
 * @create: 2019/12/31 16:09
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * 配置加密方式
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Override
//    protected UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
//        SysUser sysUser = new SysUser();
//        sysUser.setUsername("user1");
//        sysUser.setPassword(passwordEncoder.encode("123456"));
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withUsername(sysUser.getUsername()).accountExpired());
//    }

    /**
     * 配置认证方式   所有页面都需要认证
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .and().authorizeRequests()
                .anyRequest()
                .authenticated();
    }
}
