package com.post.db.service;

import com.post.db.entity.Predict;

import java.util.List;
import java.util.Map;

/**
 * @author 邵鹏泽
 * @create 2021-05-22:29
 */
public interface PredictService {

    //插入数据
    void addData(Predict predict);

    //查询今日预计到达的快递
    Integer arrivalsToday();


    //查询明日预计到达的快递
    Integer arrivalsTomorrow();

    //查询后天预计到达的快递
    Integer arrivalsAfterTomorrow();

    //预测各家快递公司到达的数量
    Map<String, List<Integer>> arrivalsNum();

}
