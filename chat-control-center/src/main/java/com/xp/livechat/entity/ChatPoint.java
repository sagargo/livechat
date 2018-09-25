package com.xp.livechat.entity;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.xp.livechat.audit.AuditModel;

@Entity
@Table(name="chat_points")
public class ChatPoint extends AuditModel implements Serializable { 
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="chat_point_id")
    private long chatPointId;  
	
	@NotNull
	@Size(max = 100)
	@Column(name="chat_point_name")
    private String chatPointName;
	
	
	  @ManyToMany(fetch = FetchType.LAZY,
	            cascade = {
	                CascadeType.PERSIST,
	                CascadeType.MERGE
	            },
	  mappedBy = "chatPoints")
	    private Set<Agent> agents = new HashSet<>();
	
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
	public Set<Agent> getAgents() {
		return agents;
	}
	public void setAgents(Set<Agent> agents) {
		this.agents = agents;
	}
	
	
	
	
} 