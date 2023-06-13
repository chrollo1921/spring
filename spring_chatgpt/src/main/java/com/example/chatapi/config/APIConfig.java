package com.example.chatapi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class APIConfig {

    @Value("${openai.api.key}")
    private String apiKey;

    @Bean
    public RestTemplate template(){
        RestTemplate template = new RestTemplate();
        template.getInterceptors().add((request,body, execution) -> {
            request.getHeaders().add("Authorization", "Bearer " + apiKey);
            request.getHeaders().add("Content-Type", "application/json");
            return execution.execute(request, body);
        });
        return template;
    }
}
