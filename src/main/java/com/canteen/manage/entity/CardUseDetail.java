package com.canteen.manage.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the c_cardusedetail database table.
 * 
 */
@Entity
@Table(name="c_cardusedetail")
@NamedQuery(name="CardUseDetail.findAll", query="SELECT c FROM CardUseDetail c")
public class CardUseDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CardUseDetailPK id;

	@Column(name="cud_attvalue")
	private String cudAttvalue;

	@Column(name="cud_state")
	private short cudState;

	public CardUseDetail() {
	}
	
	public CardUseDetail(int cardId,int attributeId,short state,String value){
		CardUseDetailPK pk=new CardUseDetailPK();
		pk.setCardId(cardId);
		pk.setAttributeId(attributeId);
		this.id=pk;
		this.cudState=state;
		this.cudAttvalue=value;
	}

	public CardUseDetailPK getId() {
		return this.id;
	}

	public void setId(CardUseDetailPK id) {
		this.id = id;
	}

	public String getCudAttvalue() {
		return this.cudAttvalue;
	}

	public void setCudAttvalue(String cudAttvalue) {
		this.cudAttvalue = cudAttvalue;
	}

	public short getCudState() {
		return this.cudState;
	}

	public void setCudState(short cudState) {
		this.cudState = cudState;
	}

}