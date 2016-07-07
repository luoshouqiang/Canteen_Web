package com.canteen.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.canteen.manage.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	UserService userService;
		
}
