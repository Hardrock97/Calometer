package com.example.calometer.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Integer id;
    /*@NotBlank(message = "Name field cannot be Blank!")
    @Size(min=3,max=12,message="Name must be 3-12 characters")*/
    private String name;
    private String email;
    private String password;
    private Integer tc;
    private String role;

}
