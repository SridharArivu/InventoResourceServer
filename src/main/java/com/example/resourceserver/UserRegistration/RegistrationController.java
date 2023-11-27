package com.example.resourceserver.UserRegistration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public ResponseEntity<Client> UserRegistration(
            @RequestParam String username,
            @RequestParam String email,
            @RequestParam String password
       ){
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        if (!userRepository.existsByEmail(email)){
            Client client = userService.AddUser(user);
            return new ResponseEntity<>(client,HttpStatus.OK);
        }else return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @GetMapping("/login")
    public ResponseEntity<Client> UserLogin(@RequestParam String email, @RequestParam String password){

        if (userRepository.existsByEmail(email) && userRepository.existsByPassword(password)){
            Client client = userService.login(email);
            return new ResponseEntity<>(client,HttpStatus.OK);
        }else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
