package com.seven7.insurance.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
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

//	@Bean
//	public AuditorAware<AuditableUser> auditorProvider() {
//		return new AuditorAwareImpl();
//	}

}
