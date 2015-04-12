package com.by.response;


import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

import com.by.model.Comment;
import com.by.model.Message;

@XmlRootElement
public class TouristResponseObject {
	private String status;
	private StringBuffer errorMSG;
	private int errorCode;//错误码
	private ArrayList<Message> messageArray;//留言
	private ArrayList<Comment> commentArray;//评论
	private int type;
	
	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public StringBuffer getErrorMSG() {
		return errorMSG;
	}


	public void setErrorMSG(StringBuffer errorMSG) {
		this.errorMSG = errorMSG;
	}


	public int getErrorCode() {
		return errorCode;
	}


	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}

	public ArrayList<Message> getMessageArray() {
		return messageArray;
	}


	public void setMessageArray(ArrayList<Message> messageArray) {
		this.messageArray = messageArray;
	}


	public ArrayList<Comment> getCommentArray() {
		return commentArray;
	}


	public void setCommentArray(ArrayList<Comment> commentArray) {
		this.commentArray = commentArray;
	}


	@Override
	public String toString() {
		return "[errorMSG=" + errorMSG + ", errorCode=" + errorCode  + "status=" + status + "dataArray=" + commentArray +"messageArray" + messageArray +"]";
	}

}
