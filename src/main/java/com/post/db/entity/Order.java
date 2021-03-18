package com.post.db.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 邵鹏泽
 * @create 2021-02-21:53
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String packId;
    private String id;
    private String sender;
    private String senderAddress;
    private String senderPhone;
    private String receiver;
    private String receiverAddress;
    private String receiverPhone;

    private int expressCompany;
    //快递品牌映射
    private String expressName;
    private int category;
    //快递所属类别映射
    private String categoryName;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date orderTime;
}
