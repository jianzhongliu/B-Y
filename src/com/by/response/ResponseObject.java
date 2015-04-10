package com.by.response;


import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.JsonObject;

import net.sf.json.JSONArray;

@XmlRootElement
public class ResponseObject {
	private String status;
	private StringBuffer errorMSG;
	private int errorCode;//错误码
	private JsonObject dataArray;
	

	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public StringBuffer getErrorMSG() {
		return errorMSG;
	}


	public void setErrorMSG(StringBuffer errorMSG) {
		this.errorMSG = errorMSG;
	}


	public int getErrorCode() {
		return errorCode;
	}


	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}





	public JsonObject getDataArray() {
		return dataArray;
	}


	public void setDataArray(JsonObject dataArray) {
		this.dataArray = dataArray;
	}


	@Override
	public String toString() {
		return "[errorMSG=" + errorMSG + ", errorCode=" + errorCode  + "status=" + status + "dataArray=" + dataArray +"]";
	}

}
