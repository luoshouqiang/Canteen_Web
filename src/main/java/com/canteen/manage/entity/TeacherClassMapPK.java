package com.canteen.manage.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the c_teacherclassmap database table.
 * 
 */
@Embeddable
public class TeacherClassMapPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="t_id")
	private int tId;

	private int cla_ID;

	public TeacherClassMapPK() {
	}
	public int getTId() {
		return this.tId;
	}
	public void setTId(int tId) {
		this.tId = tId;
	}
	public int getCla_ID() {
		return this.cla_ID;
	}
	public void setCla_ID(int cla_ID) {
		this.cla_ID = cla_ID;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TeacherClassMapPK)) {
			return false;
		}
		TeacherClassMapPK castOther = (TeacherClassMapPK)other;
		return 
			(this.tId == castOther.tId)
			&& (this.cla_ID == castOther.cla_ID);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.tId;
		hash = hash * prime + this.cla_ID;
		
		return hash;
	}
}