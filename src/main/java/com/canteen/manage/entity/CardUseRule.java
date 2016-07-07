package com.canteen.manage.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the c_carduserule database table.
 * 
 */
@Entity
@Table(name="c_carduserule")
@NamedQuery(name="CardUseRule.findAll", query="SELECT c FROM CardUseRule c")
public class CardUseRule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cur_id")
	private int curId;

	@Column(name="cur_attname")
	private String curAttname;

	public CardUseRule() {
	}

	public int getCurId() {
		return this.curId;
	}

	public void setCurId(int curId) {
		this.curId = curId;
	}

	public String getCurAttname() {
		return this.curAttname;
	}

	public void setCurAttname(String curAttname) {
		this.curAttname = curAttname;
	}

}