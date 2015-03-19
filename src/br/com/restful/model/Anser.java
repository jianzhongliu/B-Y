package br.com.restful.model;

import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * 属性	类型	长度	是否为空	主键	自增	备注
identify	int	11	N	Y	Y	自增id
auid	int	11	N			回答者id
qid	int	11	N			对应问题id
status	int	1				是否采纳：0表示没有采纳，1表示被采纳
score	int	2				答案满意度
content	vchar					答案内容
adate	date					答案创建时间

 * 
 * 
 * */
@XmlRootElement
public class Anser {
	
private Integer identify;
private Integer auid;
private Integer qid;
private Integer status;
private Integer score;
private String content;
private Date adate;


public Integer getIdentify() {
	return identify;
}
public void setIdentify(Integer identify) {
	this.identify = identify;
}
public Integer getAuid() {
	return auid;
}
public void setAuid(Integer auid) {
	this.auid = auid;
}
public Integer getQid() {
	return qid;
}
public void setQid(Integer qid) {
	this.qid = qid;
}
public Integer getStatus() {
	return status;
}
public void setStatus(Integer status) {
	this.status = status;
}
public Integer getScore() {
	return score;
}
public void setScore(Integer score) {
	this.score = score;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public Date getAdate() {
	return adate;
}
public void setAdate(Date adate) {
	this.adate = adate;
}

@Override
public String toString() {
	return "[identify=" + identify + ", auid=" + auid +", qid=" + qid +", status=" + status + ", score=" + score
			+ ", content=" + content + ", adate=" + adate + "]";
}


}
