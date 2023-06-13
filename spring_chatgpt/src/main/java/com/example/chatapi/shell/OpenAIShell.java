package com.example.chatapi.shell;

import com.example.chatapi.dto.ResponseDTO;
import com.example.chatapi.util.ChatResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class OpenAIShell {

    @Autowired
    ChatResponse response;

    @ShellMethod(key="openai", value="Communicate with openai chatbot.\n" +
            "Available Options: -p(Print Response)\n" +
            "Example: openai -p \"Hello World\"")
    public String openAiResponseMessage(@ShellOption(value="-p", optOut = true) String prompt) {
        if(prompt != null){
            return response.getResponse(prompt);
        }
        return "Error in providing prompt! Please try again!";
    }

}

