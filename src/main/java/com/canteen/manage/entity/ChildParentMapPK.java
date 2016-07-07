package com.canteen.manage.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the c_childparentmap database table.
 * 
 */
@Embeddable
public class ChildParentMapPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="s_id")
	private int studentId;

	@Column(name="p_id")
	private int parentId;

	public ChildParentMapPK() {
	}
	
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ChildParentMapPK)) {
			return false;
		}
		ChildParentMapPK castOther = (ChildParentMapPK)other;
		return 
			(this.studentId == castOther.studentId)
			&& (this.parentId == castOther.parentId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.studentId;
		hash = hash * prime + this.parentId;
		
		return hash;
	}
}