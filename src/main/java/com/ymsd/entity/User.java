package com.ymsd.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class User {
    @ApiModelProperty("账号")
    private Long id;
    @ApiModelProperty("用户名")
    private String uname;
    @ApiModelProperty("用户密码")
    private String upwd;

    @Override
    public String toString() {
        return "Username{" +
                "id=" + id +
                ", upwd='" + uname + '\'' +
                ", upwd='" + upwd + '\'' +
                '}';
    }
}
