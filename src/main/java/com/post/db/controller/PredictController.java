package com.post.db.controller;

import com.post.db.service.PredictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 邵鹏泽
 * @create 2021-05-22:46
 */
@RestController
@RequestMapping("/predict")
public class PredictController {
    @Autowired
    private PredictService predictService;

    @GetMapping("/arrivalsDayNum")
    public Map<String,Integer> arrivalsPredict(){
        Integer arrivalsToday = predictService.arrivalsToday();
        Integer arrivalsTomorrow = predictService.arrivalsTomorrow();
        Integer arrivalsAfterTomorrow = predictService.arrivalsAfterTomorrow();
        Map<String,Integer> map=new HashMap<>();
        map.put("arrivalsToday",arrivalsToday);
        map.put("arrivalsTomorrow",arrivalsTomorrow);
        map.put("arrivalsAfterTomorrow",arrivalsAfterTomorrow);
        return map;
    }

    @GetMapping("/arrivalsBrandNum")
    public Map<String, List<Integer>> arrivalsNum(){
        return predictService.arrivalsNum();
    }
}
