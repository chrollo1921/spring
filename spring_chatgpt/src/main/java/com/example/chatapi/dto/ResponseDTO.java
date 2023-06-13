package com.example.chatapi.dto;

import com.example.chatapi.entity.Choices;
import com.example.chatapi.entity.Usage;
import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
public class ResponseDTO {


    private String id;
    private String object;
    private String created;
    private String model;
    private List<Choices> choices;
    private Usage usage;

}
