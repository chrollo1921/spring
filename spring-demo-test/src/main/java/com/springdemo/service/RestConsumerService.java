package com.springdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RestConsumerService {

    @Autowired
    RestConsumerOAuthToken restConsumerOAuthToken;

    @Value("${custom.service.clientId}")
    private String clientId;
    @Value("${custom.service.clientSecret}")
    private String clientSecret;
    @Value("${custom.service.grantType}")
    private String grantType;

    Map<String,String> uriParams = new HashMap<>();

    public String oAuthGetter(){
        uriParams.put("clientId", clientId);
        uriParams.put("clientSecret", clientSecret);
        uriParams.put("grantType", grantType);

        String token = restConsumerOAuthToken.OAuthRetrieve("http://localhost:9001/authorizationserver/oauth/token?client_id=occKarthik&client_secret=nimda&grant_type=client_credentials", uriParams);
        System.out.println(token);
        return token;
    }
}
