package com.ymsd.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserRegisterDTO {
    @NotBlank(message = "电话号码不能为空")
    @Size(min=11,max=11)
    private String utell;
    @NotBlank(message = "密码错误")
    private String upwd;
}
