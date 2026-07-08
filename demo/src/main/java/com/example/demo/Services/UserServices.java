package com.example.demo.Services;

import com.example.demo.Entity.UserEntity;
import com.example.demo.Repository.UserRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserEntity create(UserEntity userEntity) {

        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));

        return userRepo.save(userEntity);
    }




public UserEntity getByUsername(String username) {
    return userRepo.findByUsername(username);
}
    public boolean findByUsername(String username) {
        return userRepo.findByUsername(username) != null;
    }

    public void createAdmin(UserEntity userEntity) {
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userEntity.setRoles(Arrays.asList("USER","ADMIN"));
        userRepo.save(userEntity);
    }
    public List<UserEntity> getAll()
    {
        return userRepo.findAll();
    }
}
