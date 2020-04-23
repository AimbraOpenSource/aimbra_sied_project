package com.aimbra.sied;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@PropertySources({
		@PropertySource("classpath:application.properties"),
		@PropertySource("classpath:database.properties"),
		@PropertySource("classpath:zoom.properties"),
		@PropertySource("classpath:jwt.properties")
})
//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class SiedApplication {

	public static void main(String[] args) {
		SpringApplication.run(SiedApplication.class, args);
	}

}
