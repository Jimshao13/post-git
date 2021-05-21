package com.post.db.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author 邵鹏泽
 * @create 2021-05-22:00
 */
@Mapper
public interface PredictMapper {
    //查询今日预计到达的快递
     Integer arrivalsToday();
}
