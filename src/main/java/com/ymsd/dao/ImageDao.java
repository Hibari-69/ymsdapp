package com.ymsd.dao;

import com.ymsd.entity.Image;
import com.ymsd.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
public interface ImageDao {
   // @Select("select * from image")
    List<Image> list();

}
