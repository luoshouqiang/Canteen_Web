package com.canteen.manage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import com.canteen.manage.entity.Teacher;
import com.canteen.manage.entity.User;
import com.canteen.manage.ex.BusinessException;
import com.canteen.manage.repositories.TeacherRepository;
import com.canteen.manage.repositories.UserRepository;
import com.canteen.manage.utils.MD5Util;

@Service
public class TeacherService {
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	@Autowired 
	private UserRepository userRepository;
	
	public Teacher createTeacher(Teacher teacher){
		Assert.notNull(teacher);
		if(StringUtils.isEmpty(teacher.getName())||
				StringUtils.isEmpty(teacher.getPhone())){
			throw new BusinessException(401, "请填写教师名字和手机号码");
		}
		
		User user=new User();
		user.setName(teacher.getName());
		user.setPassword(MD5Util.MD5Encode("888888", "UTF-8"));
		user.setPhone(teacher.getPhone());
		user.setType(2);
		user=userRepository.save(user);
		teacher.setUserId(user.getId());
		teacher=teacherRepository.save(teacher);
		return teacher;
	}
	
}
