package com.example.tripit.chat.controller;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.tripit.chat.model.ChatRoom;
import com.example.tripit.chat.service.ChatService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/chat")
public class ChatController {

    private final ChatService service;
    
    @PostMapping
    public ChatRoom createRoom(@RequestParam String name){
        
        return service.createRoom(name);
    }
    
    @GetMapping
    public List<ChatRoom> findAllRooms(){
        return service.findAllRoom();
    }
}