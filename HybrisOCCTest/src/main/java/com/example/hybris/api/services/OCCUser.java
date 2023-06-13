package com.example.hybris.api.services;

import com.example.hybris.api.oauth.OAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class OCCUser {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    OAuthService oAuthService;

    @GetMapping("/getUser/{baseSiteId}/{userId}")
    public String getUser(@PathVariable(name="baseSiteId") String baseSiteId,
                          @PathVariable(name="userId") String userId){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization" , "Bearer " + oAuthService.getOAuthToken());
        HttpEntity<?> entity = new HttpEntity<>(headers);

        String url = "https://localhost:9002/trainingwebservices/" + baseSiteId + "/orgUsers/" + userId;
        UriComponents urlTemplate = UriComponentsBuilder.fromHttpUrl(url)
                .build();

        oAuthService.ignoreCertificates();
        ResponseEntity<Object> response = oAuthService.getResponse(urlTemplate, HttpMethod.GET, entity);
        return response.toString();
    }

}
