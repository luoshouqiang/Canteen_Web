package com.canteen.manage.entity;

import java.io.Serializable;

import javax.persistence.*;

/**
 * The primary key class for the c_cardusedetail database table.
 * 
 */
@Embeddable
public class CardUseDetailPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="cur_id")
	private int attributeId;

	@Column(name="ci_id")
	private int cardId;

	public CardUseDetailPK() {
	}

	public int getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(int attributeId) {
		this.attributeId = attributeId;
	}

	public int getCardId() {
		return cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + attributeId;
		result = prime * result + cardId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CardUseDetailPK other = (CardUseDetailPK) obj;
		if (attributeId != other.attributeId)
			return false;
		if (cardId != other.cardId)
			return false;
		return true;
	}
	
}