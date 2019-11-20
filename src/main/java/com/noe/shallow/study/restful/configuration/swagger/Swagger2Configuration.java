/*
 * Copyright(c) by 2017-2019 HackMask Tefchnologies , Ltd. All Rights Reserved
 *
 */
package com.noe.shallow.study.restful.configuration.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <p>TODO .</p>
 * <p>时间 ： 2019年9月15日</p>
 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
 * @author  zhangjj25968
 * @version 1.0
 */
@Configuration
@EnableSwagger2
public class Swagger2Configuration {

	@Bean
	public Docket accessToken() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("api")// 定义组
				.select() // 选择那些路径和api会生成document
				.apis(RequestHandlerSelectors.basePackage("com.noe")) // 拦截的包路径
				.paths(PathSelectors.regex("/api/.*"))// 拦截的接口路径
				.build() // 创建
				.apiInfo(apiInfo()); // 配置说明
	}

	/**
	 * <p>TODO .</p>
	 * <p>时间 : 2019年9月15日</p>
	 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
	 * @author  zhangjj25968
	 * @version 1.0
	 * @return
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()//
				.title("NOE")// 标题
				.description("SwaggerUI")// 描述
				.termsOfServiceUrl("http://www.noe.com")//
				.contact(new Contact("wujing", "http://www.noe.com", "337042505@qq.com"))// 联系
				// .license("Apache License Version 2.0")// 开源协议
				// .licenseUrl("https://github.com/springfox/springfox/blob/master/LICENSE")//
				// 地址
				.version("1.0")// 版本
				.build();
	}

}
