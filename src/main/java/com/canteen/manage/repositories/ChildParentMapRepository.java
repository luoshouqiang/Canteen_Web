package com.canteen.manage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.canteen.manage.entity.ChildParentMap;
import com.canteen.manage.entity.ChildParentMapPK;

public interface ChildParentMapRepository extends JpaRepository<ChildParentMap, ChildParentMapPK>{

}
