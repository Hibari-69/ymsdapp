package com.ymsd.service.impl;

import com.ymsd.dao.ImageDao;
import com.ymsd.dao.UserDao;
import com.ymsd.entity.User;
import com.ymsd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public List<User> userlist() {
        List<User> userlist = userDao.userlist();
        return userlist;
    }

    @Override
    public User userById(Integer id) {
        User user = userDao.userById(id);
        return user;
    }
}
