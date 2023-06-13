package com.example.hybris.controller;

import com.example.hybris.api.oauth.OAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private OAuthService oAuthService;

    @GetMapping("/oAuthToken")
    public String getOAuthToken(){
        return oAuthService.getOAuthToken();
    }
}
