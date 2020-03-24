package com.baoli.spring.api;

import com.baoli.spring.common.base.service.BaseService;
import com.baoli.spring.entity.User;

public interface UserService extends BaseService<User> {
    User updateUser(User user);

    User saveUser(User user);

    void deleteUser(String uuid);

    User getUser(String uuid);
}
