package com.baoli.spring.common.util;

import com.baoli.spring.api.UserService;
import com.baoli.spring.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: common-demo
 * @description: redisTemplate工具
 * @author: li baojian
 * @create: 2020-03-25 11:41
 */
@Component
public class RedisTemplateUtil {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private final ReentrantLock reentrantLock = new ReentrantLock();

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    public  Serializable getUserValue(String key) {
//        logger.info("尝试获取缓存"+key);
        Serializable result = redisTemplate.opsForValue().get(key);
        if (StringUtils.isEmpty(result)) {
            try {
                if (reentrantLock.tryLock()) {
                    logger.info("从数据中获取"+key);
                    User user = userService.getById(key);
                    if (user == null) {
                        return null;
                    }
                    redisTemplate.opsForValue().set(key, user);
                    result = redisTemplate.opsForValue().get(key);
                } else {
                    Thread.sleep(200);
                    result = getUserValue(key);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        }
        return result;
    }
}
