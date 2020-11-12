package com.vaibhav.Agora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = {"com.vaibhav.Agora.Repositories"})
@ComponentScan(basePackages = {"com.vaibhav.Agora"})
@SpringBootApplication
public class AgoraApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgoraApplication.class, args);
	}

}
