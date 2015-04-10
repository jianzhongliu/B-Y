package com.by.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class City {
	private	Integer identify;
	private	String cityname;

	
	public Integer getIdentify() {
		return identify;
	}


	public void setIdentify(Integer identify) {
		this.identify = identify;
	}


	public String getCityname() {
		return cityname;
	}


	public void setCityname(String cityname) {
		this.cityname = cityname;
	}


	@Override
	public String toString() {
		return "[identify=" + "" + "]";
	}

}
