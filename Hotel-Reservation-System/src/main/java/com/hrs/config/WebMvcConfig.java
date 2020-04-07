package com.hrs.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages= {"com.hrs.controller","com.hrs.validator"})
public class WebMvcConfig extends WebMvcConfigurerAdapter{
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		 registry.addViewController("/visitor.htm").setViewName("visitor-reg");
		 registry.addViewController("/visitor-login.htm").setViewName("visitor-login");
		 registry.addViewController("/booking-page.htm").setViewName("booking-room");
		 registry.addViewController("/admin-login-page.htm").setViewName("admin-login");
		 registry.addViewController("/booking-reports.htm").setViewName("visitor-booking-room-details");
		 registry.addViewController("/hrs.htm").setViewName("hrs");
		 registry.addViewController("/managing-rooms.htm").setViewName("managing-room-details");
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/jsp/", ".jsp");
	}
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource=new ResourceBundleMessageSource();
		messageSource.setBasename("errors");
	return messageSource;
	}
	

}
