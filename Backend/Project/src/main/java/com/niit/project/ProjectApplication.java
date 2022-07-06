package com.niit.project;

import com.niit.project.filter.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean jwtfilter(){
		// add url intercepting here, by using created filter
		FilterRegistrationBean frb = new FilterRegistrationBean();
		frb.setFilter(new JwtFilter()); // defined filter works here on added urls
		frb.addUrlPatterns("/kanban/v1/*");
		return frb;
	}



}
