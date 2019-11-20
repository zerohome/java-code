/*
 * Copyright(c) by 2017-2019 HackMask Tefchnologies , Ltd. All Rights Reserved
 *
 */
package com.noe.shallow.study.restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.noe.shallow.study.restful.bean.User;
import com.noe.shallow.study.restful.bean.UserLog;
import com.noe.shallow.study.restful.cache.UserLogCache;
import com.noe.shallow.study.restful.dao.mybatis.UserMapper;
import com.noe.shallow.study.restful.mail.MailComponent;
import com.noe.shallow.study.restful.mq.active.ActiveJmsComponent;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>TODO .</p>
 * <p>时间 ： 2019年9月10日</p>
 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
 * @author  zhangjj25968
 * @version 1.0
 */
@RestController
@RequestMapping("/api")
@Slf4j
public class ApiController {

	@Autowired
	private UserLogCache userLogCache;

	@Autowired
	private ActiveJmsComponent activeJmsComponent;

	@Autowired
	private MailComponent mailComponent;

	@Autowired
	private UserMapper userMapper;

	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping(value = "greeting")
	public String index() {
		activeJmsComponent.send("hello world");
		User user = userMapper.selectByPrimaryKey(4L);
		return "hello world";
	}

	@RequestMapping(value = "/user/log/{id}", method = RequestMethod.GET)
	public UserLog getUserLog(@RequestParam(defaultValue = "1") Long id) {
		UserLog userLog = userLogCache.selectById(id);
		return userLog;
	}

	@PostMapping("/user/log")
	public UserLog updateUserLog(@RequestBody UserLog userLog) {
		return userLogCache.updateById(userLog);
	}

	@DeleteMapping("/user/log/{id}")
	public String deleteUserLog(@RequestParam(defaultValue = "1") Long id) {
		return userLogCache.deleteById(id);
	}

	@RequestMapping(value = "mail")
	public String mail(String email) {
		mailComponent.sendMail(email);
		return "success";
	}

}
