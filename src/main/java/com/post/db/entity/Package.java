package com.post.db.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 邵鹏泽
 * @create 2021-01-23:30
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Package {
    private String id;
    //快递单号
    private String packId;
    private String receiverPhone;
    private int expressCompany;
    //快递品牌映射
    private String expressName;
    //快递图片
    private String path;

    //短信状态
    private int msgStatus;
    //短信状态映射
    private String m_status;
    //所在驿站
    private int station;
    //驿站名映射
    private String stationName;
    //取件码，货架号
    private String pickUpCode;
    //快递状态
    private int status;
    //快递状态映射
    private String s_status;


    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date putInTime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date pickUpTime;

}
