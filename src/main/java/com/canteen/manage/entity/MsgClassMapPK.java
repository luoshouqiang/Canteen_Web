package com.canteen.manage.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the c_msgclassmap database table.
 * 
 */
@Embeddable
public class MsgClassMapPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int cla_ID;

	@Column(name="SM_ID")
	private int smId;

	public MsgClassMapPK() {
	}
	public int getCla_ID() {
		return this.cla_ID;
	}
	public void setCla_ID(int cla_ID) {
		this.cla_ID = cla_ID;
	}
	public int getSmId() {
		return this.smId;
	}
	public void setSmId(int smId) {
		this.smId = smId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MsgClassMapPK)) {
			return false;
		}
		MsgClassMapPK castOther = (MsgClassMapPK)other;
		return 
			(this.cla_ID == castOther.cla_ID)
			&& (this.smId == castOther.smId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.cla_ID;
		hash = hash * prime + this.smId;
		
		return hash;
	}
}