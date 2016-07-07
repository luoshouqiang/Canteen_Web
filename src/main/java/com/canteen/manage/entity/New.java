package com.canteen.manage.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the c_news database table.
 * 
 */
@Entity
@Table(name="c_news")
@NamedQuery(name="New.findAll", query="SELECT c FROM New c")
public class New implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="n_id")
	@OrderBy
	private int nId;

	@Column(name="n_description")
	private String nDescription;

	@Column(name="n_img")
	private String nImg;

	@Column(name="n_state")
	private short nState;

	@Temporal(TemporalType.DATE)
	@Column(name="n_time")
	private Date nTime;

	@Column(name="n_title")
	private String nTitle;

	@Column(name="n_type")
	private short nType;

	@Column(name="n_weburl")
	private String nWeburl;

	public New() {
	}

	public int getNId() {
		return this.nId;
	}

	public void setNId(int nId) {
		this.nId = nId;
	}

	public String getNDescription() {
		return this.nDescription;
	}

	public void setNDescription(String nDescription) {
		this.nDescription = nDescription;
	}

	public String getNImg() {
		return this.nImg;
	}

	public void setNImg(String nImg) {
		this.nImg = nImg;
	}

	public short getNState() {
		return this.nState;
	}

	public void setNState(short nState) {
		this.nState = nState;
	}

	public Date getNTime() {
		return this.nTime;
	}

	public void setNTime(Date nTime) {
		this.nTime = nTime;
	}

	public String getNTitle() {
		return this.nTitle;
	}

	public void setNTitle(String nTitle) {
		this.nTitle = nTitle;
	}

	public short getNType() {
		return this.nType;
	}

	public void setNType(short nType) {
		this.nType = nType;
	}

	public String getNWeburl() {
		return this.nWeburl;
	}

	public void setNWeburl(String nWeburl) {
		this.nWeburl = nWeburl;
	}

}