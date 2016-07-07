package com.canteen.manage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.canteen.manage.entity.User;

public interface UserRepository extends JpaRepository<User,Integer>{
	
	public User findByNameAndPassword(String userName,String pwd);
}
