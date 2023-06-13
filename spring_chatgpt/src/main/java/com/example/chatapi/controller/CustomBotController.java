package com.example.chatapi.controller;

import com.example.chatapi.dto.RequestDTO;
import com.example.chatapi.dto.ResponseDTO;
import com.example.chatapi.util.ChatResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CustomBotController {

    @Autowired
    ChatResponse response;

    @GetMapping("/chatwithme")
    public String chat(@RequestParam("prompt") String prompt){
        return response.getResponse(prompt);
    }
}
