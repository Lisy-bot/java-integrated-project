package com.lisy.mapper;

import com.lisy.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Auto: Lisy
 * @Date: 2020-16
 * @Description: pagehelper 分页插件使用注解
 * @Version: 1.0
 */
@Mapper
public interface ExtPagehelper {
    @Select("select * from user")
    public List<User> findList();
}
