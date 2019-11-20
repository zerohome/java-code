/*
 * Copyright(c) by 2017-2019 HackMask Tefchnologies , Ltd. All Rights Reserved
 *
 */
package com.noe.shallow.study.restful.cache.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.noe.shallow.study.restful.bean.UserLog;
import com.noe.shallow.study.restful.cache.UserLogCache;
import com.noe.shallow.study.restful.dao.jpa.UserLogDao;

/**
 * <p>TODO .</p>
 * <p>时间 ： 2019年9月11日</p>
 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
 * @author  zhangjj25968
 * @version 1.0
 */
@CacheConfig(cacheNames = "noeCache")
@Repository
public class UserLogCacheImpl implements UserLogCache {

	@Autowired
	private UserLogDao useLogDao;

	/**
	 * <p>TODO .</p>
	 * <p>时间 : 2019年9月11日</p>
	 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
	 * @author  zhangjj25968
	 * @version 1.0
	 * @param id
	 * @return
	 * @see com.noe.shallow.study.restful.cache.UserLogCache#selectById(java.lang.Long)
	 */
	@Cacheable(key = "#p0")
	@Override
	public UserLog selectById(Long id) {
//		log.info("查询功能，缓存找不到，直接读库, id={}", id);
		return useLogDao.getOne(id);
	}

	/**
	 * <p>TODO .</p>
	 * <p>时间 : 2019年9月11日</p>
	 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
	 * @author  zhangjj25968
	 * @version 1.0
	 * @param userLog
	 * @return
	 * @see com.noe.shallow.study.restful.cache.UserLogCache#updateById(com.noe.shallow.study.restful.bean.UserLog)
	 */
	@CachePut(key = "#p0")
	@Override
	public UserLog updateById(UserLog userLog) {
//		log.info("更新功能，更新缓存，直接写库, 更新内容={}", userLog);
		return useLogDao.save(userLog);
	}

	/**
	 * <p>TODO .</p>
	 * <p>时间 : 2019年9月11日</p>
	 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
	 * @author  zhangjj25968
	 * @version 1.0
	 * @param id
	 * @return
	 * @see com.noe.shallow.study.restful.cache.UserLogCache#deleteById(java.lang.Long)
	 */
	@CacheEvict(key = "#p0")
	@Override
	public String deleteById(Long id) {
//		log.info("删除功能，删除缓存，直接写库, 删除id={}", id);
		return null;
	}

}
