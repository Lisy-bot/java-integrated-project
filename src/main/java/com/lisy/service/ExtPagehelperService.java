package com.lisy.service;

import com.lisy.annotation.ExtPageHelper;
import com.lisy.entity.User;
import com.lisy.mapper.ExtPagehelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auto: Lisy
 * @Date: 16
 * @Description:
 * @Version: 1.0
 */
@Service
public class ExtPagehelperService {
    @Autowired
    private ExtPagehelper excPagehelper;
    @ExtPageHelper
    public Object findList(int page, int pageSize){
        List<User> user = excPagehelper.findList();
        return user;
    }
}
