package com.lisy.controllers.frameworks;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 整合framework
 * @author Lisy
 *
 */
@Controller
@RequestMapping("/framek")

public class indexController {
	@RequestMapping(value="/ftlIndex")
	public String index(Map<String, Object> map) {
		map.put("code", 100);
		return "index";
	}
}
