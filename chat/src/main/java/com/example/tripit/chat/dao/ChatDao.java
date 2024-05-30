package com.example.tripit.chat.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.tripit.chat.dto.ChatMessage;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Component
public class ChatDao {
	private List<ChatMessage> chatMessages;
	
	public ChatDao() {
		chatMessages = new ArrayList<>();
		
				
	}
	public void addMessage(int roomId, String writer, String body) {
		int newId = chatMessages.size() + 1;
 		ChatMessage aChatMessage = new ChatMessage(newId, roomId, writer, body);
		
 		chatMessages.add(aChatMessage);
	}

	public List<ChatMessage> getMessages() {
		return chatMessages;
	}

}
