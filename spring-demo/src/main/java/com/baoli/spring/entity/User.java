package com.baoli.spring.entity;

import com.baoli.spring.common.base.model.BaseModel;
import lombok.Data;

/**
 * @program: common-demo
 * @description: 用户
 * @author: li baojian
 * @create: 2020-03-19 17:26
 */
@Data
public class User extends BaseModel<User> {
    private String name;
    private String password;
    private String sex;
    private String age;
}
