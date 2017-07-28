package com.yttrium.domain;

import java.util.Date;

public class Message {
	private Integer messageId;

	private String messageTitle;

	private Date messageTime;

	private Integer userId;

	private String messageContent;

	//显示用
	private String userName;

	public Integer getMessageId() {
		return messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	public String getMessageTitle() {
		return messageTitle;
	}

	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle == null ? null : messageTitle.trim();
	}

	public Date getMessageTime() {
		return messageTime;
	}

	public void setMessageTime(Date messageTime) {
		this.messageTime = messageTime;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent == null ? null : messageContent.trim();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}