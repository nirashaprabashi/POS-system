package com.example.possystem.controller;

import com.example.possystem.model.UserData;
import com.example.possystem.model.UserLoginRequest;
import com.example.possystem.security.JwtTokenProvider;
import com.example.possystem.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthService authService;
    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginRequest userLoginRequest) {
        try {
            UserData authenticatedUser = authService.authenticateUser(
                    userLoginRequest.getUsername(),
                    userLoginRequest.getPassword(),
                    userLoginRequest.getUserCategory());

            if (authenticatedUser != null) {
                String token = jwtTokenProvider.generateToken(authenticatedUser.getUsername());

                // Preparing the response
                Map<String, String> response = new HashMap<>();
                response.put("token", token);
                response.put("userCategory", authenticatedUser.getUserCategory());

                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.badRequest().body("Invalid credentials");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Authentication failed: " + e.getMessage());
        }
    }
}
