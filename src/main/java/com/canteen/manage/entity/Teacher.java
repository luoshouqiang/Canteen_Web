package com.canteen.manage.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "c_teacher")
@NamedQuery(name = "Teacher.findAll", query = "SELECT a FROM Teacher a")
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "t_id")
	@OrderBy
	private int id;

	@Column(name = "sch_id")
	private int schoolId; // 班级ID

	@Column(name = "u_id")
	private int userId; // 用户ID

	@Column(name = "t_name")
	private String name; // 姓名

	@Column(name = "t_phone")
	private String phone; // 姓名

	@Column(name = "t_ismanager")
	private int manager; // 学号

	@Column(name = "t_state")
	private int status = 1; // 状态:1-正常,2-离校

	@Column(name = "t_ishead")
	private int head = 1; // 状态:1-正常,2-离校

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getManager() {
		return manager;
	}

	public void setManager(int manager) {
		this.manager = manager;
	}

	public int getHead() {
		return head;
	}

	public void setHead(int head) {
		this.head = head;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", schoolId=" + schoolId + ", userId="
				+ userId + ", name=" + name + ", phone=" + phone + ", manager="
				+ manager + ", status=" + status + ", head=" + head + "]";
	}

}
