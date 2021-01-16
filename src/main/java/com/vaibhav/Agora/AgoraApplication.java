package com.vaibhav.Agora;

import com.vaibhav.Agora.Entities.BaseEntity;
import com.vaibhav.Agora.security.EntityAuditing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.UUID;

@EnableAutoConfiguration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@EnableJpaRepositories(basePackages = {"com.vaibhav.Agora.Repositories"})
@ComponentScan(basePackages = {"com.vaibhav.Agora"})
@SpringBootApplication
public class AgoraApplication {

	@Bean
	public AuditorAware<String> auditorAware() {
		return new EntityAuditing();
	}

	public static void main(String[] args) {
		SpringApplication.run(AgoraApplication.class, args);
	}

}
