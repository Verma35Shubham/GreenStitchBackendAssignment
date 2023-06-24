package com.example.GreenStitch_Backend_Assignment.Services;


import com.example.GreenStitch_Backend_Assignment.Convertor.UserConvertor;
import com.example.GreenStitch_Backend_Assignment.DTO.JWTRequestDTO;
import com.example.GreenStitch_Backend_Assignment.DTO.JWTResponseDTO;
import com.example.GreenStitch_Backend_Assignment.DTO.UserRequestDTO;
import com.example.GreenStitch_Backend_Assignment.Exceptions.AvailabilityException;
import com.example.GreenStitch_Backend_Assignment.JWT.JwtValidationFilter;
import com.example.GreenStitch_Backend_Assignment.Model.UserData;
import com.example.GreenStitch_Backend_Assignment.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtValidationFilter jwtValidationFilter;

    @Autowired
    private MyUserDetailsServices myUserDetailsServices;


    @Override
    public JWTResponseDTO registerUser(UserRequestDTO userRequest) throws AvailabilityException {
        Optional<UserData> optionalUser = userRepository.findByEmail(userRequest.getEmail());

        if(optionalUser.isPresent()) {
            throw new AvailabilityException("User available here try another one");
        }

        String encodedPassword = passwordEncoder.encode(userRequest.getPassword());
        userRequest.setPassword(encodedPassword);

        UserData responseUser = userRepository.save(UserConvertor.userRequestDtoToUser(userRequest));

        final UserDetails userDetails = myUserDetailsServices.loadUserByUsername(userRequest.getEmail());

        //generating the token
        final String token = jwtValidationFilter.generateToken(userDetails);

        return new JWTResponseDTO(token);

    }


    @Override
    public JWTResponseDTO getLoggedInToken(JWTRequestDTO authenticationRequest) throws Exception{
        try{
            authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());

            final UserDetails userDetails = myUserDetailsServices.loadUserByUsername(authenticationRequest.getEmail());
            final String token = jwtValidationFilter.generateToken(userDetails);
            final JWTResponseDTO response= new JWTResponseDTO(token);

            return response;
        } catch(Exception e){
            throw new Exception(e);
        }
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}