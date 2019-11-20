/*
 * Copyright(c) by 2017-2019 HackMask Tefchnologies , Ltd. All Rights Reserved
 *
 */
package com.noe.shallow.study.restful.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

/**
 * <p>TODO .</p>
 * <p>时间 ： 2019年9月10日</p>
 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
 * @author  zhangjj25968
 * @version 1.0
 */
@Entity
@Data
public class UserLog implements Serializable {

	private static final long serialVersionUID = -6190332111585342061L;

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private Date createTime;

	@Column
	private String userName;

	@Column
	private String userIp;
}
