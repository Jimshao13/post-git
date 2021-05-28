package com.post.db.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author 邵鹏泽
 * @create 2021-05-11:11
 */
@SpringBootTest
public class PredictMapperTest {
    @Autowired
    PredictMapper predictMapper;

    @Test
    public void testArrivals(){
        Integer todaySF = predictMapper.todaySF();
        System.out.println(todaySF);

        Integer tomorrowYT = predictMapper.tomorrowYT();
        System.out.println(tomorrowYT);

        Integer aftertomorrowZT = predictMapper.afterTomorrowZT();
        System.out.println(aftertomorrowZT);

        Integer todayST = predictMapper.todayST();
        System.out.println(todaySF);

        Integer aftertomorrowYD = predictMapper.afterTomorrowYD();
        System.out.println(aftertomorrowYD);


    }
}
