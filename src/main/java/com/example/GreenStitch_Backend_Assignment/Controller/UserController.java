package com.example.GreenStitch_Backend_Assignment.Controller;

import com.example.GreenStitch_Backend_Assignment.DTO.JWTRequestDTO;
import com.example.GreenStitch_Backend_Assignment.DTO.JWTResponseDTO;
import com.example.GreenStitch_Backend_Assignment.DTO.UserRequestDTO;
import com.example.GreenStitch_Backend_Assignment.Exceptions.AvailabilityException;
import com.example.GreenStitch_Backend_Assignment.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity registerUser(@RequestBody UserRequestDTO userRequestDTO) throws AvailabilityException {
        try{
            JWTResponseDTO registerUser = userService.registerUser(userRequestDTO);
            return new ResponseEntity(registerUser, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/login")
    public ResponseEntity getLoggedInToken(@RequestBody JWTRequestDTO authentication) throws Exception {
        try{
            JWTResponseDTO loginUser = userService.getLoggedInToken(authentication);
            return ResponseEntity.ok(loginUser);
        }catch(Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
