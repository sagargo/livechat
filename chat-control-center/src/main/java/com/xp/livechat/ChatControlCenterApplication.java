package com.xp.livechat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ChatControlCenterApplication {  
	public static void main(String[] args) {
		SpringApplication.run(ChatControlCenterApplication.class, args);
    }       
}            