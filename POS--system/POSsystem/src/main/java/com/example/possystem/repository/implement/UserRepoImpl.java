//package com.example.possystem.repository.implement;
//
//import com.example.possystem.model.UserData;
//import com.example.possystem.repository.UserRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import java.util.Optional;
//
//@Repository
//public class UserRepoImpl implements UserRepo {
//
//
//    @Autowired
//    JdbcTemplate jdbcTemplate;
//
//    @Override
//    public UserData findByUsernameAndPasswordAndUserCategory(String username, String password, String userCategory) {
//        String sql = "SELECT * FROM UserData WHERE username = ? AND password = ? AND user_category = ?";
//
//        // Perform the query and map the result to UserData entity
//        return jdbcTemplate.queryForObject(
//                sql,
//                new Object[]{username, password, userCategory},
//                (resultSet, rowNum) -> {
//                    UserData user = new UserData();
//                    user.setIdUser(resultSet.getInt("idUser"));
//                    user.setUsername(resultSet.getString("username"));
//                    user.setPassword(resultSet.getString("password"));
//                    user.setNic(resultSet.getString("nic"));
//                    user.setName(resultSet.getString("name"));
//                    user.setAddress(resultSet.getString("address"));
//                    user.setDob(resultSet.getDate("dob"));
//                    user.setUserCategory(resultSet.getString("user_category"));
//                    return user;
//                }
//        );
//    }
//}
