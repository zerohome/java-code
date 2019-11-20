/*
 * Copyright(c) by 2017-2019 HackMask Tefchnologies , Ltd. All Rights Reserved
 *
 */
package com.noe.shallow.study.restful.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.noe.shallow.study.restful.bean.User;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>TODO .</p>
 * <p>时间 ： 2019年9月10日</p>
 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
 * @author  zhangjj25968
 * @version 1.0
 */
@RestController
@RequestMapping("/index")
@Slf4j
public class IndexController {

	private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

	@Value("${noe.id}")
	private Long userId;

	@Value("${APP.DESC}")
	private String appDesc;

	@RequestMapping
	public String index() {
		return "hello world";
	}
	
	@RequestMapping("/app")
	public String appInfo() {
		LOGGER.info("{}", appDesc);
		log.debug("{}", appDesc);
		return appDesc;
	}

	@RequestMapping(value = "/greeting")
	public Map<String, Object> greeting(@RequestParam(required = false) String name) {
		Map<String, Object> map = new HashMap<>();
		map.put("title", "greeting");
		map.put("who", name);
		return map;
	}

	@RequestMapping("/user/{name}")
	public User getUserInfo(@PathVariable String name) {// @PathVariable 获得请求url中的动态参数
		User user = new User();
		user.setId(this.userId);
		user.setName(name);
		user.setBirthday(new Date());
		return user;
	}

	@RequestMapping(value = "/error")
	public String error(ModelMap map) {
		throw new RuntimeException("测试异常");
	}
}
