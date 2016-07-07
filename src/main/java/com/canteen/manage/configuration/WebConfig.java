package com.canteen.manage.configuration;

import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.canteen.manage.controller.LoginFilter;

@Configuration
public class WebConfig {
	
	public FilterRegistrationBean filterRegistrationBean(LoginFilter loginFilter) {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		
		filterRegistrationBean.setFilter(loginFilter);
		filterRegistrationBean.setEnabled(true);
		filterRegistrationBean.addUrlPatterns("/*");
		
		return filterRegistrationBean;
	}
}
