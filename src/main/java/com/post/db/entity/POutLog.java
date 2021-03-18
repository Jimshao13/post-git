package com.post.db.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author 邵鹏泽
 * @create 2021-01-14:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class POutLog {
    private String id;
    private String packId;
    private Date curDate;
    private int station;
    private String location;
}
