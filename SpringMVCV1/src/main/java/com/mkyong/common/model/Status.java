package com.mkyong.common.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


public class Status {
	String resultCode = "";

	public String getResultCode() {
		return resultCode;
	}
	
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public static Status fail() {
		final Status status = new Status();
		status.setResultCode("0");
		return status;
	}

	public static Status successful() {
		final Status status = new Status();
		status.setResultCode("1");
		return status;
	}
}
