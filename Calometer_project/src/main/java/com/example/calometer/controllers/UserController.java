package com.example.calometer.controllers;

import com.example.calometer.model.User;
import com.example.calometer.payload.UserDto;
import com.example.calometer.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
//@RequestMapping()
public class UserController {

    @Autowired
    UserService userService;

    /*@ModelAttribute("userDto")
    public UserDto userDto() {
        return new UserDto();
    }*/

    //Req to send the registration form (view)
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("userDto",new UserDto());
        return "register";
    }
//@Valid  @ModelAttribute("userDto") , BindingResult result
    @PostMapping("/doRegister")
    public String registerUser(@ModelAttribute("userDto") UserDto userDto) {
        this.userService.registerUser(userDto);
        /*if(result.hasErrors()) {
            System.out.println(result);
        }*/
        return "redirect:/register?success";
    }
    @GetMapping("/Login")
    public String showLoginForm() {

        return "Login";
    }

}
