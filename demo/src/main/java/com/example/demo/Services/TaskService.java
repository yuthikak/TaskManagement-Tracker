package com.example.demo.Services;

import com.example.demo.Entity.TaskEntity;
import com.example.demo.Entity.UserEntity;
import com.example.demo.Repository.TaskRepo;
import com.example.demo.Repository.UserRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepo taskRepo;

    @Autowired
    private UserRepo userRepository;

    public TaskEntity saveTaskForUser(TaskEntity taskEntity, String username) {

        UserEntity user = userRepository.findByUsername(username);
        if (user == null)
        {
            throw new RuntimeException("User not found");
        }
        taskEntity.setUserId(user.getObjectId());
        taskEntity.setCreatedAt(LocalDateTime.now());
        return taskRepo.save(taskEntity);
    }

    public List<TaskEntity> getMeTask(String username) {

        UserEntity user = userRepository.findByUsername(username);

        List<TaskEntity> allTasks = taskRepo.findByUserId(user.getObjectId());

        return allTasks;
    }


    public void deletetaskById(ObjectId id, String username) {
        UserEntity user = userRepository.findByUsername(username);
        if (user == null) {
            throw new RuntimeException("User not found");
        }

        TaskEntity task = taskRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        if (!task.getUserId().equals(user.getObjectId())) {
            throw new RuntimeException("Forbidden: Task does not belong to user");
        }

        taskRepo.delete(task);
    }

    public TaskEntity updateTask(ObjectId id, TaskEntity newTask, String username) {

        UserEntity user = userRepository.findByUsername(username);

        if (user == null) {
            throw new RuntimeException("User not found");
        }

        TaskEntity oldTask = taskRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        
        if (!oldTask.getUserId().equals(user.getObjectId())) {
            throw new RuntimeException("Unauthorized");
        }

        oldTask.setTitle(newTask.getTitle());
        oldTask.setDescription(newTask.getDescription());

        return taskRepo.save(oldTask);
    }
}

