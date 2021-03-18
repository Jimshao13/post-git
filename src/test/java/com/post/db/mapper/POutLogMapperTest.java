package com.post.db.mapper;

import com.post.db.entity.POutLog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 邵鹏泽
 * @create 2021-03-20:31
 */
@SpringBootTest
class POutLogMapperTest {
    @Autowired
    POutLogMapper pOutLogMapper;

    @Test
    void save(){
        POutLog pOutLog=new POutLog();
        pOutLog.setLocation("1001-1");
        pOutLog.setCurDate(new Date());
        pOutLog.setPackId("11111111111");
        pOutLog.setStation(1);
        pOutLogMapper.save(pOutLog);
    }


}