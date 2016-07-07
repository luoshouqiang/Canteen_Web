package com.canteen.manage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.canteen.manage.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer>{

}
