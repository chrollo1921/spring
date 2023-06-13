package com.example.hybris.api.services;

import com.example.hybris.api.oauth.OAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class OCCBasesites {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    OAuthService oAuthService;

    @GetMapping("/getBaseSites")
    public String getUser(@RequestParam(name="fields") String fields){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(oAuthService.getOAuthToken());
        HttpEntity<?> entity = new HttpEntity<>(headers);
        Map<String, String> params = new HashMap<>();
        params.put("fields", fields);

        ClientHttpRequestInterceptor interceptor = new ClientHttpRequestInterceptor() {
            @Override
            public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {

            }
        }

        String url = "https://localhost:9002/trainingwebservices/v2/basesites";
        UriComponents urlTemplate = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("fields", fields)
                .encode()
                .build();
        oAuthService.ignoreCertificates();
        ResponseEntity<Object> response = oAuthService.getResponse(urlTemplate, HttpMethod.GET, entity);
        return response.toString();
    }
}
