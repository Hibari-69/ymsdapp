package com.ymsd.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//通用返回
@ApiModel
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    @ApiModelProperty("状态码")
    private Integer code;

    @ApiModelProperty("信息")
    private String msg;

    @ApiModelProperty("数据")
    private T data;

    public Result success(){
        return new Result(200,"操作成功",null);
    }
    public Result success(T data){
        return new Result(200,"操作成功",data);
    }
    public Result error(String msg){
        return new Result(500,msg,null);
    }
    public Result error(Integer code,String msg){
        return new Result(code,msg,null);
    }
    public Result error(){
        return new Result(500,"系统错误，联系管理员",null);
    }
}
