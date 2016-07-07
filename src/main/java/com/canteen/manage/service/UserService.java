package com.canteen.manage.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.canteen.manage.entity.User;
import com.canteen.manage.ex.BusinessException;
import com.canteen.manage.repositories.UserRepository;
import com.canteen.manage.utils.MD5Util;

/**
 * @author nooze
 * 用户相关信息
 */
@Service
public class UserService {
	
	private final static Logger LOG = LoggerFactory.getLogger("UserService");
	

	@Autowired
	UserRepository userRepository;
	
	/**
	 * 登录
	 * @param name
	 * @param pwd
	 * @return
	 */
	public User checkAccount(String name,String pwd){
		if(StringUtils.isEmpty(name)||
				StringUtils.isEmpty(pwd)	){
			throw new BusinessException(410,"请输入用户名和密码");
		}
		return userRepository.findByNameAndPassword(name, pwd);		
	}
	
	public User createUser(String name,String phone,int type,String headUrl){
		User user=new User();
		user.setName(name);
		user.setPassword(MD5Util.MD5Encode("888888", "UTF-8"));
		user.setPhone(phone);
		user.setType(type);
		user.setHeadUrl(headUrl);
		user=userRepository.save(user);
		return user;
	}
	
	/**
	 * 修改密码
	 * @param userId
	 * @param newPwd
	 */
	public void changePwd(int userId,String newPwd){
		if(StringUtils.isEmpty(newPwd)	){
			throw new BusinessException(410,"请输入新密码");
		}
		User user=userRepository.findOne(userId);
		if(user!=null)
			user.setPassword(newPwd);
		userRepository.save(user);
	}
	
	
}
