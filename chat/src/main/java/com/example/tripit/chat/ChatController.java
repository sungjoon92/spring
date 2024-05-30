package com.example.tripit.chat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.tripit.chat.dto.ChatMessage;
import com.example.tripit.chat.service.ChatService;

@Controller
public class ChatController {

	@Autowired
	ChatService chatservice;
	
	@RequestMapping("/chat/room")
	public ModelAndView chatRoom(@RequestParam(value="roomId") int roomId) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("chat/room");
		return mav;
	}
	@RequestMapping("/chat/doAddMessage")
	@ResponseBody
	public Map<String, Object> doaddMessage(int roomId, String writer ,String body) {
		Map<String, Object> rs = new HashMap<>();
		
		chatservice.addMessage(roomId, writer, body);
		rs.put("resultCode", "S-1");
		rs.put("msg","채팅 메세지가 추가되었습니다.");
		
		return rs;
	}
	
	@PostMapping("/chat/getMessage")
	@ResponseBody
	public List<ChatMessage> getMessage() {
		
		return chatservice.getMessages();
	}
	
	
}
