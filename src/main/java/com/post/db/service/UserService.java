package com.post.db.service;

import com.post.db.entity.User;

/**
 * @author 邵鹏泽
 * @create 2021-01-16:02
 */
public interface UserService {
    //用户注册
    void register(User user);

    //用户登录
    User login(User user);
}
