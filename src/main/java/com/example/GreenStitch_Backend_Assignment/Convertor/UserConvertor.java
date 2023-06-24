package com.example.GreenStitch_Backend_Assignment.Convertor;

import com.example.GreenStitch_Backend_Assignment.DTO.UserRequestDTO;
import com.example.GreenStitch_Backend_Assignment.DTO.UserResponseDTO;
import com.example.GreenStitch_Backend_Assignment.Model.UserData;

public class UserConvertor {
    public static UserData userRequestDtoToUser(UserRequestDTO userRequestDTO){
        return UserData.builder()
                .name(userRequestDTO.getName())
                .email(userRequestDTO.getEmail())
                .password(userRequestDTO.getPassword())
                .role(userRequestDTO.getRole())
                .build();
    }
}
