package com.example.calometer.services;

import com.example.calometer.model.User;
import com.example.calometer.payload.UserDto;
import org.springframework.beans.factory.annotation.Autowired;

public interface UserService {



    User registerUser(UserDto userDto);
    Integer getRegisteredUserId(UserDto userDto);
    UserDto getUserById(Integer id);
}
