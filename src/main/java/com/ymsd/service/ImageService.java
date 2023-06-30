package com.ymsd.service;

import com.ymsd.entity.Image;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ImageService
{
    List<Image> list();
}



