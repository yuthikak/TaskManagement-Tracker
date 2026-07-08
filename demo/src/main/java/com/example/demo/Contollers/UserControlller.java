package com.example.demo.Contollers;

import com.example.demo.Entity.UserEntity;
import com.example.demo.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserControlller {

    @Autowired
    private UserServices userServices;

    @GetMapping
    public ResponseEntity<UserEntity> getUser() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();

        UserEntity user = userServices.getByUsername(username);

        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<UserEntity> createuser(@RequestBody UserEntity userEntity) {
        if (userServices.findByUsername(userEntity.getUsername())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        UserEntity saveuser = userServices.create(userEntity);
        return new ResponseEntity<>(saveuser, HttpStatus.CREATED);

    }
}


