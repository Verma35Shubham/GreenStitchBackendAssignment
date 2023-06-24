package com.example.GreenStitch_Backend_Assignment.DTO;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JWTResponseDTO {
    private static final long serialVersionUID = -8091879091924046844L;

    private String jwtToken;
    public JWTResponseDTO(String jwt) {
        this.jwtToken=jwt;
    }
    public String getToken() {
        return this.jwtToken;
    }
}
