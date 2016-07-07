package com.canteen.manage.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="token")
public class TokenServerConfig {
	
	private String url;	


	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}}
