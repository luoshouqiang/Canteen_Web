package com.canteen.manage.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;
import java.math.BigDecimal;


/**
 * The persistent class for the c_consumerecord database table.
 * 
 */
@Entity
@Table(name="c_consumerecord")
@NamedQuery(name="ConsumeRecord.findAll", query="SELECT c FROM ConsumeRecord c")
public class ConsumeRecord implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cor_id")
	@OrderBy
	private int id;

	@Column(name="cor_balance")
	private BigDecimal balance;

	@Column(name="cor_location")
	private short consumeLocation;

	@Column(name="cor_num")
	private BigDecimal consumeNum;

	@Column(name="cor_time")
	private Timestamp consumeTime;

	@Column(name="cor_type")
	private short consumeType;

	@Column(name="u_id")
	private int userId;

	public ConsumeRecord() {
	}

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public BigDecimal getBalance() {
		return balance;
	}


	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}


	public short getConsumeLocation() {
		return consumeLocation;
	}


	public void setConsumeLocation(short consumeLocation) {
		this.consumeLocation = consumeLocation;
	}


	public BigDecimal getConsumeNum() {
		return consumeNum;
	}


	public void setConsumeNum(BigDecimal consumeNum) {
		this.consumeNum = consumeNum;
	}


	public Timestamp getConsumeTime() {
		return consumeTime;
	}


	public void setConsumeTime(Timestamp consumeTime) {
		this.consumeTime = consumeTime;
	}


	public short getConsumeType() {
		return consumeType;
	}


	public void setConsumeType(short consumeType) {
		this.consumeType = consumeType;
	}


	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	

}