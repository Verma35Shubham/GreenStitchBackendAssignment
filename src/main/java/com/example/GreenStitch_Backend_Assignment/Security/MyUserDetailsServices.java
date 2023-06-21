package com.example.GreenStitch_Backend_Assignment.Security;

import com.example.GreenStitch_Backend_Assignment.Model.UserData;
import com.example.GreenStitch_Backend_Assignment.Repository.UserRepository;
import com.example.GreenStitch_Backend_Assignment.Security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsServices implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserData userData = userRepository.findByEmail(username);
        if(userData != null){
            return new MyUserDetails(userData);
        }
        throw new UsernameNotFoundException("user not found with this username : "+username);
    }
}
