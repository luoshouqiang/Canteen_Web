package com.canteen.manage.repositories;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.canteen.manage.entity.RechargeRecord;

public interface RechargeRecordRepository extends JpaRepository<RechargeRecord, Integer>{
	
	public Page<RechargeRecord> findByUserId(int userId,Pageable page);
	
	@Query("select a from RechargeRecord a where userId in :userIdList")
	public Page<RechargeRecord> findOutGarde(@Param("userIdList") List<Integer> userIdList,Pageable pageable);

}
