package com.canteen.manage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.canteen.manage.entity.Parent;

public interface ParentRepository extends JpaRepository<Parent, Integer>{
		
	public Parent findByphone(String phone);
}
