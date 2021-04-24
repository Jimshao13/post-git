package com.post.db.service;

import com.post.db.entity.Order;
import com.post.db.entity.Package;

import java.util.List;

/**
 * @author 邵鹏泽
 * @create 2021-03-14:37
 */
public interface OrderService {

    //添加订单
    void save(Order order);

    //删除订单
    void delete(String packId);

    //修改订单呢
    void update(Order order);

    //查看所有订单
    List<Order> findAll();

    //分页查询所有订单
    List<Order> findAllByPage(Integer pageNow, Integer rows);

    //查看今日揽件量
    Integer orderNum();

    //分页查询
    List<Order> findMyOrder(Integer pageNow, Integer rows, String senderPhone);

    //查询今日订单总量
    long findOrderTotals();

    //查询个人订单量
    long findMyOrderTotals(String senderPhone);

    //驿站全部接单
    void acceptAll();

    //驿站接受某订单
    void acceptOrder(String packId);

    //驿站或用户取消订单
    void cancelOrder(String packId);



}
