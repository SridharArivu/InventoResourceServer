package com.example.resourceserver.components;

import com.example.resourceserver.UserRegistration.User;
import com.example.resourceserver.UserRegistration.UserRepository;
import com.example.resourceserver.entity.AccessTokenResponse;
import com.example.resourceserver.entity.LowStokeNotifyURL;
import com.example.resourceserver.entity.Product;
import com.example.resourceserver.repository.NotifyUrlRepository;
import com.example.resourceserver.repository.addProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Component
@RestController
public class quantityCheckScheduler {

    private final RestTemplate restTemplate;

    public quantityCheckScheduler(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private final String url = "https://cliq.zoho.com/company/837767044/api/v2/bots/invento/incoming?zapikey=1001.96608d133e2fa996bb1d52db14206c05.6139876b4dbea7a7c9352285aeac7735";

    @Autowired
    private addProductRepository repository;

    @Autowired
    private NotifyUrlRepository notifyUrlRepository;

    @Autowired
    private UserRepository userRepository;
    @Scheduled(fixedRate = 1800000)
    @GetMapping("/lowStoke")
    public void lowStoke(){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        List<User> UserList = userRepository.findAll();

        Set<String> ClientIdList = new HashSet<>();

        for (User product: UserList) {
            ClientIdList.add(product.getClientId());
        }



        List<String> Body = new ArrayList<>();

        for (String clientID: ClientIdList) {

            List<Product> productList = repository.findAllByClientId(clientID);
            for (Product p: productList) {
                if (p.getQuantity() <= 50){

                    Body.add(p.getTitle() + ": " + p.getQuantity());
                }
            }
            if (!Body.isEmpty() ){
                LowStokeNotifyURL url = notifyUrlRepository.findByClientId(clientID);
                HttpEntity<List<String>> requestEntity = new HttpEntity<>(Body, headers);
                ResponseEntity<String> responseEntity = restTemplate.postForEntity(url.getUrl(), requestEntity, String.class);
            }
            Body.clear();
        }


    }
}
