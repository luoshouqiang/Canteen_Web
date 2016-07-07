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
@Table(name = "c_parent")
@NamedQuery(name = "Parent.findAll", query = "SELECT a FROM Parent a")
public class Parent {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "p_id")
	@OrderBy
	private int id;

	@Column(name = "u_id")
	private int userId;

	@Column(name = "p_name")
	private String name;

	@Column(name = "p_phone")
	private String phone;

	public Parent() {

	}

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
