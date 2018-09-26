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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.xp.livechat.audit.AuditModel;

@Entity
@Table(name="chat_agents")
public class Agent  extends AuditModel implements Serializable { 
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="agent_id")
    private long agentId;  
	
	@NotNull
	@Size(max = 100)
	@Column(name="agent_name")
    private String agentName;
	
	@NotNull
	@Size(max = 100)
	@Column(name="user_name")
    private String userName;
	
	@NotNull
	@Size(max = 100)
	@Column(name="password")
    private String password;
	

	  @ManyToMany(fetch = FetchType.LAZY,
	            cascade = {
	                CascadeType.PERSIST,
	                CascadeType.MERGE
	            })
	    @JoinTable(name = "agent_chatpoint_mapping",
	            joinColumns = { @JoinColumn(name = "agent_id") },
	            inverseJoinColumns = { @JoinColumn(name = "chat_point_id") })
	    private Set<ChatPoint> chatPoints = new HashSet<>();
	
	public long getAgentId() {
		return agentId;
	}
	public void setAgentId(long agentId) {
		this.agentId = agentId;
	}
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<ChatPoint> getChatPoints() {
		return chatPoints;
	}
	public void setChatPoints(Set<ChatPoint> chatPoints) {
		this.chatPoints = chatPoints;
	}

	
	
} 