package com.post.db.mapper;

import com.post.db.entity.POutLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface POutLogMapper {

    //插入出库记录
    void save(POutLog pOutLog);
}
