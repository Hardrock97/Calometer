package com.example.calometer.services;

import com.example.calometer.exceptions.ResourceNotFoundException;
import com.example.calometer.model.Item;
import com.example.calometer.model.Role;
import com.example.calometer.model.User;
import com.example.calometer.payload.UserDto;
import com.example.calometer.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    /*@Override
    public User registerUser(UserDto userDto) {
       /* User user = dtoToUser(userDto);
        User registeredUser = this.userRepository.save(user);*/
        //Arrays.asList(new Role("ROLE_USER"))
        //,Arrays.asList(new Item())*/
        /*User user = new User(userDto.getId(), userDto.getName(),userDto.getEmail(),userDto.getPassword(), userDto.getTc(),Arrays.asList(new Role("ROLE_USER")),Arrays.asList(new Item()));
       // return registeredUser;
        return this.userRepository.save(user);
    }*/

    @Override
    public User registerUser(UserDto userDto) {
        //User user = new User(userDto.getId(), userDto.getName(),userDto.getEmail(),userDto.getPassword(), userDto.getTc(),Arrays.asList(new Role("ROLE_USER")),Arrays.asList(new Item()));
        User user = dtoToUser(userDto);
        User registeredUser = this.userRepository.save(user);
        return registeredUser;
    }

    @Override
    public UserDto getUserById(Integer id) {
        User user = this.userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User","id,",id));
        return userToDto(user);
    }

    @Override
    public Integer getRegisteredUserId(UserDto userDto) {
        User user = this.registerUser(userDto);
        return user.getId();
    }




    public User dtoToUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setRoles(Arrays.asList(new Role("ROLE_USER")));
        user.setItems(Arrays.asList(new Item()));
        return user;
    }
    public UserDto userToDto(User user) {
            UserDto userDto = new UserDto();
            userDto.setEmail(user.getEmail());
            userDto.setId(user.getId());
            userDto.setPassword(user.getPassword());
            userDto.setName(user.getName());
            userDto.setTc(user.getTarget_calories());
            return userDto;
    }
}
