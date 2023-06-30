package com.ymsd.service;

import com.ymsd.entity.User;

import java.util.List;

public interface UserService {
    List<User> userlist();

    User userById(Integer id);
}
