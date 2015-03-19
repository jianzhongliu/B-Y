package br.com.restful.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * 属性	类型	长度	是否为空	主键	自增	备注
identify	int	11	N	Y	Y	自增id
uphone	vchar	100				用户的电话
email	vchar	100				用户的邮箱
blog	vchar	100				用户的博客地址
anum	int	11				回答问题数
gnum	int	11				问题采纳次数
qnum	int	11				提问次数
goldpay	float					支出金额
goldget	float					收入金额
degree	vchar	100				职业
address	vchar	100				住址
icon	vchar	100				头像
name						姓名
gender						性别
birthday						出生年月
singname						个性签名或说明
userQQID						三方登陆的token
lastactive						最后活跃时间
level						级别：根据点赞数*0.1+获得金钱数*0.3+支出金钱数*0.5+平均日活跃时间/8*0.1

 * 
 * */
@XmlRootElement
public class User {
private Integer identify;
private String uphone ;
private String email;
private String blog;
private Integer anum;
private Integer gnum;
private Integer qnum;
private float goldpay;
private float goldget ;
private String degree;
private String address;
private String icon;
private String name;
private Integer gender;
private Date birthday;
private String singname;
private String userqqid;
private Date lastactive;
private Integer level;
public Integer getIdentify() {
	return identify;
}
public void setIdentify(Integer identify) {
	this.identify = identify;
}
public String getUphone() {
	return uphone;
}
public void setUphone(String uphone) {
	this.uphone = uphone;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getBlog() {
	return blog;
}
public void setBlog(String blog) {
	this.blog = blog;
}
public Integer getAnum() {
	return anum;
}
public void setAnum(Integer anum) {
	this.anum = anum;
}
public Integer getGnum() {
	return gnum;
}
public void setGnum(Integer gnum) {
	this.gnum = gnum;
}
public Integer getQnum() {
	return qnum;
}
public void setQnum(Integer qnum) {
	this.qnum = qnum;
}
public float getGoldpay() {
	return goldpay;
}
public void setGoldpay(float goldpay) {
	this.goldpay = goldpay;
}
public float getGoldget() {
	return goldget;
}
public void setGoldget(float goldget) {
	this.goldget = goldget;
}
public String getDegree() {
	return degree;
}
public void setDegree(String degree) {
	this.degree = degree;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getIcon() {
	return icon;
}
public void setIcon(String icon) {
	this.icon = icon;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Integer getGender() {
	return gender;
}
public void setGender(Integer gender) {
	this.gender = gender;
}
public Date getBirthday() {
	return birthday;
}
public void setBirthday(Date birthday) {
	this.birthday = birthday;
}
public String getSingname() {
	return singname;
}
public void setSingname(String singname) {
	this.singname = singname;
}
public String getUserqqid() {
	return userqqid;
}
public void setUserqqid(String userqqid) {
	this.userqqid = userqqid;
}
public Date getLastactive() {
	return lastactive;
}
public void setLastactive(Date lastactive) {
	this.lastactive = lastactive;
}
public Integer getLevel() {
	return level;
}
public void setLevel(Integer level) {
	this.level = level;
}



}
