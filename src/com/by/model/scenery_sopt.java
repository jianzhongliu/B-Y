package com.by.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Scenery_sopt {
	private	Integer identify;
	private	String senaryname;
	private	Integer cityid;
	private	String cityname;
	private	String imageurl;
	private	Integer ordernumber;
	private	Integer touristnumber;
	private	Integer scenerynumber;
	private	Integer score;
	private	Integer date;
	

	public Integer getIdentify() {
		return identify;
	}


	public void setIdentify(Integer identify) {
		this.identify = identify;
	}


	public String getSenaryname() {
		return senaryname;
	}


	public void setSenaryname(String senaryname) {
		this.senaryname = senaryname;
	}


	public Integer getCityid() {
		return cityid;
	}


	public void setCityid(Integer cityid) {
		this.cityid = cityid;
	}


	public String getCityname() {
		return cityname;
	}


	public void setCityname(String cityname) {
		this.cityname = cityname;
	}


	public String getImageurl() {
		return imageurl;
	}


	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}


	public Integer getOrdernumber() {
		return ordernumber;
	}


	public void setOrdernumber(Integer ordernumber) {
		this.ordernumber = ordernumber;
	}


	public Integer getTouristnumber() {
		return touristnumber;
	}


	public void setTouristnumber(Integer touristnumber) {
		this.touristnumber = touristnumber;
	}


	public Integer getScenerynumber() {
		return scenerynumber;
	}


	public void setScenerynumber(Integer scenerynumber) {
		this.scenerynumber = scenerynumber;
	}


	public Integer getScore() {
		return score;
	}


	public void setScore(Integer score) {
		this.score = score;
	}


	public Integer getDate() {
		return date;
	}


	public void setDate(Integer date) {
		this.date = date;
	}


	@Override
	public String toString() {
		return "[identify=" + "" + "senaryname"+senaryname+"]";
	}

}
