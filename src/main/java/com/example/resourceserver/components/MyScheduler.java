package com.example.resourceserver.components;

import com.example.resourceserver.entity.AccessTokenResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
public class MyScheduler {

    private final String apiUrl = "https://oauth2authorizeserver.uc.r.appspot.com/oauth2/token";


    private final RestTemplate restTemplate;

    public MyScheduler(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Scheduled(fixedRate = 600000)
    public void sendPostRequest() {
        // Set up request headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        // Set up request body parameters
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("grant_type", "client_credentials");
        requestBody.add("client_id", "client");
        requestBody.add("client_secret","secret");

        // Make the POST request
        ResponseEntity<AccessTokenResponse> responseEntity = restTemplate.postForEntity(apiUrl, new HttpEntity<>(requestBody, headers), AccessTokenResponse.class);

        // Get the deserialized response body
        AccessTokenResponse accessTokenResponse = responseEntity.getBody();



    }
}
