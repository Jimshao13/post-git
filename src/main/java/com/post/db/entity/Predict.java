package com.post.db.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author 邵鹏泽
 * @create 2021-05-21:52
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain=true)
public class Predict {

    private String id;
    private String originId;
    private String destinctionId;
    private String expressCompany;
    private Date startTime;


}
