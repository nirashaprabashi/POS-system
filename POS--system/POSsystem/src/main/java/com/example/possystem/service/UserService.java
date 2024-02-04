package com.example.possystem.service;

import com.example.possystem.model.UserData;
import com.example.possystem.repository.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    @Transactional
    public UserData insertUserData(UserData userData) {
        // Use the save method from the repository to insert user data
        return userRepo.save(userData);
    }

    @Transactional
    public List<UserData> getAllUserData() {
        // Use the findAll method from the repository to retrieve all user data
        return userRepo.findAll();
    }

    @Transactional
    public void deleteUserData(String nic) {
        // Use the deleteById method from the repository to delete user data by ID
        userRepo.deleteUserByNic(nic);
    }

    @Transactional
    public UserData findByNic(String nic) {
        // Use the findByNic method from the repository to retrieve a single user data by NIC
        List<UserData> userDataList = userRepo.findByNic(nic);
        return userDataList.isEmpty() ? null : userDataList.get(0);
    }

    @Transactional
    public UserData updateUserData(String nic, UserData userData) {
        // Use the updateUserData method from the repository to update user data
        UserData existingUserData = (UserData) userRepo.findByNic(nic);
        if (existingUserData != null) {
            // Update the properties of the existing user data
            existingUserData.setUsername(userData.getUsername());
            existingUserData.setPassword(userData.getPassword());
            existingUserData.setNic(userData.getNic());
            existingUserData.setName(userData.getName());
            existingUserData.setAddress(userData.getAddress());
            existingUserData.setDob(userData.getDob());
            existingUserData.setUserCategory(userData.getUserCategory());

            // Save the updated user data
            return userRepo.save(existingUserData);
        }
        return null; // Return null if the user data with the given NIC doesn't exist
    }
}
