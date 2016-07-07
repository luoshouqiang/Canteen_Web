package com.canteen.manage.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the c_childparentmap database table.
 * 
 */
@Entity
@Table(name="c_childparentmap")
@NamedQuery(name="ChildParentMap.findAll", query="SELECT c FROM ChildParentMap c")
public class ChildParentMap implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ChildParentMapPK id;

	public ChildParentMap() {
	}

	public ChildParentMapPK getId() {
		return this.id;
	}

	public void setId(ChildParentMapPK id) {
		this.id = id;
	}

}