package com.example.taskflow_api.controller;

import com.example.taskflow_api.model.Task;
import com.example.taskflow_api.model.TaskStatus;
import com.example.taskflow_api.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// this tells springboot that this class handles  request and
// automatically converts returned Java objects into JSON
@RestController
// this sets the base URL path for all endpoints inside this class
@RequestMapping("/api/tasks")

public class TaskController {


    // declare private final dependency


   private final  TaskService taskService;


        // perform constructor injection
        public  TaskController(TaskService taskService){
            this.taskService = taskService;
        }



    @GetMapping
    public List<Task> getAllTask(){
        return taskService.getTasks();
    }

    //GET END POINT FOR SINGLE SEARCH
    // this binds the  variable {id}in the URL Path
      @GetMapping("/{id}")
   public Task getTaskById(@PathVariable int id){
            return taskService.getTaskById(id);
        }

    @PostMapping
    public Task createTask(@RequestBody Task task){
            return taskService.createTask(task);
    }

    // Patch task status by id
    @PatchMapping("/{id}/status")
    public  Task updateTaskStatus(@PathVariable int id, @RequestParam TaskStatus status){
            return taskService.updateTaskStatus(id,status);

    }

    // delete task by id
    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable int id){
            boolean deleted = taskService.deleteTask(id);
            if (deleted){
                return "Task with ID "+ id + " deleted sucessfully";
            }
            return "Task not found.";
    }




}







