package com.scaler.usermanagementservice.services;

import com.scaler.usermanagementservice.models.User;
import com.scaler.usermanagementservice.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        // testing with dummy data
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "user1", "pass1", "userEmail1@xyz.com") );
        users.add(new User(2L, "user2", "pass2", "userEmail2@xyz.com") );
        users.add(new User(3L, "user3", "pass3", "userEmail3@xyz.com") );
        return users;
//        return null;
    }

    @Override
    public User getUserById(Long userId) {
        // testing with dummy data
        User user = new User(2L, "user2", "pass2", "userEmail2@xyz.com");
        return user;
        //        return null;
    }

    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public User updateUser(Long userId, User user) {
        return null;
    }

    @Override
    public boolean deleteUser(Long userId) {
        return false;
    }
}
