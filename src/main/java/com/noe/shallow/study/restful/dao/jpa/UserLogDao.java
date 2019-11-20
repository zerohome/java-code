/*
 * Copyright(c) by 2017-2019 HackMask Tefchnologies , Ltd. All Rights Reserved
 *
 */
package com.noe.shallow.study.restful.dao.jpa;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.noe.shallow.study.restful.bean.UserLog;

/**
 * <p>TODO .</p>
 * <p>时间 ： 2019年9月10日</p>
 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
 * @author  zhangjj25968
 * @version 1.0
 */
public interface UserLogDao extends JpaRepository<UserLog, Long> {

	@Query(value = "select u from UserLog u where u.userName=?1")
	List<UserLog> findByUserName(String userName);

	List<UserLog> findByUserNameAndUserIp(String string, String string2);

	Page<UserLog> findByUserName(String userName, Pageable page);
}
