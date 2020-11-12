package com.lisy.service;

import com.lisy.entity.User;
import com.lisy.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("ALL")
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public User fingById(int userId){
        return userMapper.findByUserId(userId);
    }
    public boolean addUser(User user){
        return userMapper.addUser(user);
    }
}
