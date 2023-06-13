package com.example.chatapi.entity;

import com.example.chatapi.dto.ResponseDTO;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Choices {

    private String text;
    private String index;
    private String logprobs;
    private String finish_reason;

}
