package com.xp.livechat.service;

import java.util.List;

import com.xp.livechat.entity.Agent;

public interface IAgentService {
     List<Agent> getAllAgents();
     Agent getAgentById(long AgentId);
     boolean addAgent(Agent Agent);
     void updateAgent(Agent Agent);
     void deleteAgent(int AgentId);
}
