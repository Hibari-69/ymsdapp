package com.ymsd.controller;

import com.ymsd.common.Result;
import com.ymsd.entity.Image;
import com.ymsd.service.ImageService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
@ApiModel
@RestController //ImageController
public class ImageControaller {
    /**
     * 需求 读取数据库 image数据
     */
    @Resource
    private ImageService imageService;


    @ApiModelProperty(value="图片列表接口",notes = "图片列表接口")
    @GetMapping("/imageList")
    public List<Image> imageList(){
        List<Image> list= imageService.list();
        System.out.println(list.toString());
        return list;
    }
    @ApiModelProperty(value="图片列表接口",notes = "图片列表接口")
    @GetMapping("/imageListT")
    public Result<List<Image>> imageListT(){
        List<Image> list= imageService.list();
        return new Result<>().success(list);
    }
    @ApiModelProperty(value = "测试失败接口",notes = "测试失败列表接口")
    @GetMapping("/test22")
    public Result test22(){
        return new Result<>().error();
    }

}
