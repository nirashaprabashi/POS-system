package com.example.possystem.repository;

import com.example.possystem.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


//public interface UserRepo extends JpaRepository<UserData, Integer>{
//    UserData findByUsernameAndPasswordAndUserCategory(String username, String password, String userCategory);
//}

@Repository
public interface UserRepo extends JpaRepository<UserData, Integer> {
    Optional<UserData> findByUsernameAndUserCategory(@Param("username") String username, @Param("userCategory") String userCategory);


    @Modifying
    @Query(value = "INSERT INTO user_data (username, password, nic, name, address, dob, user_category) " +
            "VALUES (:username, :password, :nic, :name, :address, :dob, :userCategory)", nativeQuery = true)
    void insertUserData(@Param("username") String username, @Param("password") String password,
                        @Param("nic") String nic, @Param("name") String name,
                        @Param("address") String address, @Param("dob") LocalDate dob,
                        @Param("userCategory") String userCategory);

    @Modifying
    @Query(value = "DELETE FROM user_data WHERE nic = :nic",nativeQuery = true)
    void deleteUserByNic(@Param("nic") String nic);

    @Modifying
    @Query(value = "SELECT * from user_data where nic= :nic",nativeQuery = true)
    List<UserData> findByNic(@Param("nic") String nic);

    @Modifying
    @Query(value = "UPDATE user_data SET username = :username, password = :password, " +
            "name = :name, address = :address, dob = :dob, user_category = :userCategory " +
            "WHERE nic = :nic", nativeQuery = true)
    void updateUserData(@Param("username") String username, @Param("password") String password,
                        @Param("name") String name, @Param("address") String address,
                        @Param("dob") LocalDate dob, @Param("userCategory") String userCategory,
                        @Param("nic") String nic);
}
