package com.post.db.service;

import com.post.db.entity.Order;
import com.post.db.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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

    //添加订单
    @Override
    public void save(Order order) {
        orderMapper.save(order);
    }

    //删除订单
    @Override
    public void delete(String packId) {
        orderMapper.delete(packId);
    }

    //修改订单
    @Override
    public void update(Order order){
        orderMapper.update(order);
    }

    //查询所有订单列表
    @Override
    public List<Order> findAll() {
        return orderMapper.findAll();
    }

    //分页查询所有代接订单
    @Override
    public List<Order> findAllByPage(Integer pageNow, Integer rows) {

        int start=(pageNow-1)*rows;//由当前页及每页的条数，得到当前查询的起始条数位置
        return orderMapper.findAllByPage(start,rows);
    }

    //查询订单数量
    @Override
    public Integer orderNum() {
        return orderMapper.orderNum();
    }

    //查询我的订单
    @Override
    public List<Order> findMyOrder(Integer pageNow, Integer rows, String senderPhone) {
        int start=(pageNow-1)*rows;//由当前页及每页的条数，得到当前查询的起始条数位置
        return orderMapper.findMyOrder(start,rows,senderPhone);
    }

    //查询代接订单总量
    @Override
    public long findOrderTotals() {
        return orderMapper.findOrderTotals();
    }

    //查询我的订单总量
    @Override
    public long findMyOrderTotals(String senderPhone) {
        return orderMapper.findMyOrderTotals(senderPhone);
    }
}
