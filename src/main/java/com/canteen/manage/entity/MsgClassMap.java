package com.canteen.manage.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the c_msgclassmap database table.
 * 
 */
@Entity
@Table(name="c_msgclassmap")
@NamedQuery(name="MsgClassMap.findAll", query="SELECT c FROM MsgClassMap c")
public class MsgClassMap implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MsgClassMapPK id;

	public MsgClassMap() {
	}

	public MsgClassMapPK getId() {
		return this.id;
	}

	public void setId(MsgClassMapPK id) {
		this.id = id;
	}

}