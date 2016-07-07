package com.canteen.manage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.canteen.manage.entity.CardUseDetail;
import com.canteen.manage.entity.CardUseDetailPK;

public interface CardUseDetailRepository extends JpaRepository<CardUseDetail, CardUseDetailPK>{
		
}
