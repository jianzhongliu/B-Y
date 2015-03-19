package br.com.restful.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 属性	类型	长度	是否为空	主键	自增	备注
identify	int	11	N	Y	Y	自增id
content						评价内容
score						评价分数
apprisedate						评价时间
uid						用户id
qid						问题id
aid						答案id

 * */
@XmlRootElement
public class Appraise {
private Integer identify ;
private String content;
private float score;
private Date apprisedate;
private Integer uid;
private Integer qid;
private Integer aid;
public Integer getIdentify() {
	return identify;
}
public void setIdentify(Integer identify) {
	this.identify = identify;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public float getScore() {
	return score;
}
public void setScore(float score) {
	this.score = score;
}
public Date getApprisedate() {
	return apprisedate;
}
public void setApprisedate(Date apprisedate) {
	this.apprisedate = apprisedate;
}
public Integer getUid() {
	return uid;
}
public void setUid(Integer uid) {
	this.uid = uid;
}
public Integer getQid() {
	return qid;
}
public void setQid(Integer qid) {
	this.qid = qid;
}
public Integer getAid() {
	return aid;
}
public void setAid(Integer aid) {
	this.aid = aid;
}


}
