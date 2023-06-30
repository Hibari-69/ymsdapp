package com.ymsd.controller;

import com.sun.corba.se.spi.ior.ObjectAdapterId;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//以json 形式进行数据返回

@RestController  //@RestController等于 @Controller+@ResponseBody
//方法一：添加注解 使用@CrossOrigin 解决跨域问题
//@CrossOrigin
public class TestController {
    /*
    通过注解获取 application.yml 中的配置项
     */
    @Value("${server.port}")
    private Integer port;

    @Value("${text}")
    private String text;
    @Value("${banner1}")
    private String banner1;

    @Value("${banner2}")
    private String banner2;

    /*
    GetMapping 表示的是一个get 请求 ，请求路径为：/test
    返回一个String 字符串
     */
    @GetMapping("/test")
    public String test(){
        return "源码时代";
    }

    @GetMapping("/yml")
    public Integer yml(){
        return port;
    }
    @GetMapping("/testYHL")
    public String testYHL(){
        return text;
    }

    @GetMapping("/banner")
    public Object banner(){
        List<Object> list=new ArrayList<>();
        HashMap<String,String> map=new HashMap<>();
        map.put("img",banner1);
        HashMap<String,String> map2=new HashMap<>();
        map2.put("img",banner2);
        list.add(map);
        list.add(map2);
        //ToDo
        return list;
    }
}
