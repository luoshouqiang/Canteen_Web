package com.canteen.manage.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.canteen.manage.entity.ConsumeRecord;
import com.canteen.manage.entity.RechargeRecord;

public interface ConsumeRecordRepository extends JpaRepository<ConsumeRecord, Integer>{
		
	public Page<ConsumeRecord> findByUserId(int userId,Pageable page);
	
	@Query("select a from ConsumeRecord a where userId in :userIdList")
	public Page<ConsumeRecord> findOutGarde(@Param("userIdList") List<Integer> userIdList,Pageable pageable);
}
