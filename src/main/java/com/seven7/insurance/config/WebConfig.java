package com.seven7.insurance.config;

/**
 * Created by FANFAN on 2017/6/10.
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

@Configuration
@ComponentScan(basePackages = "ch.ralscha.extdirectspring")
public class WebConfig {

	 @Bean
	 public MultipartResolver multipartResolver() {
	 return new StandardServletMultipartResolver();
	 }

//	@Bean
//	public MultipartResolver multipartResolver() {
//		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
//		commonsMultipartResolver.setMaxUploadSize(52428800);
//		commonsMultipartResolver.setMaxInMemorySize(20480);
//		commonsMultipartResolver.setDefaultEncoding("UTF-8");
//		return commonsMultipartResolver;
//	}
}
