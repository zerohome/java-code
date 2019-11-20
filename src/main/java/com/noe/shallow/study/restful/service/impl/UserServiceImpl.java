/*
 * Copyright(c) by 2017-2019 HackMask Tefchnologies , Ltd. All Rights Reserved
 *
 */
package com.noe.shallow.study.restful.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.noe.shallow.study.restful.bean.User;
import com.noe.shallow.study.restful.bean.UserLog;
import com.noe.shallow.study.restful.dao.jpa.UserLogDao;
import com.noe.shallow.study.restful.jdbc.UserDao;
import com.noe.shallow.study.restful.service.UserService;

/**
 * <p>TODO .</p>
 * <p>时间 ： 2019年9月10日</p>
 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
 * @author  zhangjj25968
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserLogDao userLogDao;

	@Autowired
	private UserDao userDao;

	/**
	 * <p>TODO .</p>
	 * <p>时间 : 2019年9月10日</p>
	 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
	 * @author  zhangjj25968
	 * @version 1.0
	 * @param name
	 * @param ip
	 * @return
	 * @see com.noe.shallow.study.restful.service.UserService#register(java.lang.String, java.lang.String)
	 */
	@Override
	@Transactional
	public String register(String name, String ip) {
		User user = new User();
		user.setName(name);
		user.setBirthday(new Date());
		userDao.insert(user);

		UserLog userLog = new UserLog();
		userLog.setUserIp(ip);
		userLog.setUserName(name);
		userLog.setCreateTime(new Date());
		userLogDao.save(userLog);
		return "success";
	}

}
