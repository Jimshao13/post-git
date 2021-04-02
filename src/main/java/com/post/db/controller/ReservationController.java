package com.post.db.controller;

import com.post.db.entity.Reservation;
import com.post.db.service.ReservationService;
import com.post.db.utils.GetCodeUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 邵鹏泽
 * @create 2021-03-22:59
 */
@RestController
@CrossOrigin//允许跨域
@RequestMapping("/reserve")
@Slf4j//利用@Sel4j注解，快速打印日志信息
@Api(tags = "无人车配送预约接口")
public class ReservationController {
    @Autowired
    ReservationService reservationService;

    @PostMapping("/save")
    @ApiOperation(value="对特定快递单号的快递进行无人车的预约配送")
    public Map<String,Object> save(@RequestBody Reservation reservation){
        Map<String,Object> map=new HashMap<>();
        try {
            reservationService.save(reservation);
            map.put("status",true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",false);
        }
        return map;
    }

}
