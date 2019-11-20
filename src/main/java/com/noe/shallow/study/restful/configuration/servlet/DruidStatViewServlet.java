/*
 * Copyright(c) by 2017-2019 HackMask Tefchnologies , Ltd. All Rights Reserved
 *
 */
package com.noe.shallow.study.restful.configuration.servlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import com.alibaba.druid.support.http.StatViewServlet;

/**
 * <p>TODO .</p>
 * <p>时间 ： 2019年9月12日</p>
 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
 * @author  zhangjj25968
 * @version 1.0
 */
@WebServlet(urlPatterns = { "/druid/*" }, initParams = { @WebInitParam(name = "allow", value = "192.168.246.218"),
		@WebInitParam(name = "loginUsername", value = "noe"), @WebInitParam(name = "loginPassword", value = "noe") })
public class DruidStatViewServlet extends StatViewServlet {

	private static final long serialVersionUID = -2692754524221639198L;

}
