package com.lisy.controllers.mybatis;
import com.lisy.common.result.ResultBody;
import com.lisy.entity.User;
import com.lisy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
public class ApiUserMyBatisController {
    @Autowired
    UserService userService;

    @GetMapping("/getUser/{id}")
    public ResultBody index(@PathVariable(name = "id") int id){
        return ResultBody.success(userService.fingById(id));
    }

    /**
     * 用户添加，实体类形式实现
     * @param user
     * @return
     */
    @PostMapping(value="/addUser", produces = {"application/json;charset=UTF-8"})
    public ResultBody addUser(@RequestBody User user){
        System.err.println(user);
       return userService.addUser(user) ? ResultBody.success(): ResultBody.error("添加失败");
    }
}
