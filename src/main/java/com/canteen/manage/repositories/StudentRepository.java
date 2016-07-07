package com.canteen.manage.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.canteen.manage.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	public List<Student> findByClassId(int gradeId);
	
	public Student findByNumber(String number);
}
