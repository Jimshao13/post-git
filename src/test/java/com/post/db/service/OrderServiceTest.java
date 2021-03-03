package com.post.db.service;

import com.post.db.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class OrderServiceTest {
    @Autowired
    OrderService orderService;

    @Test
    void save() {
        Order order=new Order();
        order.setSender("小明");
        order.setReceiver("小红");
        order.setSenderAddress("江苏省连云港市赣榆区");
        order.setReceiverAddress("江苏省南通市幸福花园小区");
        order.setSenderPhone("15240326617");
        order.setReceiverPhone("12345678213");
        order.setExpressCompany(1);
        order.setCategory(501);
        orderService.save(order);
    }

    @Test
    void delete() {
    }

    @Test
    void update() {
    }

    @Test
    void findAll() {
        List<Order> orders = orderService.findAll();
        System.out.println(orders);
    }
}