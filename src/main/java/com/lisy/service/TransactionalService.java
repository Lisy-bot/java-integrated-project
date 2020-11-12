package com.lisy.service;

import com.lisy.common.result.ResultBody;
import com.lisy.entity.User;
import com.lisy.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @transactional 注解
 */
@Service
public class TransactionalService {
    @Autowired
    UserMapper userMapper;


    public ResultBody addUser(User user){
        return ResultBody.success(userMapper.addUser(user));
    }
}
