package com.nfkdata.seed.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.nfkdata.seed.interceptor.LoggingInterceptor;

@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {

	@Autowired
	private LoggingInterceptor loggingInterceptor;

	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loggingInterceptor).addPathPatterns("/**");
	}
}
