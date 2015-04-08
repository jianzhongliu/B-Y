package com.by.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class comment {
	private	Integer identify;
	private	String userid;
	private	String touristid;
	private	String content;
	private	String replycontent;
	private	Integer commentdate;
	private	Integer replaydate;
	
	
	public Integer getIdentify() {
		return identify;
	}


	public void setIdentify(Integer identify) {
		this.identify = identify;
	}


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getTouristid() {
		return touristid;
	}


	public void setTouristid(String touristid) {
		this.touristid = touristid;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getReplycontent() {
		return replycontent;
	}


	public void setReplycontent(String replycontent) {
		this.replycontent = replycontent;
	}


	public Integer getCommentdate() {
		return commentdate;
	}


	public void setCommentdate(Integer commentdate) {
		this.commentdate = commentdate;
	}


	public Integer getReplaydate() {
		return replaydate;
	}


	public void setReplaydate(Integer replaydate) {
		this.replaydate = replaydate;
	}


	@Override
	public String toString() {
		return "[identify=" + "" + "]";
	}

}
