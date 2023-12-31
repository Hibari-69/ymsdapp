package com.ymsd.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserLoginDTO {

    @NotBlank(message = "电话号码不能为空")
    private String utell;

    @NotBlank(message = "密码错误")
    private String upwd;

}
