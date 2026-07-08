package com.example.demo.Contollers;

import com.example.demo.Entity.TaskEntity;
import com.example.demo.Services.TaskService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    //    @PostMapping
//    public ResponseEntity<TaskEntity> createtask(@RequestBody TaskEntity taskEntity) {
//        if(taskEntity.getTitle()!=null && taskEntity.getCreatedAt()!=null){
//            TaskEntity saved=taskService.save(taskEntity);
//            return new ResponseEntity<>(saved, HttpStatus.CREATED);
//        }
//        else{
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//
//    }
    @PostMapping
    public ResponseEntity<TaskEntity> createTask(@RequestBody TaskEntity taskEntity) {
        if (taskEntity.getTitle() == null || taskEntity.getTitle().isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();


        TaskEntity savedTask = taskService.saveTaskForUser(taskEntity, username);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedTask);
    }

    @GetMapping
    public ResponseEntity<List<TaskEntity>> getTask() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        List<TaskEntity> tasks = taskService.getMeTask(username);

        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @DeleteMapping("/{userid}")
    public ResponseEntity<?> deleteTask(@PathVariable ObjectId userid) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        taskService.deletetaskById(userid, username);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{userId}")
    public ResponseEntity<?> updateTask(@PathVariable ObjectId userId,
                                        @RequestBody TaskEntity taskEntity) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        TaskEntity updatedTask = taskService.updateTask(userId, taskEntity, username);

        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }
}


