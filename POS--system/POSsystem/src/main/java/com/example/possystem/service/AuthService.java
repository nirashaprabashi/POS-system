package com.example.possystem.service;

import com.example.possystem.model.UserData;
import com.example.possystem.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    PasswordEncoder passwordEncoder;

    //    public UserData authenticateUser(String username, String password, String userCategory) {
//        // Implement your authentication logic here, for example, querying the database
//        UserData user = userRepo.findByUsernameAndPasswordAndUserCategory(username, password, userCategory);
//
//        if (user == null) {
//            // Throw an exception or handle authentication failure as needed
//            throw new RuntimeException("Authentication failed");
//        }
//
//        return user;
//    }
    public UserData authenticateUser(String username, String password, String userCategory) {
        Optional<UserData> userOpt = userRepo.findByUsernameAndUserCategory(username, userCategory);
        if (userOpt.isPresent()) {
            UserData user = userOpt.get();
            // Compare the passwords
            if (passwordEncoder.matches(password, user.getPassword())) {
                return user;
            }
        }
        throw new RuntimeException("Authentication failed");
    }
}
