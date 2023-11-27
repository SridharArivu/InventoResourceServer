package com.example.resourceserver.UserRegistration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClientRepository clientRepository;


    public Client AddUser(User user) {

        String Username = user.getUsername().substring(0,6);

        StringBuilder ClientId = new StringBuilder();
        ClientId.append(Username + "_").append("InventoID" + "_").append(UUID.randomUUID().toString(), 0, 7);

        StringBuilder ClientSecret = new StringBuilder();
        ClientSecret.append("Invento" + "_").append(Username + "_").append(UUID.randomUUID().toString(), 0, 7);

        User u = new User();
        u.setUsername(user.getUsername());
        u.setEmail(user.getEmail());
        u.setPassword(user.getPassword());
        u.setClientId(ClientId.toString());

        Client client = new Client();
        client.setClientId(ClientId.toString());
        client.setSecret(ClientSecret.toString());
        client.setEmail(user.getEmail());

        userRepository.save(u);
        return clientRepository.save(client);
    }


    public Client login(String email){

        return clientRepository.findByEmail(email);
    };
}
