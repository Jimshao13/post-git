package com.post.db.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 邵鹏泽
 * @create 2021-03-22:31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "无人车配送预约类")
public class Reservation {
    String id;
    @ApiModelProperty(value="无人车派送的快递单号")
    String packId;
    Date curDate;
    String name;
    String phoneNumber;
    String address;
}
