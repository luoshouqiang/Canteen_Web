package com.canteen.manage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.canteen.manage.entity.Grade;

public interface GradeRepository extends JpaRepository<Grade, Integer>{
		
	
}
