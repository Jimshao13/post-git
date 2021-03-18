package com.post.db.service;

import com.post.db.entity.User;
import com.post.db.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

/**
 * @author 邵鹏泽
 * @create 2021-01-16:02
 */
@Service
@Transactional//事务控制
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public void register(User user) {
        //0.根据用户输入的用户名判断用户是否存在
        User userDB = userMapper.findByPhone(user.getPhoneNumber());
        if (userDB == null) {
            //1、设置用户所属类别
            user.setCategory(0);
            //2、调用Mapper
            userMapper.save(user);
        }else{
            throw new RuntimeException("该手机号用户已存在");
        }
    }

    @Override
    public User login(User user) {
        //1、根据用户输入的电话号码进行查询
        User userDB = userMapper.findByPhone(user.getPhoneNumber());
        if(!ObjectUtils.isEmpty(userDB)){//判断实体类是否为空
            //2、比较密码
            if(userDB.getPassWd().equals(user.getPassWd())){
                return userDB;
            }else{
                throw new RuntimeException("密码输入不正确");
            }
        }else{
            throw new RuntimeException("手机号码输入错误");
        }

    }
}
