package com.canteen.manage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.canteen.manage.dto.StudentDTO;
import com.canteen.manage.entity.Grade;
import com.canteen.manage.entity.Student;
import com.canteen.manage.repositories.StudentRepository;
import com.canteen.manage.service.CommonService;
import com.canteen.manage.service.StudentService;
import com.canteen.manage.utils.ReturnJson;

@RestController
@RequestMapping("student")
public class StudentController {
	@Autowired
	CommonService commonService;
	@Autowired
	StudentService studentService;

	@RequestMapping("add")
	public ReturnJson<Student> addStudent(@RequestBody StudentDTO sudentDTO){
		Student student=studentService.createNewStudent(sudentDTO);
		return new ReturnJson<Student>(student);
	}
	
	@RequestMapping("query")
	public ReturnJson<Student> query(@RequestParam String number){
		Student student=studentService.queryByNumber(number);
		return new ReturnJson<Student>(student);
	}
	
	@RequestMapping("gradeList")
	public ReturnJson<List<Grade>> gradeList(){
		List<Grade> gradeList=commonService.findAllGrade();
		return new ReturnJson<List<Grade>>(gradeList);
	}
	
}
