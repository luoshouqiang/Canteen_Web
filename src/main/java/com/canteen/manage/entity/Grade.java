package com.canteen.manage.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;


/**
 * The persistent class for the c_class database table.
 * 
 */
@Entity
@Table(name="c_class")
@NamedQuery(name="Grade.findAll", query="SELECT c FROM Grade c")
public class Grade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cla_id")
	@OrderBy
	private int classId;

	@Column(name="cla_createdate")
	private Timestamp createdate;

	@Column(name="cla_name")
	private String className;

	@Column(name="cla_type")
	private short classType;

	@Column(name="sch_id")
	private int schoolId;

	public Grade() {
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public Timestamp getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public short getClassType() {
		return classType;
	}

	public void setClassType(short classType) {
		this.classType = classType;
	}

	public int getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}

	
	

}