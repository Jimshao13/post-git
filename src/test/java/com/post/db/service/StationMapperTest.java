package com.post.db.service;

import com.post.db.entity.Station;
import com.post.db.service.StationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 邵鹏泽
 * @create 2021-02-18:10
 */
@SpringBootTest
class StationMapperTest {
    @Autowired
    StationService stationService;

    @Test
    void findAll() {
        List<Station> stations = stationService.findAll();
        System.out.println(stations);
    }

    @Test
    void delete(){
        stationService.delete("20009");
    }


    @Test
    void save(){
        Station station=new Station();
        station.setLatitude(1.0);
        station.setStationName("测试 2");
        station.setLongitude(2.0);
        station.setAddress("柘汪");
        station.setCapacity("100");
        station.setContactPerson("王宝强");
        station.setContactNumber("123456543");
        stationService.save(station);
    }

    @Test
    void update(){
        Station station=new Station();
        station.setId("10");
        station.setLatitude(1.0);
        station.setStationName("测试 2");
        station.setLongitude(2.0);
        station.setAddress("柘汪");
        station.setCapacity("100");
        station.setContactPerson("王宝强");
        station.setContactNumber("123456543");
        stationService.update(station);

    }
}