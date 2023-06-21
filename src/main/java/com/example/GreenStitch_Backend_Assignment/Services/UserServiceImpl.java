package com.example.GreenStitch_Backend_Assignment.Services;

import com.example.GreenStitch_Backend_Assignment.Model.UserData;
import com.example.GreenStitch_Backend_Assignment.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    @Override
    public UserData registerUser(UserData user) {
        return userRepository.save(user);
    }

    @Override
    public UserData loginUser() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        String userName = authentication.getName();
        UserData userData= userRepository.findByEmail(userName);
        return userData;
    }
}
