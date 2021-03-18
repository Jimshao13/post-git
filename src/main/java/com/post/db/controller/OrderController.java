package com.post.db.controller;

import com.post.db.entity.Order;
import com.post.db.entity.Package;
import com.post.db.entity.User;
import com.post.db.service.OrderService;
import com.post.db.utils.GetCodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin//允许跨域
@RequestMapping("/order")
@Slf4j//利用@Sel4j注解，快速打印日志信息
public class OrderController {
    @Autowired
    OrderService orderService;

    //添加寄件订单
    @PostMapping("/save")
    public Map<String,Object> save(@RequestBody Order order){
        Map<String,Object>map=new HashMap<>();
        try {
            String packId= GetCodeUtils.getCode(13,0);
            Date date=new Date();
            order.setOrderTime(date);
            order.setPackId(packId);
            orderService.save(order);
            map.put("status",true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",false);
        }
        return map;
    }

    /*分页查询方法*/
    @GetMapping("/findMyOrder")
    public Map<String,Object> findMyOrder(Integer pageNow,Integer pageSize,String senderPhone){
        Map<String,Object> result=new HashMap<>();

        pageNow=pageNow==null?1:pageNow;
        pageSize=pageSize==null?6:pageSize;

        List<Order> orders = orderService.findMyOrder(pageNow, pageSize,senderPhone);
        Long totals = orderService.findMyOrderTotals(senderPhone);
        result.put("orders",orders);
        result.put("total",totals);
        return result;
    }


    @GetMapping("/delete")
    public Map<String,Object> delete(String packId){
        Map<String,Object> result=new HashMap<>();
        try{
            orderService.delete(packId);
            result.put("status",true);
        }catch(Exception e){
            e.printStackTrace();
            result.put("status",false);
        }
        return result;
    }







}
