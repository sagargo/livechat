package com.xp.livechat.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="chat_points")
public class ChatPoint implements Serializable { 
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="chat_point_id")
    private long chatPointId;  
	@Column(name="chat_point_name")
    private String chatPointName;
	public long getChatPointId() {
		return chatPointId;
	}
	public void setChatPointId(long chatPointId) {
		this.chatPointId = chatPointId;
	}
	public String getChatPointName() {
		return chatPointName;
	}
	public void setChatPointName(String chatPointName) {
		this.chatPointName = chatPointName;
	}
	
	
} 