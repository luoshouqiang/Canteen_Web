package com.canteen.manage.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the c_teacherclassmap database table.
 * 
 */
@Entity
@Table(name="c_teacherclassmap")
@NamedQuery(name="TeacherClassMap.findAll", query="SELECT c FROM TeacherClassMap c")
public class TeacherClassMap implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TeacherClassMapPK id;

	@Column(name="tcm_isheadteacher")
	private byte tcmIsheadteacher;

	public TeacherClassMap() {
	}

	public TeacherClassMapPK getId() {
		return this.id;
	}

	public void setId(TeacherClassMapPK id) {
		this.id = id;
	}

	public byte getTcmIsheadteacher() {
		return this.tcmIsheadteacher;
	}

	public void setTcmIsheadteacher(byte tcmIsheadteacher) {
		this.tcmIsheadteacher = tcmIsheadteacher;
	}

}