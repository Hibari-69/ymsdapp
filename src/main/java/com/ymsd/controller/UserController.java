package com.ymsd.controller;

import com.ymsd.entity.User;
import com.ymsd.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {
    /**
     *  获取数据库中 用户数据
     */
    @Resource
    private UserService userService;

    @GetMapping("/userList")
    public Object userList(){
        List<User> userlist=userService.userlist();
        return userlist;
    }
    @GetMapping("/userById")
    public User userById(){
        Integer a=12;
        User userById = userService.userById(a);
        return userById;
    }




}
