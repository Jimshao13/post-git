package com.post.db.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 邵鹏泽
 * @create 2021-01-23:20
 */
@ApiModel(description= "用户类")
@Data
public class User {
    private String id;
    private String userName;
    private String passWd;
    private String phoneNumber;
    @ApiModelProperty(value="用户所属的权限类别",required = true)
    private Integer category;
}
