package com.post.db.service;

import com.post.db.entity.Station;

import java.util.List;

/**
 * @author 邵鹏泽
 * @create 2021-02-18:02
 */
public interface StationService {
    //查询所有驿站信息
    List<Station> findAll();

    //分页查询
    List<Station> findByPage(Integer pageNow, Integer rows);

    //查询总条数
    Long findTotals();

    //添加驿站
    void save(Station station);

    //根据id删除驿站
    void delete(String id);

    //根据id 修改驿站信息
    void update(Station station);

}
