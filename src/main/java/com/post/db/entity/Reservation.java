package com.post.db.entity;

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
public class Reservation {
    String id;
    String packId;
    Date curDate;
    String name;
    String phoneNumber;
    String address;
}
