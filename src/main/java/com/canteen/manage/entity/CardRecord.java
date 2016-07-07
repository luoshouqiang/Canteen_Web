package com.canteen.manage.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;

/**
 * The persistent class for the c_cardrecord database table.
 * 
 */
@Entity
@Table(name = "c_cardrecord")
@NamedQuery(name = "CardRecord.findAll", query = "SELECT c FROM CardRecord c")
public class CardRecord implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cr_id")
	@OrderBy
	private int cardId;

	@Column(name = "cr_time")
	private Timestamp createTime;

	@Column(name = "cr_type")
	private short cardType;

	@Column(name = "u_id")
	private int userId;

	public CardRecord() {
	}

	public int getCardId() {
		return cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public short getCardType() {
		return cardType;
	}

	public void setCardType(short cardType) {
		this.cardType = cardType;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}