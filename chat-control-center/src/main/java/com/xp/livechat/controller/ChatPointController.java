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

import com.xp.livechat.entity.ChatPoint;
import com.xp.livechat.service.IChatPointService;

@Controller
@RequestMapping("rest/livechat")
public class ChatPointController {
	
	@Autowired
	private IChatPointService chatPointService;
	
	@GetMapping("chatpoint/{id}")
	public ResponseEntity<ChatPoint> getChatPointById(@PathVariable("id") Integer id) {
		ChatPoint chatpoint = chatPointService.getChatPointById(id);
		return new ResponseEntity<ChatPoint>(chatpoint, HttpStatus.OK);
	}
	
	@GetMapping("chatpoints")
	public ResponseEntity<List<ChatPoint>> getAllChatPoints() {
		List<ChatPoint> list = chatPointService.getAllChatPoints();
		return new ResponseEntity<List<ChatPoint>>(list, HttpStatus.OK);
	}
	
	@PostMapping("chatpoint")
	public ResponseEntity<Void> addChatPoint(@RequestBody ChatPoint chatpoint, UriComponentsBuilder builder) {
        boolean flag = chatPointService.addChatPoint(chatpoint);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/chatpoint/{id}").buildAndExpand(chatpoint.getChatPointId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("chatpoint")
	public ResponseEntity<ChatPoint> updateChatPoint(@RequestBody ChatPoint chatpoint) {
		chatPointService.updateChatPoint(chatpoint);
		return new ResponseEntity<ChatPoint>(chatpoint, HttpStatus.OK);
	}
	
	@DeleteMapping("chatpoint/{id}")
	public ResponseEntity<Void> deleteChatPoint(@PathVariable("id") Integer id) {
		chatPointService.deleteChatPoint(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
} 