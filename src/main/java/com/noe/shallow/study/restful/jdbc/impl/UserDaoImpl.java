/*
 * Copyright(c) by 2017-2019 HackMask Tefchnologies , Ltd. All Rights Reserved
 *
 */
package com.noe.shallow.study.restful.jdbc.impl;

import org.springframework.stereotype.Repository;

import com.noe.shallow.study.restful.bean.User;
import com.noe.shallow.study.restful.jdbc.UserDao;

/**
 * <p>TODO .</p>
 * <p>时间 ： 2019年9月10日</p>
 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
 * @author  zhangjj25968
 * @version 1.0
 */
@Repository
public class UserDaoImpl extends BaseDao implements UserDao {

	/**
	 * <p>TODO .</p>
	 * <p>时间 : 2019年9月10日</p>
	 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
	 * @author  zhangjj25968
	 * @version 1.0
	 * @param user
	 * @return
	 * @see com.noe.shallow.study.restful.jdbc.UserDao#insert(com.noe.shallow.study.restful.bean.User)
	 */
	@Override
	public int insert(User user) {
		String sql = "insert into user (name, birthday) values (?, ?)";
		return super.jdbcTemplate.update(sql, user.getName(), user.getBirthday());
	}

	/**
	 * <p>TODO .</p>
	 * <p>时间 : 2019年9月10日</p>
	 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
	 * @author  zhangjj25968
	 * @version 1.0
	 * @param id
	 * @return
	 * @see com.noe.shallow.study.restful.jdbc.UserDao#deleteById(int)
	 */
	@Override
	public int deleteById(int id) {
		String sql = "delete from user where id=?";
		return super.jdbcTemplate.update(sql, id);
	}

	/**
	 * <p>TODO .</p>
	 * <p>时间 : 2019年9月10日</p>
	 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
	 * @author  zhangjj25968
	 * @version 1.0
	 * @param user
	 * @return
	 * @see com.noe.shallow.study.restful.jdbc.UserDao#updateById(com.noe.shallow.study.restful.bean.User)
	 */
	@Override
	public int updateById(User user) {
		String sql = "update user set name=?, birthday=? where id=?";
		return jdbcTemplate.update(sql, user.getName(), user.getBirthday(), user.getId());
	}

	/**
	 * <p>TODO .</p>
	 * <p>时间 : 2019年9月10日</p>
	 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
	 * @author  zhangjj25968
	 * @version 1.0
	 * @param id
	 * @return
	 * @see com.noe.shallow.study.restful.jdbc.UserDao#selectById(int)
	 */
	@Override
	public User selectById(int id) {
		String sql = "select * from user where id=?";
		return super.jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
			User user = new User();
			user.setId(rs.getLong("id"));
			user.setName(rs.getString("name"));
			user.setBirthday(rs.getDate("birthday"));
			return user;
		});
	}

}
