package com.example.chatapi.util;

import com.example.chatapi.dto.RequestDTO;
import com.example.chatapi.dto.ResponseDTO;
import org.apache.commons.lang3.time.StopWatch;
import org.hibernate.annotations.CurrentTimestamp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ChatResponse {

    private static final Logger LOG= LoggerFactory.getLogger(ChatResponse.class);

    @Autowired
    private RestTemplate template;

    @Value("${openai.request.model}")
    private String model;
    @Value("${openai.request.temperature}")
    private int temperature;
    @Value("${openai.request.max_tokens}")
    private int max_tokens;
    @Value("${openai.request.top_p}")
    private int top_p;
    @Value("${openai.request.frequency_penalty}")
    private int frequency_penalty;
    @Value("${openai.request.presence_penalty}")
    private int presence_penalty;
    @Value("${openai.api.url}")
    private String url;

    public String getResponse(String prompt){
        RequestDTO requestDTO = buildRequest(prompt);
        LOG.info("API Request Started:: " + new SimpleDateFormat("MM/dd/yyyy h:mm:ss a").format(new Date()));
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        ResponseDTO responseDTO = template.postForObject(url, requestDTO, ResponseDTO.class);
        stopWatch.stop();
        LOG.info("API Request Completed:: " + new SimpleDateFormat("MM/dd/yyyy h:mm:ss a").format(new Date()));
        LOG.info("Timetaken for the response:: " + stopWatch.getNanoTime());
        return responseDTO.getChoices().get(0).getText();
    }

    public ResponseDTO getWholeResponse(String prompt){
        RequestDTO requestDTO = buildRequest(prompt);
        LOG.info("API Request Started:: " + new SimpleDateFormat("MM/dd/yyyy h:mm:ss a"));
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        ResponseDTO responseDTO = template.postForObject(url, requestDTO, ResponseDTO.class);
        stopWatch.stop();
        LOG.info("Timetaken for the response:: " + stopWatch.getTime());
        return responseDTO;
    }

    private RequestDTO buildRequest(String prompt){
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setPrompt(prompt);
        requestDTO.setModel(model);
        requestDTO.setTemperature(temperature);
        requestDTO.setMax_tokens(max_tokens);
        requestDTO.setTop_p(top_p);
        requestDTO.setFrequency_penalty(frequency_penalty);
        requestDTO.setPresence_penalty(presence_penalty);

        return requestDTO;
    }
}
