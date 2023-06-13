package com.example.hybris.api.oauth;

import com.example.hybris.dto.OAuthResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

@Service
public class OAuthService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${oauth.rest.url}")
    private String url;
    @Value("${oauth.rest.client_id}")
    private String client_id;
    @Value("${oauth.rest.client_secret}")
    private String client_secret;
    @Value("${oauth.rest.grant_type}")
    private String grant_type;

    public String getOAuthToken() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        /*Map<String, String> params = new HashMap<>();
        params.put("client_id", client_id);
        params.put("client_secret", client_secret);
        params.put("grant_type", grant_type);
        ignoreCertificates();
        HttpEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                String.class,
                params
        );*/
        ignoreCertificates();
        ResponseEntity<OAuthResponseDTO> response = restTemplate.exchange(url, HttpMethod.POST, entity, OAuthResponseDTO.class);
        return response.getBody().getAccess_token();
    }

    public void ignoreCertificates() {
        TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }

            @Override
            public void checkClientTrusted(X509Certificate[] certs, String authType) {
            }

            @Override
            public void checkServerTrusted(X509Certificate[] certs, String authType) {
            }
        }};

        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {


        }
    }

    public ResponseEntity<Object> getResponse(UriComponents urlTemplate,HttpMethod httpMethod, HttpEntity<?> entity){
        ResponseEntity<Object> response = restTemplate.exchange(
                urlTemplate.toUri(),
                httpMethod,
                entity,
                Object.class
        );
        return response;
    }
}
