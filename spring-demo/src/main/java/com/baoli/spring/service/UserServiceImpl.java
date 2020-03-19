package com.baoli.spring.service;

import com.baoli.spring.api.UserService;
import com.baoli.spring.common.base.service.impl.BaseServiceImpl;
import com.baoli.spring.entity.User;
import com.baoli.spring.service.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 * @program: common-demo
 * @description: user
 * @author: li baojian
 * @create: 2020-03-19 17:40
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User> implements UserService {
    @Override
    public User updateUser(User user) {
        return this.updateUser(user);
    }
}
