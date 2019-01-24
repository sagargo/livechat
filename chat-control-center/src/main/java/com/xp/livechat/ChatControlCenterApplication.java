package com.xp.livechat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.xp.livechat.entity.Agent;
import com.xp.livechat.entity.ChatPoint;
import com.xp.livechat.repository.AgentRepository;
import com.xp.livechat.repository.ChatPointRepository;

@SpringBootApplication
@EnableJpaAuditing
public class ChatControlCenterApplication implements CommandLineRunner{  
	
	@Autowired
	private AgentRepository agentRespository;
	
	@Autowired
	private ChatPointRepository chatPointRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ChatControlCenterApplication.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		ChatPoint cp1=new ChatPoint();
		cp1.setChatPointName("cp1");
		
		Agent ag1=new Agent();
		ag1.setAgentName("Agent1");
		ag1.setUserName("a1user");
		ag1.setPassword("a1pass");
		
		Agent ag2=new Agent();
		ag2.setAgentName("Agent2");
		ag2.setUserName("a2user");
		ag2.setPassword("a2pass");
		
		cp1.getAgents().add(ag1);
		cp1.getAgents().add(ag2);
		
		ag1.getChatPoints().add(cp1);
		ag2.getChatPoints().add(cp1);
		
		chatPointRepository.save(cp1);
		
		ChatPoint cp2=new ChatPoint();
		cp2.setChatPointName("cp2");
		
		Agent ag3=new Agent();
		ag3.setAgentName("Agent3");
		ag3.setUserName("a3user");
		ag3.setPassword("a3pass");
		
		cp2.getAgents().add(ag3);
		
		ag3.getChatPoints().add(cp2);
		
		chatPointRepository.save(cp2);
		
		Agent ag4=new Agent();
		ag4.setAgentName("Agent4");
		ag4.setUserName("a4user");
		ag4.setPassword("a4pass");
		
		agentRespository.save(ag4);
		
		Agent ag5=new Agent();
		ag5.setAgentName("Agent5");
		ag5.setUserName("a5user");
		ag5.setPassword("a5pass");
		
		agentRespository.save(ag5);
		
	}       
}            