package com.post.db.mapper;

import com.post.db.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 邵鹏泽
 * @create 2021-01-16:00
 */
@Mapper
public interface UserMapper {
    void save(User user);

    User findByPhone(String phoneNumber);

}
