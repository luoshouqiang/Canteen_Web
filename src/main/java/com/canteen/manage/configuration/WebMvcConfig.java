package com.canteen.manage.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.canteen.manage.controller.ResponseInterceptor;
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{
  @Override
public void addInterceptors(InterceptorRegistry registry) {
	  registry.addInterceptor(new ResponseInterceptor()).addPathPatterns("/**");
	super.addInterceptors(registry);
}
}
