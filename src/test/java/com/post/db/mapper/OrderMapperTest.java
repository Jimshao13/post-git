package com.post.db.mapper;

import com.post.db.entity.Order;
import com.post.db.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 邵鹏泽
 * @create 2021-03-15:28
 */
@SpringBootTest
class OrderMapperTest {
    @Autowired
    OrderService orderService;

    @Test
    void save() {
        Order order=new Order();
        order.setSender("小明");
        order.setSenderAddress("南京市");
        order.setSenderPhone("18856723432");
        order.setReceiver("小红");
        order.setReceiverPhone("12345326732");
        order.setReceiverAddress("南通市");
        order.setCategory(502);
        order.setExpressCompany(1);
        orderService.save(order);
    }


    @Test
    void delete() {
        orderService.delete("3");
    }

    @Test
    void update() {
    }

    @Test
    void findAll() {
        List<Order> orders = orderService.findAll();
        System.out.println(orders);
    }

    @Test
    void orderNum(){
        Integer integer = orderService.orderNum();
        System.out.println(integer);
    }
}