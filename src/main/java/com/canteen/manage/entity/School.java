package com.canteen.manage.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the c_school database table.
 * 
 */
@Entity
@Table(name="c_school")
@NamedQuery(name="School.findAll", query="SELECT c FROM School c")
public class School implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="sch_id")
	@OrderBy
	private int schId;

	@Column(name="sch_address")
	private String schAddress;

	@Column(name="sch_name")
	private String schName;

	@Column(name="sch_phone")
	private String schPhone;

	public School() {
	}

	public int getSchId() {
		return this.schId;
	}

	public void setSchId(int schId) {
		this.schId = schId;
	}

	public String getSchAddress() {
		return this.schAddress;
	}

	public void setSchAddress(String schAddress) {
		this.schAddress = schAddress;
	}

	public String getSchName() {
		return this.schName;
	}

	public void setSchName(String schName) {
		this.schName = schName;
	}

	public String getSchPhone() {
		return this.schPhone;
	}

	public void setSchPhone(String schPhone) {
		this.schPhone = schPhone;
	}

}