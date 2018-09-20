package com.xp.livechat.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.xp.livechat.entity.ChatPoint;

public interface ChatPointRepository extends CrudRepository<ChatPoint, Long>  {
    List<ChatPoint> findByChatPointName(String chatPointName);
/*    List<ChatPoint> findDistinctByCategory(String category);
    List<ChatPoint> findByTitleAndCategory(String title, String category);
    */
}
