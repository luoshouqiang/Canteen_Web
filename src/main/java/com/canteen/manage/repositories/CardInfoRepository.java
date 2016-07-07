package com.canteen.manage.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.canteen.manage.entity.CardInfo;

public interface CardInfoRepository extends JpaRepository<CardInfo, Integer>{
		
	public CardInfo findByUserId(int userId);
	
	public CardInfo findByRealId(String realId);
	
	@Query("select a from CardInfo a where userId in :userList")
	public List<CardInfo> listGradeCard(@Param("userList") List<Integer> userList);
}
