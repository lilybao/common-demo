package com.baoli.sso.config;

import com.baoli.sso.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @description: 自定义用户登录认证配置类
 * @author: li baojian
 * @create: 2019/12/31 16:32
 */
@Configuration
public class UserDetailService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = new SysUser();
        sysUser.setUsername(username);
        sysUser.setPassword(passwordEncoder.encode("123456"));
//        new User(username,sysUser.getPassword(),sysUser.isEnabled(),sysUser.isAccountNonExpired(),sysUser.isCredentialsNonExpired(),sysUser.isAccountNonLocked(), AuthorityUtils.commaSeparatedStringToAuthorityList("user:add"));
        return User.withUsername(username).accountExpired(sysUser.isAccountNonExpired()).accountLocked(sysUser.isAccountNonLocked()).credentialsExpired(sysUser.isCredentialsNonExpired()).authorities(AuthorityUtils.commaSeparatedStringToAuthorityList("user:add")).build();
    }
}
