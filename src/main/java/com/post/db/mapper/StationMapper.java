package com.post.db.mapper;

import com.post.db.entity.Station;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 邵鹏泽
 * @create 2021-02-17:59
 */
@Mapper
public interface StationMapper {
    //查询所有驿站信息
    List<Station> findAll();

    //分页查询,注意进行参数绑定
    List<Station> findByPage(@Param("start") Integer start, @Param("rows") Integer rows);

    //查询总条数
    Long findTotals();

    //添加驿站
    void save(Station station);

    //根据id删除驿站
    void delete(String id);

    //根据id 修改驿站信息
    void update(Station station);





}
