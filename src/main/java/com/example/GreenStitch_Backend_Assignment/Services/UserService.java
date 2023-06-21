package com.example.GreenStitch_Backend_Assignment.Services;

import com.example.GreenStitch_Backend_Assignment.Exceptions.UserException;
import com.example.GreenStitch_Backend_Assignment.Model.UserData;

public interface UserService {
    public UserData registerUser(UserData user)throws UserException;
    public UserData loginUser() throws UserException;
}
