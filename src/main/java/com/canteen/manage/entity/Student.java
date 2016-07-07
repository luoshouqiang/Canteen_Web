package com.canteen.manage.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "c_student")
@NamedQuery(name = "Student.findAll", query = "SELECT a FROM Student a")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "s_id")
	@OrderBy
	private int id;

	@Column(name = "cla_id")
	private int classId; // 班级ID

	@Column(name = "u_id")
	private int userId; // 用户ID

	@Column(name = "s_name")
	private String name; // 姓名

	@Column(name = "s_num")
	private String number; // 学号

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "s_time")
	private Date enrolTime; // 入学时间

	@Column(name = "s_state")
	private int status = 1; // 状态:1-正常,2-离校

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Date getEnrolTime() {
		return enrolTime;
	}

	public void setEnrolTime(Date enrolTime) {
		this.enrolTime = enrolTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
