package com.post.db.mapper;

import com.post.db.entity.Predict;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 邵鹏泽
 * @create 2021-05-22:00
 */
@Mapper
public interface PredictMapper {

    //插入数据
    void addData(Predict predict);

    //查询今日预计到达的快递
     Integer arrivalsToday();

    //查询明日预计到达的快递
    Integer arrivalsTomorrow();

    //查询后天预计到达的快递
    Integer arrivalsAfterTomorrow();



}
