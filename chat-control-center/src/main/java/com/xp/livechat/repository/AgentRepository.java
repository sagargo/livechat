package com.xp.livechat.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.xp.livechat.entity.Agent;

public interface AgentRepository extends CrudRepository<Agent, Long>  {
    List<Agent> findByAgentName(String AgentName);
/*    List<Agent> findDistinctByCategory(String category);
    List<Agent> findByTitleAndCategory(String title, String category);
    */
}
