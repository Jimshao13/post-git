package com.post.db.service;

import com.post.db.entity.Station;
import com.post.db.mapper.StationMapper;
import com.post.db.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 邵鹏泽
 * @create 2021-02-18:03
 */
@Service
public class StationServiceImpl implements StationService{

    @Autowired
    StationMapper stationMapper;

    //查询所有驿站信息
    @Override
    public List<Station> findAll() {
        return stationMapper.findAll();
    }

    //分页查询驿站信息
    @Override
    public List<Station> findByPage(Integer pageNow, Integer rows) {
        int start=(pageNow-1)*rows;//由当前页及每页的条数，得到当前查询的起始条数位置
        return stationMapper.findByPage(start,rows);
    }

    //查询驿站总数
    @Override
    public Long findTotals() {
        return stationMapper.findTotals();
    }

    //添加驿站
    @Override
    public void save(Station station) {
        stationMapper.save(station);
    }

    //删除驿站
    @Override
    public void delete(String id) {
        stationMapper.delete(id);
    }

    //修改驿站信息
    @Override
    public void update(Station station) {
        stationMapper.update(station);
    }
}
