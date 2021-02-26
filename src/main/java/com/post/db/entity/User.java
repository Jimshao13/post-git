package com.post.db.entity;

import lombok.Data;

/**
 * @author 邵鹏泽
 * @create 2021-01-23:20
 */
@Data
public class User {
    private String id;
    private String userName;
    private String passwd;
    private String phoneNumber;
    private Integer category;
}
