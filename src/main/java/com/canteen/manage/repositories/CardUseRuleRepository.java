package com.canteen.manage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.canteen.manage.entity.CardUseRule;

public interface CardUseRuleRepository extends JpaRepository<CardUseRule, Integer>{
	
	public CardUseRule findByCurAttname(String attributeName);

}
