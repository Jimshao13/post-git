package com.post.db.service;

import com.post.db.entity.Order;

import java.util.List;

/**
 * @author 邵鹏泽
 * @create 2021-03-14:37
 */
public interface OrderService {

    //添加订单
    void save(Order order);

    //删除订单
    void delete(String id);

    //修改订单呢
    void update(Order order);

    //查看所有订单
    List<Order> findAll();

    //查看今日揽件量
    Integer orderNum();
}
