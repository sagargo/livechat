package com.xp.livechat.service;

import java.util.List;

import com.xp.livechat.entity.ChatPoint;

public interface IChatPointService {
     List<ChatPoint> getAllChatPoints();
     ChatPoint getChatPointById(long ChatPointId);
     boolean addChatPoint(ChatPoint ChatPoint);
     void updateChatPoint(ChatPoint ChatPoint);
     void deleteChatPoint(int ChatPointId);
}
