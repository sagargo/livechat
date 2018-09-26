package com.xp.livechat.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.xp.livechat.entity.Agent;
import com.xp.livechat.service.IAgentService;

@Controller
@RequestMapping("rest/livechat")
public class AgentController {
	
	@Autowired
	private IAgentService agentService;
	
	@GetMapping("agent/{id}")
	public ResponseEntity<Agent> getAgentById(@PathVariable("id") Integer id) {
		Agent Agent = agentService.getAgentById(id);
		return new ResponseEntity<Agent>(Agent, HttpStatus.OK);
	}
	
	@GetMapping("agents")
	public ResponseEntity<List<Agent>> getAllAgents() {
		List<Agent> list = agentService.getAllAgents();
		return new ResponseEntity<List<Agent>>(list, HttpStatus.OK);
	}
	
	@PostMapping("agent")
	public ResponseEntity<Void> addAgent(@RequestBody Agent Agent, UriComponentsBuilder builder) {
        boolean flag = agentService.addAgent(Agent);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/agent/{id}").buildAndExpand(Agent.getAgentId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("agent")
	public ResponseEntity<Agent> updateAgent(@RequestBody Agent Agent) {
		agentService.updateAgent(Agent);
		return new ResponseEntity<Agent>(Agent, HttpStatus.OK);
	}
	
	@DeleteMapping("agent/{id}")
	public ResponseEntity<Void> deleteAgent(@PathVariable("id") Integer id) {
		agentService.deleteAgent(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
} 