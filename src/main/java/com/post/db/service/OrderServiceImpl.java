package com.post.db.service;

import com.post.db.entity.Order;
import com.post.db.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author 邵鹏泽
 * @create 2021-03-14:38
 */
@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    OrderMapper orderMapper;

    @Override
    public void save(Order order) {
        Date date=new Date();
        order.setOrderTime(date);
        orderMapper.save(order);
    }

    @Override
    public void delete(String id) {
        orderMapper.delete(id);
    }

    @Override
    public void update(Order order){
        orderMapper.update(order);
    }

    @Override
    public List<Order> findAll() {
        return orderMapper.findAll();
    }

    @Override
    public Integer orderNum() {
        return orderMapper.orderNum();
    }
}
