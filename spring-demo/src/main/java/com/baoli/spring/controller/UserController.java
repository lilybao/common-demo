package com.baoli.spring.controller;

import com.baoli.spring.api.UserService;
import com.baoli.spring.common.base.controller.BaseController;
import com.baoli.spring.common.util.ResultData;
import com.baoli.spring.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @program: common-demo
 * @description: user
 * @author: li baojian
 * @create: 2020-03-19 17:38
 */
@RestController
@RequestMapping("/user")
@Api(value = "用户", tags = "用户管理")
public class UserController extends BaseController {


    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    @Autowired
    private UserService userService;


    @RequestMapping("/test")
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData test() {
        User user1 = new User();
        user1.setAge("12");
        user1.setName("lisi");
        redisTemplate.opsForValue().set("userKey",user1);
        redisTemplate.opsForHash().putIfAbsent("123","1","e");
        redisTemplate.opsForHash().putIfAbsent("123","2","e");
        User user = (User) redisTemplate.opsForValue().get("userKey");
        Map<Object, Object> map = redisTemplate.opsForHash().entries("123");
        System.out.println(user.toString());
        return new ResultData(user);
    }

    @RequestMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData add() {
        User user = new User();
        user.setName("zhangsan");
        user.setAge("23");
        userService.saveUser(user);
        return new ResultData(user);
    }

    @RequestMapping("/get/{uuid}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData get(@PathVariable("uuid") String uuid) {
        User user = userService.getUser(uuid);
        return new ResultData(user);
    }

    @RequestMapping("/remove/{uuid}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData remove(@PathVariable("uuid")String uuid) {
        userService.deleteUser(uuid);
        return new ResultData(true);
    }


    @ApiOperation("用户新增")
    @RequestMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData save(@RequestBody User user) {
        userService.save(user);
        return new ResultData(true);
    }

    @PutMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData update(User user) {
        User users = userService.updateUser(user);
        return new ResultData(true);
    }

    @DeleteMapping("/users/{id}")
    public ResultData delete(String id) {
        boolean b = userService.removeById(id);
        return new ResultData(b);
    }

    @ApiModelProperty
    @GetMapping("/users/")
    public ResultData list() {
        List<User> list = userService.list();
        return new ResultData(list);
    }

    @ApiModelProperty
    @GetMapping("/users/{id}")
    public ResultData listById(String id) {
        User user = userService.getById(id);
        return new ResultData(user);
    }
}
