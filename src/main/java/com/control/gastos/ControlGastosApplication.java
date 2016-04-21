package com.control.gastos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class ControlGastosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControlGastosApplication.class, args);
	}
	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                .allowedOrigins("http://localhost:63342")
    			.allowedMethods("GET","POST","PUT", "DELETE")
    			.allowedHeaders("Content-Type")
    			.exposedHeaders("Content-Type")
    			.allowCredentials(false).maxAge(3600);;
            }
        };
    }
}
