package com.example.GreenStitch_Backend_Assignment.Services;

import com.example.GreenStitch_Backend_Assignment.Exceptions.NotAvailabilityException;
import com.example.GreenStitch_Backend_Assignment.Model.UserData;
import com.example.GreenStitch_Backend_Assignment.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
public class MyUserDetailsServices implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws NotAvailabilityException {
        Optional<UserData> optionalUser = userRepository.findByEmail(username);
        if(optionalUser.isEmpty()) throw new NotAvailabilityException("User not found with given username");
        UserData user = optionalUser.get();

        if(user.getEmail().equals(username)){
            return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),new ArrayList<>());
        }
        return null;
    }
}
