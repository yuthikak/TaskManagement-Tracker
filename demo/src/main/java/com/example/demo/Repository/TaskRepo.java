package com.example.demo.Repository;

import com.example.demo.Entity.TaskEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TaskRepo extends MongoRepository<TaskEntity, ObjectId> {
    List<TaskEntity> findByUserId(ObjectId objectId);
}
