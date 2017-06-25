package com.seven7.insurance.config;

import java.io.File;

import org.openqa.selenium.chrome.ChromeDriverService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.client.RestTemplate;

/**
 * Created by FANFAN on 2017/6/8.
 */
@Configuration
@EnableJpaAuditing
public class AppConfig {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	// @Bean
	// public AuditorAware<AuditableUser> auditorProvider() {
	// return new AuditorAwareImpl();
	// }


}
