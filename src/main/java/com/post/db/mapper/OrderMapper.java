package com.post.db.mapper;

import com.post.db.entity.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    //添加订单
    void save(Order order);

    //删除订单
    void delete(String id);


    //修改订单呢
    void update(Order order);

    //查看所有订单
    List<Order> findAll();
}
