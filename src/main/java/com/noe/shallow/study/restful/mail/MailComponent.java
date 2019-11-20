/*
 * Copyright(c) by 2017-2019 HackMask Tefchnologies , Ltd. All Rights Reserved
 *
 */
package com.noe.shallow.study.restful.mail;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

/**
 * <p>TODO .</p>
 * <p>时间 ： 2019年9月11日</p>
 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
 * @author  zhangjj25968
 * @version 1.0
 */
@Component
public class MailComponent {

	private static final String template = "mail/noe.ftl";

	@Autowired
	private FreeMarkerConfigurer freeMarkerConfigurer;

	@Autowired
	private MailSenderImpl mailSender;

	public void sendMail(String email) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("email", email);
		try {
			String text = getTextByTemplate(template, map);
			send(email, text);
		} catch (IOException | TemplateException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	private String getTextByTemplate(String template, Map<String, Object> model) throws TemplateNotFoundException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException {
		return FreeMarkerTemplateUtils
				.processTemplateIntoString(freeMarkerConfigurer.getConfiguration().getTemplate(template), model);
	}

	private String send(String email, String text) throws MessagingException, UnsupportedEncodingException {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
		InternetAddress from = new InternetAddress();
		from.setAddress(mailSender.getUsername());
		from.setPersonal("百度", "UTF-8");
		helper.setFrom(from);
		helper.setTo(email);
		helper.setSubject("测试邮件");
		helper.setText(text, true);
		mailSender.send(message);
		return text;
	}

}
