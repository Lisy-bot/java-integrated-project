package com.lisy.controllers.transactional;

import com.lisy.common.result.ResultBody;
import com.lisy.entity.User;
import com.lisy.service.TransactionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Transactional注解事务管理
 * 用途：可以作用在接口、类、类方法
 * 自动提交事务或者遇到异常自动回滚，要么同时成功、要么同时失败
 * 注意事项：包含的代码中，不能使用try catch异常抛出
 */
@RestController
@RequestMapping("/transactional")
public class TransactionalController {

    @Autowired
    TransactionalService transactionalService;

    @PostMapping(value = "/add",produces = {"application/json;charset=UTF-8"})
    @Transactional
    public ResultBody index(@RequestBody User user){
        ResultBody resultBody = transactionalService.addUser(user);
        int i = 1 / 1;
        return resultBody;
    }
}
