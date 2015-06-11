package com.mkyong.common.model;

import javax.xml.bind.annotation.XmlRootElement;

public class Status {
	String resultCode = "";
	

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

}
