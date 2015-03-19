package br.com.restful.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 属性	类型	长度	是否为空	主键	自增	备注
identify	int	11	N	Y	Y	自增id
imgurl						
imglocal						大图
imgicon						小图
imgcontent						图片描述
anserid						答案id
questionid						问题id
imgdate						图片创建时间

 * */
@XmlRootElement
public class ImageInfo {
private Integer identify;
private String imgurl;
private String imglocal;
private String imgicon;
private String imgcontent;
private Integer anserid;
private Integer questionid;
private Date imgdate;
public Integer getIdentify() {
	return identify;
}
public void setIdentify(Integer identify) {
	this.identify = identify;
}
public String getImgurl() {
	return imgurl;
}
public void setImgurl(String imgurl) {
	this.imgurl = imgurl;
}
public String getImglocal() {
	return imglocal;
}
public void setImglocal(String imglocal) {
	this.imglocal = imglocal;
}
public String getImgicon() {
	return imgicon;
}
public void setImgicon(String imgicon) {
	this.imgicon = imgicon;
}
public String getImgcontent() {
	return imgcontent;
}
public void setImgcontent(String imgcontent) {
	this.imgcontent = imgcontent;
}
public Integer getAnserid() {
	return anserid;
}
public void setAnserid(Integer anserid) {
	this.anserid = anserid;
}
public Integer getQuestionid() {
	return questionid;
}
public void setQuestionid(Integer questionid) {
	this.questionid = questionid;
}
public Date getImgdate() {
	return imgdate;
}
public void setImgdate(Date imgdate) {
	this.imgdate = imgdate;
}


}
