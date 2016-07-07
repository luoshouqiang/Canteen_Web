package com.canteen.manage.controller;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.canteen.manage.service.UserService;

@SpringBootApplication
@ComponentScan("com.canteen.manage")
@EntityScan("com.canteen.manage.entity")
@EnableJpaRepositories("com.canteen.manage.repositories")
@Import(UserService.class)
public class UserServer {
	
	public static void main(String[] args) {
		System.setProperty("spring.config.name", "manager-server");
		SpringApplication.run(UserServer.class, args);
	}
	

}
