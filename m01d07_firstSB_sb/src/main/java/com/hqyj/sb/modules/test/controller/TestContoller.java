package com.hqyj.sb.modules.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestContoller {
	@RequestMapping("test/info")
	@ResponseBody
	public String getInfo(){
		return "菜鸟";
	}
}
