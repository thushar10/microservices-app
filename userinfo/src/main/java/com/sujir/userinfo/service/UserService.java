package com.sujir.userinfo.service;

import com.sujir.userinfo.dto.UserDto;
import com.sujir.userinfo.entity.User;
import com.sujir.userinfo.mapper.UserMapper;
import com.sujir.userinfo.repository.UserRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepo userRepo;
    private final UserMapper userMapper;


    public UserService(UserRepo userRepo, UserMapper userMapper) {
        this.userRepo = userRepo;
        this.userMapper = userMapper;
    }

    public UserDto addUser(UserDto userDto) {
        User user = userRepo.save(userMapper.mapUserDTOToUser(userDto));
        return userMapper.mapUserToUserDto(user);
    }

    public ResponseEntity<UserDto>  fetchUserById(Integer id) {
        Optional<User> byId = userRepo.findById(id);

        return byId.map(user -> new ResponseEntity<>(userMapper.mapUserToUserDto(user), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));


    }

}
