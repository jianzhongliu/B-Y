package com.by.response;


import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

import com.by.model.City;
import com.by.model.Scenery_sopt;
import com.by.model.Tourist;

@XmlRootElement
public class SearchResponseObject {
	private String status;
	private StringBuffer errorMSG;
	private int errorCode;//错误码
	private ArrayList<Scenery_sopt> dataArray;
	private ArrayList<City> cityArray;
	private ArrayList<Tourist> touristArray;
	private int type;
	
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

	public ArrayList<City> getCityArray() {
		return cityArray;
	}


	public void setCityArray(ArrayList<City> cityArray) {
		this.cityArray = cityArray;
	}


	public ArrayList<Tourist> getTouristArray() {
		return touristArray;
	}


	public void setTouristArray(ArrayList<Tourist> touristArray) {
		this.touristArray = touristArray;
	}


	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}


	@Override
	public String toString() {
		return "[errorMSG=" + errorMSG + ", errorCode=" + errorCode  + "status=" + status + "dataArray=" + dataArray +"]";
	}

}
