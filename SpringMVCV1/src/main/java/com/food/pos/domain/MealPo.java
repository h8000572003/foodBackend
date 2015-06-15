package com.food.pos.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Meal")
public class MealPo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private String id;

	@Column(name = "txId")
	private String txId;

	@Column(name = "name")
	private String name;

	@Column(name = "spcialize")
	private String spcialize;

	@Column(name = "dolloar")
	private String dolloar;

	@Column(name = "number")
	private String number;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTxId() {
		return txId;
	}

	public void setTxId(String txId) {
		this.txId = txId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpcialize() {
		return spcialize;
	}

	public void setSpcialize(String spcialize) {
		this.spcialize = spcialize;
	}

	public String getDolloar() {
		return dolloar;
	}

	public void setDolloar(String dolloar) {
		this.dolloar = dolloar;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
