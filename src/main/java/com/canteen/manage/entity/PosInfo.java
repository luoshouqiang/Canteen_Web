package com.canteen.manage.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the c_posinfo database table.
 * 
 */
@Entity
@Table(name="c_posinfo")
@NamedQuery(name="PosInfo.findAll", query="SELECT c FROM PosInfo c")
public class PosInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="pos_id")
	private int posId;

	@Column(name="pos_location")
	private short posLocation;

	@Column(name="pos_num")
	private String posNum;

	@Column(name="sch_id")
	private int schId;

	public PosInfo() {
	}

	public int getPosId() {
		return this.posId;
	}

	public void setPosId(int posId) {
		this.posId = posId;
	}

	public short getPosLocation() {
		return this.posLocation;
	}

	public void setPosLocation(short posLocation) {
		this.posLocation = posLocation;
	}

	public String getPosNum() {
		return this.posNum;
	}

	public void setPosNum(String posNum) {
		this.posNum = posNum;
	}

	public int getSchId() {
		return this.schId;
	}

	public void setSchId(int schId) {
		this.schId = schId;
	}

}