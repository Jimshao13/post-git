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

    //查询顺丰今日到达的件量
    Integer todaySF();

    //预测顺丰明日到达的件量
    Integer tomorrowSF();

    //预测顺丰后天将到达的件量
    Integer afterTomorrowSF();

    //预测圆通今日到达的件量
    Integer todayYT();

    //预测圆通明日到达的件量
    Integer tomorrowYT();

    //预测圆通后天将到达的件量
    Integer afterTomorrowYT();

    //预测中通今日到达的件量
    Integer todayZT();

    //预测中通明日到达的件量
    Integer tomorrowZT();

    //预测中通后天将到达的件量
    Integer afterTomorrowZT();

    //预测申通今日到达的件量
    Integer todayST();

    //预测申通明日到达的件量
    Integer tomorrowST();

    //预测申通后天将到达的件量
    Integer afterTomorrowST();

    //预测韵达今日到达的件量
    Integer todayYD();

    //预测韵达明日到达的件量
    Integer tomorrowYD();

    //预测韵达后天将到达的件量
    Integer afterTomorrowYD();

    //预测京东今日到达的件量
    Integer todayJD();

    //预测京东明日到达的件量
    Integer tomorrowJD();

    //预测京东后天将到达的件量
    Integer afterTomorrowJD();


    //预测邮政今日到达的件量
    Integer todayYZ();

    //预测邮政明日到达的件量
    Integer tomorrowYZ();

    //预测邮政后天将到达的件量
    Integer afterTomorrowYZ();


    //预测百世汇通今日到达的件量
    Integer todayHT();

    //预测汇通明日到达的件量
    Integer tomorrowHT();

    //预测汇通后天将到达的件量
    Integer afterTomorrowHT();



}
