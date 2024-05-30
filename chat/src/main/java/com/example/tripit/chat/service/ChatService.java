package com.example.tripit.chat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tripit.chat.dao.ChatDao;
import com.example.tripit.chat.dto.ChatMessage;

@Service
public class ChatService {

	@Autowired
	ChatDao chatDao;
	public void addMessage(int roomId, String writer, String body) {
		chatDao.addMessage(roomId, writer, body);
	}
	public List<ChatMessage> getMessages() {
		return chatDao.getMessages();
	}
	
}
