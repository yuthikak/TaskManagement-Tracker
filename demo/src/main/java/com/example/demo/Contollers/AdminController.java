package com.example.demo.Contollers;

import com.example.demo.Entity.UserEntity;
import com.example.demo.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserServices userServices;

    @PostMapping
    public void createad(@RequestBody UserEntity userEntity)
    {
        userServices.createAdmin(userEntity);
    }
    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        List<UserEntity> all = userServices.getAll();
        if (all != null && !all.isEmpty()) {
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }



}
