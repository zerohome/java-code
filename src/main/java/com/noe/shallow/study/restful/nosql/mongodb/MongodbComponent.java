/*
 * Copyright(c) by 2017-2019 HackMask Tefchnologies , Ltd. All Rights Reserved
 *
 */
package com.noe.shallow.study.restful.nosql.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Component;

import com.noe.shallow.study.restful.bean.User;

/**
 * <p>TODO .</p>
 * <p>时间 ： 2019年9月11日</p>
 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
 * @author  zhangjj25968
 * @version 1.0
 */
@Component
public class MongodbComponent {

	@Autowired
	private MongoTemplate mongoTemplate;

	public void insert(User user) {
		mongoTemplate.insert(user);
	}

	public void deleteById(Long id) {
		Criteria criteria = Criteria.where("id").is(id);
	}
}
