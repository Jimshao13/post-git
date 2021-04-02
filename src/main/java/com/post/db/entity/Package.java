package com.post.db.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author 邵鹏泽
 * @create 2021-01-23:30
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "快递类")
public class Package {
    private String id;
    //快递单号
    private String packId;
    private String receiverPhone;
    @ApiModelProperty(value = "快递品牌的数字代号")
    private int expressCompany;
    //快递品牌映射
    @ApiModelProperty(value="快递品牌名")
    private String expressName;
    //快递图片
    private String path;

    //短信状态
    @ApiModelProperty(value="短信状态数字代号")
    private int msgStatus;
    //短信状态映射
    @ApiModelProperty(value="短信状态映射")
    private String m_status;
    //所在驿站
    private int station;
    //驿站名映射
    @ApiModelProperty(value="驿站名映射")
    private String stationName;
    //取件码，货架号
    private String pickUpCode;
    //快递状态
    private int status;
    //快递状态映射
    @ApiModelProperty(value="快递状态映射")
    private String s_status;


    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value="入库时间")
    private Date putInTime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value="取件时间")
    private Date pickUpTime;

}
