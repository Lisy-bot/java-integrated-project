package com.lisy.controllers.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lisy.common.result.ResultBody;
@RequestMapping("/api")
@RestController
public class ApiIndexController {

	@GetMapping("/index/{id}")
	public ResultBody index(@PathVariable(name = "id") String id, @RequestParam(name = "name") String name) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("name", name);
		return ResultBody.success(map);
	}

}
