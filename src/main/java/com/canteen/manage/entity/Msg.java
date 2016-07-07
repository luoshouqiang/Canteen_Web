package com.canteen.manage.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the c_msg database table.
 * 
 */
@Entity
@Table(name="c_msg")
@NamedQuery(name="Msg.findAll", query="SELECT c FROM Msg c")
public class Msg implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="SM_ID")
	private int smId;
	
	@Column(name="SM_Connet")
	private String content;

	@Temporal(TemporalType.TIMESTAMP)
	private Date SM_Date;

	@Temporal(TemporalType.DATE)
	private Date SM_SendDate;
	
	@Column(name="SM_Type")
	private short type;

	@Column(name="t_id")
	private int tId;

	public Msg() {
	}

	public int getSmId() {
		return this.smId;
	}

	public void setSmId(int smId) {
		this.smId = smId;
	}


	public Date getSM_Date() {
		return this.SM_Date;
	}

	public void setSM_Date(Date SM_Date) {
		this.SM_Date = SM_Date;
	}

	public Date getSM_SendDate() {
		return this.SM_SendDate;
	}

	public void setSM_SendDate(Date SM_SendDate) {
		this.SM_SendDate = SM_SendDate;
	}


	public int getTId() {
		return this.tId;
	}

	public void setTId(int tId) {
		this.tId = tId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public short getType() {
		return type;
	}

	public void setType(short type) {
		this.type = type;
	}


}