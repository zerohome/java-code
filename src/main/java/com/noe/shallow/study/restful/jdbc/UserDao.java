/*
 * Copyright(c) by 2017-2019 HackMask Tefchnologies , Ltd. All Rights Reserved
 *
 */
package com.noe.shallow.study.restful.jdbc;

import com.noe.shallow.study.restful.bean.User;

/**
 * <p>TODO .</p>
 * <p>时间 ： 2019年9月10日</p>
 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
 * @author  zhangjj25968
 * @version 1.0
 */
public interface UserDao {

	int insert(User user);

	int deleteById(int id);

	int updateById(User user);

	User selectById(int id);
}
