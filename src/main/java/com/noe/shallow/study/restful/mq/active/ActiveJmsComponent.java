/*
 * Copyright(c) by 2017-2019 HackMask Tefchnologies , Ltd. All Rights Reserved
 *
 */
package com.noe.shallow.study.restful.mq.active;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>TODO .</p>
 * <p>时间 ： 2019年9月11日</p>
 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
 * @author  zhangjj25968
 * @version 1.0
 */
@Component
@Slf4j
public class ActiveJmsComponent {

	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;

	@Autowired
	private Queue queue;

	public void send(String msg) {
		this.jmsMessagingTemplate.convertAndSend(this.queue, msg);
	}

	@JmsListener(destination = "noe.queue")
	public void receiveQueue(String text) {
		log.info("您有新消息，请注意查收！【{}】", text);
	}
}
