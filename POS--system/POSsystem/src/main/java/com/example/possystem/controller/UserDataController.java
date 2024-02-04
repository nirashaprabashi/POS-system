package com.example.possystem.controller;

import com.example.possystem.model.UserData;
import com.example.possystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userdata")
public class UserDataController {
    @Autowired
    UserService userService;

    @PostMapping("/add")
    public ResponseEntity<UserData> addUserData(@RequestBody UserData userData) {
        UserData savedUserData = userService.insertUserData(userData);
        return ResponseEntity.ok(savedUserData);
    }

    @GetMapping("/list")
    public List<UserData> getAllUserData() {
        return userService.getAllUserData();
    }


    @DeleteMapping("/{nic}")

    public ResponseEntity<Void> deleteUserData(@PathVariable String nic) {
        UserData userData = userService.findByNic(nic);
        if (userData != null) {
            userService.deleteUserData(nic);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{nic}")
    public ResponseEntity<UserData> updateUserData(@PathVariable String nic, @RequestBody UserData userData) {
        UserData updatedUserData = userService.updateUserData(nic, userData);
        if (updatedUserData != null) {
            return ResponseEntity.ok(updatedUserData);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
