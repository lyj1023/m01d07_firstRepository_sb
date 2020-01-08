package com.hqyj.sb.modules.test.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqyj.sb.modules.test.entity.City;
import com.hqyj.sb.modules.test.entity.Country;
import com.hqyj.sb.modules.test.service.TestService;
import com.hqyj.sb.modules.test.vo.ConfigTestBean;

@Controller
@RequestMapping("test")
public class TestContoller {
	@RequestMapping("/info")
	@ResponseBody
	public String getInfo() {
		return "菜鸟";
	}

	// =======================================================================================
	private final static Logger LOGGER = LoggerFactory.getLogger(TestContoller.class);

	@RequestMapping("/log")

	@ResponseBody
	public String logTest() {
		LOGGER.trace("This is trace log.");
		LOGGER.debug("This is debug log.");
		LOGGER.info("This is info log.");
		LOGGER.warn("This is warn log.");
		LOGGER.error("This is error log.");
		return "This is log test.";
	}

	// =======================================================================================
	// 针对 application.properties文件，直接使用@Value注解获得属性值
	@Value("${server.port}")
	private int port;
	@Value("${com.hqyj.name}")
	private String name;
	@Value("${com.hqyj.age}")
	private int age;
	@Value("${com.hqyj.description}")
	private String description;
	@Value("${com.hqyj.random}")
	private String random;

	// 针对其他配置文件，注入其对应的配置类
	@Autowired
	private ConfigTestBean configTestBean;

	@RequestMapping("/config")
	@ResponseBody
	public String getConfig() {
		StringBuffer sb = new StringBuffer();
		sb.append(port).append("‐‐‐‐").append(name).append("‐‐‐‐").append(age).append("‐‐‐‐").append(description)
				.append("‐‐‐‐").append(random).append("</br>");

		sb.append(configTestBean.getName()).append("‐‐‐‐").append(configTestBean.getAge()).append("‐‐‐‐")
				.append(configTestBean.getDescription()).append("‐‐‐‐").append(configTestBean.getRandom())
				.append("‐‐end‐‐");
		return sb.toString();
	}

	// =======================================================================================
	// ################################################################
	@Autowired
	private TestService testService;

	@RequestMapping("/city/{cityId}")
	@ResponseBody
	public City getCityByCityId(@PathVariable int cityId) {
		return testService.getCityByCityId(cityId);
	}

	// ################################################################
	@RequestMapping("/country/{countryId}")
	@ResponseBody
	public Country getCountryByCountryId(@PathVariable int countryId) {
		return testService.getCountryByCountryId(countryId);
	}

	// ################################################################
	@RequestMapping("/cities/{countryId}")
	@ResponseBody
	public List<City> getCitiesByCountryId(@PathVariable int countryId) {
		return testService.getCitiesByCountryId(countryId);
	}

	// ################################################################
	@RequestMapping("/country2")
	@ResponseBody
	public Country getCountryByCountryName(@RequestParam String countryName) {
		return testService.getCountryByCountryName(countryName);
	}
}
