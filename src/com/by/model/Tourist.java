package com.by.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Tourist {
	private	String identify;
	private	String username;
	private	String password;
	private	String token;
	private	int gender;
	private	int birthday;
	private	String nuckname;
	private	String name;
	private	String icon;
	private	String email;
	private	String phone;
	private	String signature;
	private	String servicearea;
	private	String language;
	private	String price;
	private	String pricedetail;
	private	String servicedetail;
	private	String tag;
	private	String images;
	private	float star;
	private	int usertype;
	private	float userlat;
	private	float userlng;
	private	String otherinfoid;
	private	int ordernumber;
	private	int registerdate;
	
	public String getIdentify() {
		return identify;
	}

	public void setIdentify(String identify) {
		this.identify = identify;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getBirthday() {
		return birthday;
	}

	public void setBirthday(int birthday) {
		this.birthday = birthday;
	}

	public String getNuckname() {
		return nuckname;
	}

	public void setNuckname(String nuckname) {
		this.nuckname = nuckname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getServicearea() {
		return servicearea;
	}

	public void setServicearea(String servicearea) {
		this.servicearea = servicearea;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPricedetail() {
		return pricedetail;
	}

	public void setPricedetail(String pricedetail) {
		this.pricedetail = pricedetail;
	}

	public String getServicedetail() {
		return servicedetail;
	}

	public void setServicedetail(String servicedetail) {
		this.servicedetail = servicedetail;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public float getStar() {
		return star;
	}

	public void setStar(float star) {
		this.star = star;
	}

	public int getUsertype() {
		return usertype;
	}

	public void setUsertype(int usertype) {
		this.usertype = usertype;
	}

	public float getUserlat() {
		return userlat;
	}

	public void setUserlat(float userlat) {
		this.userlat = userlat;
	}

	public float getUserlng() {
		return userlng;
	}

	public void setUserlng(float userlng) {
		this.userlng = userlng;
	}

	public String getOtherinfoid() {
		return otherinfoid;
	}

	public void setOtherinfoid(String otherinfoid) {
		this.otherinfoid = otherinfoid;
	}

	public int getOrdernumber() {
		return ordernumber;
	}

	public void setOrdernumber(int ordernumber) {
		this.ordernumber = ordernumber;
	}

	public int getRegisterdate() {
		return registerdate;
	}

	public void setRegisterdate(int registerdate) {
		this.registerdate = registerdate;
	}

	@Override
	public String toString() {
		return "[identify=" + "" + "]";
	}

}
