package com.example.resourceserver.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Component
public class pingController {

    private final RestTemplate restTemplate;

    public pingController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/ping")
    public String ping(){
        return "Pinged";
    }

    private final String url = "https://orbital-nuance-403709.el.r.appspot.com/ping";

    @Scheduled(fixedRate = 600000)
    public void sendGetRequest (){

        String response = restTemplate.getForObject(url, String.class);
    }
}
