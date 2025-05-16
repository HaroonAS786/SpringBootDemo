package com.edigest.myFisrtProject.dependencyInjection.userRegisteration;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final EmailNotificationService emailNotificationService;

    public UserService(UserRepository userRepository, EmailNotificationService emailNotificationService) {
        this.userRepository = userRepository;
        this.emailNotificationService = emailNotificationService;
    }
    
    public void registerUser(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            System.out.println("User already exists with email: " + user.getEmail());
        }
        userRepository.save(user);
        emailNotificationService.send("You registered Successfully: ", user.getEmail());
    }
}
