package com.canteen.manage.dto;

import java.math.BigDecimal;

public class RechargeInfoDTO {
	
	private int cardId;
	
//	private String realId;
	
	private int userId;
	private int gradeId;
	
	private BigDecimal canteenBalance=BigDecimal.ZERO;

	private BigDecimal marketBalance=BigDecimal.ZERO;

	private BigDecimal perPayMoney;

	private int rechargeType;

	

	public int getGradeId() {
		return gradeId;
	}

	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public BigDecimal getPerPayMoney() {
		return perPayMoney;
	}

	public void setPerPayMoney(BigDecimal perPayMoney) {
		this.perPayMoney = perPayMoney;
	}

	public int getRechargeType() {
		return rechargeType;
	}

	public void setRechargeType(int rechargeType) {
		this.rechargeType = rechargeType;
	}

	public int getCardId() {
		return cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

	@Override
	public String toString() {
		return "RechargeInfoDTO [cardId=" + cardId + ", userId=" + userId
				+ ", gradeId=" + gradeId + ", canteenBalance=" + canteenBalance
				+ ", marketBalance=" + marketBalance + ", perPayMoney="
				+ perPayMoney + ", rechargeType=" + rechargeType + "]";
	}
	
	

}
