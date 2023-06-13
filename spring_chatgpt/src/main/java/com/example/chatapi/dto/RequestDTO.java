package com.example.chatapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class RequestDTO {

    private String model;
    private String prompt;
    private int temperature;
    private int max_tokens;
    private int top_p;
    private int frequency_penalty;
    private int presence_penalty;

}
