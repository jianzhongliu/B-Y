package com.by.response;


import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

import com.by.model.Scenery_sopt;

@XmlRootElement
public class ScenaryResponseObject {
	private String status;
	private StringBuffer errorMSG;
	private int errorCode;//错误码
	private ArrayList<Scenery_sopt> dataArray;

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

	public ArrayList<Scenery_sopt> getDataArray() {
		return dataArray;
	}

	public void setDataArray(ArrayList<Scenery_sopt> dataArray) {
		this.dataArray = dataArray;
	}

	@Override
	public String toString() {
		return "[errorMSG=" + errorMSG + ", errorCode=" + errorCode  + "status=" + status + "dataArray=" + dataArray +"]";
	}

}
