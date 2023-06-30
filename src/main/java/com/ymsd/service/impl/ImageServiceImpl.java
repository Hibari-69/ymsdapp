package com.ymsd.service.impl;

import com.ymsd.dao.ImageDao;
import com.ymsd.entity.Image;
import com.ymsd.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageDao imageDao;

    @Override
    public List<Image> list() {
        List<Image> list = imageDao.list();
        return list;
    }
}
