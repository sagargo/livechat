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
		ag1.setAgentName("sagar");
		ag1.setUserName("sagarmali24");
		ag1.setPassword("sagar1987");
		
		Agent ag2=new Agent();
		ag2.setAgentName("sagar2");
		ag2.setUserName("sagarmali242");
		ag2.setPassword("sagar19872");
		
		cp1.getAgents().add(ag1);
		cp1.getAgents().add(ag2);
		
		ag1.getChatPoints().add(cp1);
		ag2.getChatPoints().add(cp1);
		
		chatPointRepository.save(cp1);
		
		ChatPoint cp2=new ChatPoint();
		cp2.setChatPointName("cp2");
		
		Agent ag3=new Agent();
		ag3.setAgentName("sagar3");
		ag3.setUserName("sagarmali243");
		ag3.setPassword("sagar19873");
		
		cp2.getAgents().add(ag3);
		
		ag3.getChatPoints().add(cp2);
		
		chatPointRepository.save(cp2);
		
		
		
		
		
		
	}       
}            