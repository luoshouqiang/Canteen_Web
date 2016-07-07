package com.canteen.manage.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.canteen.manage.entity.User;
import com.canteen.manage.service.CommonService;
import com.canteen.manage.service.UserService;
import com.canteen.manage.utils.ReturnJson;



@RestController
@RequestMapping(value="admin")
public class ManageController {
	
	@Autowired
	UserService userService;
	@Autowired
	CommonService commonService;
	
	@RequestMapping(value="changePwd")
	public ReturnJson<Void> changePwd(HttpSession session,@RequestParam String newPwd){
		ReturnJson<Void> returnJson=new ReturnJson<Void>();
		User user =(User)session.getAttribute("CANTEEN_ADMIN");
		userService.changePwd(user.getId(), newPwd);
		return returnJson;
	}
	
	@RequestMapping(value="webPath")
	public ReturnJson<String> login(HttpServletRequest request){
		String webPath = request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
		return  new ReturnJson<String>(webPath);
	}
	
	@RequestMapping(value="login")
	public ReturnJson<User> login(HttpSession session,@RequestParam String username,@RequestParam String password){	
		User user = userService.checkAccount(username, password);
		if(user!=null)
			session.setAttribute("CANTEEN_ADMIN", user);
		return new ReturnJson<User>(user);
	}
	
	
	/**
	 * 注销
	 * @param request
	 * @return
	 */
	@RequestMapping(value="logout")
	public ReturnJson<Void> logout(HttpSession session){
		session.invalidate();
		return new ReturnJson<Void>();
	}
	
	
}
