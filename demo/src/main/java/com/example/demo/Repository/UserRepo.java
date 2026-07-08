package com.example.demo.Repository;

import com.example.demo.Entity.UserEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<UserEntity , ObjectId> {
    UserEntity findByUsername(String username);
}
