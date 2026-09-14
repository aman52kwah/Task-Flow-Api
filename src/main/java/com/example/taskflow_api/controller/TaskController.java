package com.example.taskflow_api.controller;

import com.example.taskflow_api.model.Task;
import com.example.taskflow_api.model.TaskStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// this tells springboot that this class handles  request and
// automatically converts returned Java objects into JSON
@RestController
// this sets the base URL path for all endpoints inside this class
@RequestMapping("/api/tasks")

public class TaskController {

    private final List<Task> tasks = new ArrayList<>();

    public TaskController(){
        // sample data for testing
        tasks.add(new Task(101,"Learn Spring and Spring Framework","understand Controllers and Rest API", TaskStatus.IN_PROGRESS));
        tasks.add(new Task(102,"Build TaskFlow API","Implement endpoints for managing task", TaskStatus.TODO));
    }
    @GetMapping
    public List<Task> getAllTask(){
        return tasks;
    }
}
