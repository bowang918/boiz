package com.seven7.insurance.config;

/**
 * Created by FANFAN on 2017/6/10.
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "ch.ralscha.extdirectspring")
public class WebConfig {


    @Bean
    public MultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }

//    @Bean
//    public MultipartResolver multipartResolver() {
//        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
//        resolver.setMaxUploadSize(100000);
//        return resolver;
//    }
}
