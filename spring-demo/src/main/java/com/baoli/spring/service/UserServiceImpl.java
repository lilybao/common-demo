package com.baoli.spring.service;

import com.baoli.spring.api.UserService;
import com.baoli.spring.common.base.service.impl.BaseServiceImpl;
import com.baoli.spring.entity.User;
import com.baoli.spring.service.mapper.UserMapper;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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

    @CachePut(value = "user", key = "#user.uuid")
    public User saveUser(User user) {
        this.save(user);
        logger.info("存储到数据库");
        return user;
    }

    @CacheEvict(value = "user",key = "#uuid")
    public void deleteUser(String uuid) {
        logger.info("数据库中delete");
        this.removeById(uuid);
    }

    @Cacheable(value = "user",key = "#uuid")
    public User getUser(String uuid) {
        logger.info("从数据库中获取对象");
        return this.getById(uuid);
    }


}
