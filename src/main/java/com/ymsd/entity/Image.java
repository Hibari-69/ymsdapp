package com.ymsd.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@ApiModel
@Data
public class Image {
    @ApiModelProperty("id主键")
    private Long id;
    @ApiModelProperty("属性")
    private String itype;
    @ApiModelProperty("图片路径")
    private String iurl;

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", itype='" + itype + '\'' +
                ", iurl='" + iurl + '\'' +
                '}';
    }
}
