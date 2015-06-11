package com.food.pos.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Bill")
public class BillPo {

	@Id
	@Column(name = "txId")
	private String txId;

	@Column(name = "orderDate")
	private String orderDate;

	@Column(name = "orderTime")
	private String orderTime;

	@Column(name = "OutOrIn")
	private String OutOrIn;

	@Column(name = "isPaid")
	private String isPaid;

	@Column(name = "isMealOut")
	private String isMealOut;

	@Column(name = "dollar")
	private String dollar;

	@Column(name = "seat")
	private String seat;

	@Column(name = "feature")
	private String feature;

	public String getTxId() {
		return txId;
	}

	public void setTxId(String txId) {
		this.txId = txId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public String getOutOrIn() {
		return OutOrIn;
	}

	public void setOutOrIn(String outOrIn) {
		OutOrIn = outOrIn;
	}

	public String getIsPaid() {
		return isPaid;
	}

	public void setIsPaid(String isPaid) {
		this.isPaid = isPaid;
	}

	public String getIsMealOut() {
		return isMealOut;
	}

	public void setIsMealOut(String isMealOut) {
		this.isMealOut = isMealOut;
	}

	public String getDollar() {
		return dollar;
	}

	public void setDollar(String dollar) {
		this.dollar = dollar;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

}
