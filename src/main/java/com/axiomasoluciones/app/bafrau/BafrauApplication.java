package com.axiomasoluciones.app.bafrau;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;


@SpringBootApplication
@EnableScheduling
public class BafrauApplication {

	public static void main(String[] args) {
		SpringApplication.run(BafrauApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public AuditorAware<String> auditorProvider() {
		return () -> Optional.ofNullable("system");
	}
}
