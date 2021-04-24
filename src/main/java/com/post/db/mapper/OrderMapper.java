package com.post.db.mapper;

import com.post.db.entity.Order;
import com.post.db.entity.Package;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {
    //添加订单
    void save(Order order);

    //删除订单
    void delete(String packId);

    //修改订单呢
    void update(Order order);

    //查看所有订单
    List<Order> findAll();

    //分页查看所有代接订单
    List<Order> findAllByPage(@Param("start") Integer start, @Param("rows") Integer rows);

    //查看今日揽件量
    Integer orderNum();

    //分页查询个人全部订单
    List<Order> findMyOrder(@Param("start") Integer start, @Param("rows") Integer rows, @Param("senderPhone")String senderPhone);

    //查询代接订单总量
    long findOrderTotals();

    //查询个人订单量
    long findMyOrderTotals(String senderPhone);

}
