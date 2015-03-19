package br.com.restful.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * 属性	类型	长度	是否为空	主键	自增	备注
identify	int	11	N	Y	Y	自增id
lng						经度
lat						纬度
uid						用户id

 * */
@XmlRootElement
public class Location {
private Integer identify;
private float lng;
private float lat;
private Integer uid;
public Integer getIdentify() {
	return identify;
}
public void setIdentify(Integer identify) {
	this.identify = identify;
}
public float getLng() {
	return lng;
}
public void setLng(float lng) {
	this.lng = lng;
}
public float getLat() {
	return lat;
}
public void setLat(float lat) {
	this.lat = lat;
}
public Integer getUid() {
	return uid;
}
public void setUid(Integer uid) {
	this.uid = uid;
}


}
