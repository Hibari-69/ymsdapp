package com.ymsd.dao;

import com.ymsd.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao {
   // @Select("select * from ymapp.user")
    List<User> userlist();

    User userById(Integer id);
}
