package com.post.db.mapper;

import com.post.db.entity.Reservation;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 邵鹏泽
 * @create 2021-03-22:52
 */
@Mapper
public interface ReservationMapper {
    //添加预约
    void save(Reservation reservation);
}
