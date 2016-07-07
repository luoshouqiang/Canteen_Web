package com.canteen.manage.service;


import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.canteen.manage.dto.StudentDTO;
import com.canteen.manage.entity.ChildParentMap;
import com.canteen.manage.entity.ChildParentMapPK;
import com.canteen.manage.entity.Parent;
import com.canteen.manage.entity.Student;
import com.canteen.manage.entity.User;
import com.canteen.manage.ex.BusinessException;
import com.canteen.manage.repositories.ChildParentMapRepository;
import com.canteen.manage.repositories.ParentRepository;
import com.canteen.manage.repositories.StudentRepository;
import com.canteen.manage.repositories.UserRepository;
import com.canteen.manage.utils.MD5Util;


/**
 * @author nooze
 * 
 * 学生相关业务
 */
@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	ParentRepository parentRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	ChildParentMapRepository childParentRepository;
	
	@Autowired
	UserService userService;
	
	/**
	 * 新建学生信息
	 * @param studentDTO
	 */
	@Transactional
	public Student createNewStudent(StudentDTO studentDTO){
		Assert.assertNotNull("新增学生对象为空", studentDTO);
		if(StringUtils.isEmpty(studentDTO.getName())||
				StringUtils.isEmpty(studentDTO.getNumber())){
			throw new BusinessException(410, "请先填写完整的姓名和学号");
		}
		if(StringUtils.isEmpty(studentDTO.getParentPhone())){
			throw new BusinessException(410, "请先填写家长的手机号");
		}
		Student student=studentRepository.findByNumber(studentDTO.getNumber());
		if(student!=null){
			throw new BusinessException(410, "已经存在这个学号的学生");
		}
		
		Parent parent=parentRepository.findByphone(studentDTO.getParentPhone());
		if(parent==null){			
			User user=userService.createUser(studentDTO.getParentName(), studentDTO.getParentPhone(), 3, null);
			parent=new Parent();
			parent.setName(studentDTO.getParentName());
			parent.setPhone(studentDTO.getParentPhone());
			parent.setUserId(user.getId());
			parent=parentRepository.save(parent);
		}
		User stuUser=userService.createUser(studentDTO.getName(), "", 4, null);
		student=new Student();
		student.setClassId(studentDTO.getGradeId());
		student.setEnrolTime(studentDTO.getRegisterTime());
		student.setName(studentDTO.getName());
		student.setStatus(1);
		student.setNumber(studentDTO.getNumber());
		student.setUserId(stuUser.getId());
		student= studentRepository.save(student);
		ChildParentMapPK childParentMapPk=new ChildParentMapPK();
		childParentMapPk.setParentId(parent.getId());
		childParentMapPk.setStudentId(student.getId());
		ChildParentMap childParenMap=new ChildParentMap();
		childParenMap.setId(childParentMapPk);
		childParentRepository.save(childParenMap);
		return student;
	}
	
	/**
	 * 根据学号查询学生
	 * @param number
	 * @return
	 */
	public Student queryByNumber(String number){
		if(StringUtils.isEmpty(number)){
			throw new BusinessException(410, "请先输入学号");
		}
		return studentRepository.findByNumber(number);
	}
	
	
	
}
