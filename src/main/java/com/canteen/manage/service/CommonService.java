package com.canteen.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.canteen.manage.entity.Grade;
import com.canteen.manage.repositories.GradeRepository;

@Service
public class CommonService {
	
	@Autowired
	GradeRepository gradeRepository;
	
	public List<Grade> findAllGrade(){
		return gradeRepository.findAll();
	}
}
