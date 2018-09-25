package com.xp.livechat.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xp.livechat.entity.ChatPoint;
import com.xp.livechat.repository.ChatPointRepository;
@Service
public class ChatPointService implements IChatPointService {
	@Autowired
	private ChatPointRepository chatPointRepository;
	@Override
	public ChatPoint getChatPointById(long chatPointId) {
		ChatPoint obj = chatPointRepository.findById(chatPointId).get();
		return obj;
	}	
	@Override
	public List<ChatPoint> getAllChatPoints(){
		List<ChatPoint> list = new ArrayList<>();
		chatPointRepository.findAll().forEach(e -> list.add(e));
		return list;
	}
	@Override
	public synchronized boolean addChatPoint(ChatPoint chatPoint){
	   List<ChatPoint> list = chatPointRepository.findByChatPointName(chatPoint.getChatPointName()); 	
       if (list.size() > 0) {
    	   return false;
       } else {
    	   chatPointRepository.save(chatPoint);
    	   return true;
       }
	}
	@Override
	public void updateChatPoint(ChatPoint chatPoint) {
		chatPointRepository.save(chatPoint);
	}
	@Override
	public void deleteChatPoint(int ChatPointId) {
		chatPointRepository.delete(getChatPointById(ChatPointId));
	}
}
