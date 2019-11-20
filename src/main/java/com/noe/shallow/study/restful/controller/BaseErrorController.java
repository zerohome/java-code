/*
 * Copyright(c) by 2017-2019 HackMask Tefchnologies , Ltd. All Rights Reserved
 *
 */
package com.noe.shallow.study.restful.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>TODO .</p>
 * <p>时间 ： 2019年9月10日</p>
 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
 * @author  zhangjj25968
 * @version 1.0
 */
//@Controller
@RequestMapping(value = "error")
@Slf4j
public class BaseErrorController implements ErrorController {

	/**
	 * <p>TODO .</p>
	 * <p>时间 : 2019年9月10日</p>
	 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
	 * @author  zhangjj25968
	 * @version 1.0
	 * @return
	 * @see org.springframework.boot.web.servlet.error.ErrorController#getErrorPath()
	 */
	@Override
	public String getErrorPath() {
		log.info("出错啦！进入自定义错误控制器");
		return "comm/error";
	}

	@RequestMapping
	public String error() {
		return getErrorPath();
	}

}
