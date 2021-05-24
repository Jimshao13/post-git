package com.post.db.service;

import com.post.db.entity.Predict;
import com.post.db.mapper.PredictMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
