package com.baoli.sso.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: 系统用户类
 * @author: li baojian
 * @create: 2019/12/31 16:16
 */
@Data
public class SysUser implements Serializable {
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 是否允许账户过期 默认  true
     */
    private boolean accountNonExpired = true;
    /**
     * 是否允许账户锁定 默认  true
     */
    private boolean accountNonLocked = true;
    /**
     * 是否允许凭证过期 默认  true
     */
    private boolean credentialsNonExpired = true;
    private boolean enabled = true;
}
