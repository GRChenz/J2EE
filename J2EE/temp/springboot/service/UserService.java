package com.example.springboot.service;/*
    @author GRChen
    2023/6/6 0006
*/

import com.example.springboot.entity.User;
import com.example.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public int save(User user){
        if(user.getId()==null){  //user无ID表示新增,否则为更新
            return userMapper.insert(user);
        }else{
            return userMapper.update(user);
        }

    }
}
