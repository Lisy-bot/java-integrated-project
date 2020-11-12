package com.lisy.controllers.extpagehelper;

import com.lisy.common.result.ResultBody;
import com.lisy.service.ExtPagehelperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Auto: Lisy
 * @Date: 16
 * @Description: Pagehelper插件使用
 * @Version: 1.0
 */
@RequestMapping("/pageHelper")
@RestController
public class PagehelperController {
    @Autowired
    private ExtPagehelperService pagehelperService;

    /**
     * Pagehelper分页查询
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/findAll")
    public ResultBody index(@RequestParam(name = "page") int page,@RequestParam(name = "pageSize") int pageSize){
        return ResultBody.success(pagehelperService.findList(page,pageSize));
    }
}
