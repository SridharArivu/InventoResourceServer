package com.example.resourceserver.controller;

import com.example.resourceserver.config.SecurityConfig;
import com.example.resourceserver.entity.LowStokeNotifyURL;
import com.example.resourceserver.repository.NotifyUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class NotifyUrlController {

    @Autowired
    private NotifyUrlRepository notifyUrlRepository;

    @PostMapping("/IncomingWebhookUrl")
    public ResponseEntity<String> addUrl(@RequestParam String url, @RequestParam String token){


        LowStokeNotifyURL LowStoke = new LowStokeNotifyURL();

        LowStoke.setUrl(url + "?zapikey=" + token);
        LowStoke.setClientId(SecurityConfig.clientID);

        notifyUrlRepository.save(LowStoke);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
