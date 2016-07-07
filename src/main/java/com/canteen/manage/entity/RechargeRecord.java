package com.canteen.manage.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;
import java.math.BigDecimal;


/**
 * The persistent class for the c_rechargerecord database table.
 * 
 */
@Entity
@Table(name="c_rechargerecord")
@NamedQuery(name="RechargeRecord.findAll", query="SELECT c FROM RechargeRecord c")
public class RechargeRecord implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="rr_id")
	@OrderBy
	private int id;

	@Column(name="rr_balance")
	private BigDecimal balance;

	@Column(name="rr_money")
	private BigDecimal rechargeMoney;

	@Column(name="rr_source")
	private short rechargeSource;

	@Column(name="rr_state")
	private short rechargeState;

	@Column(name="rr_time")
	private Timestamp rechargeTime;

	@Column(name="rr_type")
	private short rechargeType;

	@Column(name="u_id")
	private int userId;

	public RechargeRecord() {
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


	public BigDecimal getRechargeMoney() {
		return rechargeMoney;
	}


	public void setRechargeMoney(BigDecimal rechargeMoney) {
		this.rechargeMoney = rechargeMoney;
	}


	public short getRechargeSource() {
		return rechargeSource;
	}


	public void setRechargeSource(short rechargeSource) {
		this.rechargeSource = rechargeSource;
	}


	public short getRechargeState() {
		return rechargeState;
	}


	public void setRechargeState(short rechargeState) {
		this.rechargeState = rechargeState;
	}


	public Timestamp getRechargeTime() {
		return rechargeTime;
	}


	public void setRechargeTime(Timestamp rechargeTime) {
		this.rechargeTime = rechargeTime;
	}


	public short getRechargeType() {
		return rechargeType;
	}


	public void setRechargeType(short rechargeType) {
		this.rechargeType = rechargeType;
	}


	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	
}