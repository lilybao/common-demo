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
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: common-demo
 * @description: user
 * @author: li baojian
 * @create: 2020-03-19 17:38
 */
@RestController
@RequestMapping("/user")
@Api(value = "用户",tags = "用户管理")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;
    @ApiOperation("用户新增")
    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData save(@RequestBody User user){
        userService.save(user);
        return  new ResultData(true);
    }
    @PutMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData update(User user){
       User users = userService.updateUser(user);
        return  new ResultData(true);
    }
    @DeleteMapping("/users/{id}")
    public ResultData delete(String id){
        boolean b = userService.removeById(id);
        return  new ResultData(b);
    }
    @ApiModelProperty
    @GetMapping("/users/")
    public ResultData list(){
        List<User> list = userService.list();
        return  new ResultData(list);
    }
    @ApiModelProperty
    @GetMapping("/users/{id}")
    public ResultData listById(String id){
        User user = userService.getById(id);
        return  new ResultData(user);
    }
}
