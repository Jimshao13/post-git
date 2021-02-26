package com.post.db.service;

import com.post.db.entity.POutLog;
import com.post.db.mapper.POutLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 邵鹏泽
 * @create 2021-02-19:05
 */
@Service
public class POutLogServiceImpl implements POutLogService {
    @Autowired
    POutLogMapper pOutLogMapper;
    @Override
    public void save(POutLog pOutLog) {
        pOutLogMapper.save(pOutLog);
    }
}
