/*
 * Copyright(c) by 2017-2019 HackMask Tefchnologies , Ltd. All Rights Reserved
 *
 */
package com.noe.shallow.study.restful.dao.mybatis;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.noe.shallow.study.restful.bean.User;

/**
 * <p>TODO .</p>
 * <p>时间 ： 2019年9月12日</p>
 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
 * @author  zhangjj25968
 * @version 1.0
 */
@Mapper
public interface UserMapper {

	@Insert(value = "insert into user (name, birthday) values (#{name,jdbcType=VARCHAR}, #{birthday,jdbcType=TIMESTAMP})")
	int insert(User user);

	@Select(value = "select id, name, birthday from user where id = #{id,jdbcType=INTEGER}")
	@Results(value = { @Result(column = "birthday", property = "birthday", jdbcType = JdbcType.TIMESTAMP) })
	User selectByPrimaryKey(Long id);
}
