package com.post.db.service;

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
    public Integer arrivalsToday() {
        return predictMapper.arrivalsToday();
    }
}
