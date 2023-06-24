package com.example.GreenStitch_Backend_Assignment.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JWTRequestDTO implements Serializable {
    private static final long serialVersionUID = 5926468583005150707L;
    private String email;
    private String password;
}
