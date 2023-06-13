package com.springdemo.service;

import com.springdemo.dto.OAuthData;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestConsumerOAuthToken {

    public String OAuthRetrieve(String URL, Object... uriVariables){
        RestTemplate template = new RestTemplate();
        OAuthData oAuthData = new OAuthData();
        oAuthData = template.getForObject(URL, OAuthData.class);
        return oAuthData.getAccess_token();
    }
}
