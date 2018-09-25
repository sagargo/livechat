package com.xp.livechat.service;

import java.util.List;

import com.xp.livechat.entity.ChatPoint;

public interface IChatPointService {
     List<ChatPoint> getAllChatPoints();
     ChatPoint getChatPointById(long chatPointId);
     boolean addChatPoint(ChatPoint chatPoint);
     void updateChatPoint(ChatPoint chatPoint);
     void deleteChatPoint(int chatPointId);
}
