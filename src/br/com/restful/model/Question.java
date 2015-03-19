package br.com.restful.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * 
identify int	11	N	Y	Y	自增id
quid	int	11	N			提问人
title	vchar	200	N			标题
content	vchar	1000				问题内容
gold	float					价格
qdate	date					提问时间
qtime	date					问题限时，问题的截止日期
qclosedate	date					问题关闭时间
status	int	11				当前状态：0表示正常，1表示已关闭

 * 
 * */
@XmlRootElement
public class Question {
	
private Integer identify ;
private Integer quid;
private String title ;
private String content;
private float gold ;
private Date qdate ;
private Date qtime;
private Date qclosedate ;
private Integer status;
public Integer getIdentify() {
	return identify;
}
public void setIdentify(Integer identify) {
	this.identify = identify;
}
public Integer getQuid() {
	return quid;
}
public void setQuid(Integer quid) {
	this.quid = quid;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public float getGold() {
	return gold;
}
public void setGold(float gold) {
	this.gold = gold;
}
public Date getQdate() {
	return qdate;
}
public void setQdate(Date qdate) {
	this.qdate = qdate;
}
public Date getQtime() {
	return qtime;
}
public void setQtime(Date qtime) {
	this.qtime = qtime;
}
public Date getQclosedate() {
	return qclosedate;
}
public void setQclosedate(Date qclosedate) {
	this.qclosedate = qclosedate;
}
public Integer getStatus() {
	return status;
}
public void setStatus(Integer status) {
	this.status = status;
}



}
