package com.lisy.mapper;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lisy.entity.User;

/**
 * mybaits 接口映射
 */
// @Mapper
public interface UserMapper {
    User findByUserId(int id);
    boolean addUser(User user);
}
