package com.example.GreenStitch_Backend_Assignment.Controller;

import com.example.GreenStitch_Backend_Assignment.Exceptions.UserException;
import com.example.GreenStitch_Backend_Assignment.Model.UserData;
import com.example.GreenStitch_Backend_Assignment.Repository.UserRepository;
import com.example.GreenStitch_Backend_Assignment.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/app/signup")
    public ResponseEntity<UserData> registerUser(@Validated @RequestBody UserData userData) throws UserException {
        userData.setPassword(passwordEncoder.encode(userData.getPassword()));
        UserData user = userService.registerUser(userData);
        return  new ResponseEntity<UserData>(user, HttpStatus.CREATED);
    }
    @GetMapping("/signIn")
    public ResponseEntity<UserData> getLoggedInCustomerDetailsHandler(Authentication authentication) throws BadCredentialsException {
        UserData customer= userRepository.findByEmail(authentication.getName());

        if(customer!=null)
        {
            return new ResponseEntity<>(customer, HttpStatus.ACCEPTED);
        }

        throw new BadCredentialsException("Invalid Username or password");
    }
    @GetMapping("/logged-in/user")
    public ResponseEntity<String> LoginUser() throws UserException
    {
        UserData userData =  userService.loginUser();

        String message = "Welcome to Shubham's Website  : " + userData.getFullname();

        return new ResponseEntity<String>(message,HttpStatus.OK);
    }
}
