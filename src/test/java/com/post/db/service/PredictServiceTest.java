package com.post.db.service;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PredictServiceTest {
    @Autowired
    private PredictService predictService;

    @Test
    public void arrivalsToday(){
        Integer arrivalsToday = predictService.arrivalsToday();
        System.out.println(arrivalsToday);
    }

}
