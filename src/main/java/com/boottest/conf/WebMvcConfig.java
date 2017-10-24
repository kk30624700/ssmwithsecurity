package com.boottest.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.boottest.intercept.DemoInterceptor;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{
	@Bean
	public DemoInterceptor demoInterceptor() {
		return new DemoInterceptor();
	}
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		//registry.addViewController("/").setViewName("/index");
	}
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(demoInterceptor());
	}
}
