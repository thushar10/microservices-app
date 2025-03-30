package com.sujir.userinfo.controller;

import com.sujir.userinfo.dto.UserDto;
import com.sujir.userinfo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/addUser")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto) {
        UserDto userDtoRes = userService.addUser(userDto);
        return new ResponseEntity<>(userDtoRes, HttpStatus.CREATED);
    }

    @GetMapping("/fetchUserById/{id}")
    public ResponseEntity<UserDto> fetchUserById(@PathVariable Integer id) {
        return userService.fetchUserById(id);
    }

}
