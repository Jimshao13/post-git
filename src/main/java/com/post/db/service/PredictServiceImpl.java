package com.post.db.service;

import com.post.db.entity.Predict;
import com.post.db.mapper.PredictMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 邵鹏泽
 * @create 2021-05-22:30
 */
@Service
public class PredictServiceImpl implements PredictService{
    @Autowired
    private PredictMapper predictMapper;

    @Override
    public void addData(Predict predict) {
        predictMapper.addData(predict);
    }

    @Override
    public Integer arrivalsToday() {
        return predictMapper.arrivalsToday();
    }

    @Override
    public Integer arrivalsTomorrow() {
        return predictMapper.arrivalsTomorrow();
    }

    @Override
    public Integer arrivalsAfterTomorrow() {
        return predictMapper.arrivalsAfterTomorrow();
    }

    @Override
    public Map<String, List<Integer>> arrivalsNum() {
        Map<String,List<Integer>> arrivalsNum=new HashMap<>();
        Integer todaySF = predictMapper.todaySF();
        Integer todayYZ = predictMapper.todayYZ();
        Integer todayJD = predictMapper.todayJD();
        Integer todayYT = predictMapper.todayYT();
        Integer todayZT = predictMapper.todayZT();
        Integer todayHT = predictMapper.todayHT();
        Integer todayST = predictMapper.todayST();
        Integer todayYD = predictMapper.todayYD();
        List<Integer> todayNum=new ArrayList<>();
        todayNum.add(todaySF);
        todayNum.add(todayYZ);
        todayNum.add(todayJD);
        todayNum.add(todayYT);
        todayNum.add(todayZT);
        todayNum.add(todayHT);
        todayNum.add(todayST);
        todayNum.add(todayYD);
        arrivalsNum.put("todayNum",todayNum);


        Integer tomorrowSF = predictMapper.tomorrowSF();
        Integer tomorrowYZ = predictMapper.tomorrowYZ();
        Integer tomorrowJD = predictMapper.tomorrowJD();
        Integer tomorrowYT = predictMapper.tomorrowYT();
        Integer tomorrowZT = predictMapper.tomorrowZT();
        Integer tomorrowHT = predictMapper.tomorrowHT();
        Integer tomorrowST = predictMapper.tomorrowST();
        Integer tomorrowYD = predictMapper.tomorrowYD();
        List<Integer> tomorrowNum=new ArrayList<>();
        tomorrowNum.add(tomorrowSF);
        tomorrowNum.add(tomorrowYZ);
        tomorrowNum.add(tomorrowJD);
        tomorrowNum.add(tomorrowYT);
        tomorrowNum.add(tomorrowZT);
        tomorrowNum.add(tomorrowHT);
        tomorrowNum.add(tomorrowST);
        tomorrowNum.add(tomorrowYD);
        arrivalsNum.put("tomorrowNum",tomorrowNum);





        Integer afterTomorrowSF = predictMapper.afterTomorrowSF();
        Integer afterTomorrowYZ = predictMapper.afterTomorrowYZ();
        Integer afterTomorrowJD = predictMapper.afterTomorrowJD();
        Integer afterTomorrowYT= predictMapper.afterTomorrowYT();
        Integer afterTomorrowZT = predictMapper.afterTomorrowZT();
        Integer afterTomorrowHT = predictMapper.afterTomorrowHT();
        Integer afterTomorrowST = predictMapper.afterTomorrowST();
        Integer afterTomorrowYD = predictMapper.afterTomorrowYD();
        List<Integer> afterTomorrowNum=new ArrayList<>();
        afterTomorrowNum.add(afterTomorrowSF);
        afterTomorrowNum.add(afterTomorrowYZ);
        afterTomorrowNum.add(afterTomorrowJD);
        afterTomorrowNum.add(afterTomorrowYT);
        afterTomorrowNum.add(afterTomorrowZT);
        afterTomorrowNum.add(afterTomorrowHT);
        afterTomorrowNum.add(afterTomorrowST);
        afterTomorrowNum.add(afterTomorrowYD);
        arrivalsNum.put("afterTomorrowNum",afterTomorrowNum);

        return arrivalsNum;
    }
}


