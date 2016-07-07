package com.canteen.manage.dto;

import java.math.BigDecimal;

public class CardInfoDTO {
	
	private int id;

	private BigDecimal canteenBalance;
	
	private BigDecimal marketBalance;

	private String realId;

	private short state;

	private short type;

	private int userId;

	private BigDecimal perPayMoney;

	private int numbersOfPay;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	public BigDecimal getCanteenBalance() {
		return canteenBalance;
	}

	public void setCanteenBalance(BigDecimal canteenBalance) {
		this.canteenBalance = canteenBalance;
	}

	public BigDecimal getMarketBalance() {
		return marketBalance;
	}

	public void setMarketBalance(BigDecimal marketBalance) {
		this.marketBalance = marketBalance;
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

	public BigDecimal getPerPayMoney() {
		return perPayMoney;
	}

	public void setPerPayMoney(BigDecimal perPayMoney) {
		this.perPayMoney = perPayMoney;
	}

	public int getNumbersOfPay() {
		return numbersOfPay;
	}

	public void setNumbersOfPay(int numbersOfPay) {
		this.numbersOfPay = numbersOfPay;
	}

	@Override
	public String toString() {
		return "CardInfoDTO [id=" + id + ", canteenBalance=" + canteenBalance
				+ ", marketBalance=" + marketBalance + ", realId=" + realId
				+ ", state=" + state + ", type=" + type + ", userId=" + userId
				+ ", perPayMoney=" + perPayMoney + ", numbersOfPay="
				+ numbersOfPay + "]";
	}

	
	
}
