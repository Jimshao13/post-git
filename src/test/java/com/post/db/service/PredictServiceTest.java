package com.post.db.service;


import com.post.db.entity.Predict;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
public class PredictServiceTest {
    @Autowired
    private PredictService predictService;

    @Test
    public void arrivalsToday(){
        Integer arrivalsToday = predictService.arrivalsToday();
        System.out.println(arrivalsToday);
    }

    @Test
    public void arrivalsTomorrow(){
        Integer arrivalsTomorrow = predictService.arrivalsTomorrow();
        System.out.println(arrivalsTomorrow);
    }

    @Test
    public void arrivalsAfterTomorrow(){
        Integer arrivalsAfterTomorrow = predictService.arrivalsAfterTomorrow();
        System.out.println(arrivalsAfterTomorrow);
    }

    @Test
    public void testAddData() throws ParseException {
        Predict predict=new Predict();
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2021-05-19");
        predict.setOriginId("440000").setDestinctionId("320000").setStartTime(date).setExpressCompany("4");

        for(int i=1;i<=70;i++){
            predictService.addData(predict);
        }
    }


}
