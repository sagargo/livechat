package com.xp.livechat.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xp.livechat.entity.Agent;
import com.xp.livechat.repository.AgentRepository;

@Service
public class AgentService implements IAgentService {
	@Autowired
	private AgentRepository agentRepository;
	@Override
	public Agent getAgentById(long AgentId) {
		Agent obj = agentRepository.findById(AgentId).get();
		return obj;
	}	
	@Override
	public List<Agent> getAllAgents(){
		List<Agent> list = new ArrayList<>();
		agentRepository.findAll().forEach(e -> list.add(e));
		return list;
	}
	@Override
	public synchronized boolean addAgent(Agent Agent){
	   List<Agent> list = agentRepository.findByAgentName(Agent.getAgentName()); 	
       if (list.size() > 0) {
    	   return false;
       } else {
    	   agentRepository.save(Agent);
    	   return true;
       }
	}
	@Override
	public void updateAgent(Agent Agent) {
		agentRepository.save(Agent);
	}
	@Override
	public void deleteAgent(int AgentId) {
		agentRepository.delete(getAgentById(AgentId));
	}
}
