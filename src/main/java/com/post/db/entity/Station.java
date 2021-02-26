package com.post.db.entity;

import lombok.Data;

/**
 * @author 邵鹏泽
 * @create 2021-01-23:38
 */
@Data
public class Station {
    private String id;
    private String stationName;
    //驿站容量
    private String capacity;
    private String address;
    //区号
    private String areaId;
    //经度
    private Double longitude;
    //纬度
    private Double latitude;

    //所在省市区
    private String location;
    private String contactPerson;
    private String contactNumber;



}
