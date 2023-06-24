package com.example.GreenStitch_Backend_Assignment.Services;

import com.example.GreenStitch_Backend_Assignment.DTO.JWTRequestDTO;
import com.example.GreenStitch_Backend_Assignment.DTO.JWTResponseDTO;
import com.example.GreenStitch_Backend_Assignment.DTO.UserRequestDTO;
import com.example.GreenStitch_Backend_Assignment.Model.UserData;

public interface UserService {
    public JWTResponseDTO registerUser(UserRequestDTO userRequest);
    public JWTResponseDTO getLoggedInToken(JWTRequestDTO authenticationRequest) throws Exception;
}
