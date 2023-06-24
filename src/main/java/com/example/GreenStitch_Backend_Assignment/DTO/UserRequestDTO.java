package com.example.GreenStitch_Backend_Assignment.DTO;

import com.example.GreenStitch_Backend_Assignment.Enum.Role;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequestDTO {
    String name;
    String email;
    String password;
    Role role;
}
