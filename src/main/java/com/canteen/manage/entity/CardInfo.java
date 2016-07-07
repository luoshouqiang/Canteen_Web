package com.canteen.manage.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;


/**
 * The persistent class for the c_cartinfo database table.
 * 
 */
@Entity
@Table(name="c_cartinfo")
@NamedQuery(name="CardInfo.findAll", query="SELECT c FROM CardInfo c")
public class CardInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ci_id")
	@OrderBy
	private int id;

	@Column(name="ci_balance")
	private BigDecimal balance;

	@Column(name="ci_realid")
	private String realId;

	@Column(name="ci_state")
	private short state;

	@Column(name="ci_type")
	private short type;

	@Column(name="u_id")
	private int userId;

	public CardInfo() {
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



	public String getRealId() {
		return realId;
	}



	public void setRealId(String realId) {
		this.realId = realId;
	}



	public short getState() {
		return state;
	}



	public void setState(short state) {
		this.state = state;
	}



	public short getType() {
		return type;
	}



	public void setType(short type) {
		this.type = type;
	}



	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}



	@Override
	public String toString() {
		return "CardInfo [id=" + id + ", balance=" + balance + ", realId="
				+ realId + ", state=" + state + ", type=" + type + ", userId="
				+ userId + "]";
	}

	

}