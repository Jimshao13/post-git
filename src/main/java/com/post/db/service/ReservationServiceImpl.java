package com.post.db.service;

import com.post.db.entity.Reservation;
import com.post.db.mapper.ReservationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 邵鹏泽
 * @create 2021-03-22:54
 */
@Service
public class ReservationServiceImpl implements ReservationService{
    @Autowired
    ReservationMapper reservationMapper;


    @Override
    public void save(Reservation reservation) {
        reservationMapper.save(reservation);
    }
}
