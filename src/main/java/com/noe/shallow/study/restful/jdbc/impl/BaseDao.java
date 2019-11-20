/*
 * Copyright(c) by 2017-2019 HackMask Tefchnologies , Ltd. All Rights Reserved
 *
 */
package com.noe.shallow.study.restful.jdbc.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;

/**
 * <p>TODO .</p>
 * <p>时间 ： 2019年9月10日</p>
 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
 * @author  zhangjj25968
 * @version 1.0
 */
public abstract class BaseDao {

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	public Long getLastId() {
		return jdbcTemplate.queryForObject("select last_insert_id() as id", Long.class);
	}
	
	public <T> T queryForObject(String sql, Class<T> clazz, Object... params) {
		Assert.hasText(sql, "sql语句不能为空");
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<T>(clazz), params);
	}

	public <T> List<T> queryForObjectList(String sql, Class<T> clazz, Object... params) {
		Assert.hasText(sql, "sql 语句不能为空");
		return jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<T>(clazz));
	}
}
