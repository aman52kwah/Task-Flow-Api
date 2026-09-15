package com.example.taskflow_api.service;


import com.example.taskflow_api.model.Task;
import com.example.taskflow_api.model.TaskStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {


    private final List<Task> tasks = new ArrayList<>();

    public TaskService(){
        // sample data for testing
        tasks.add(new Task(101,"Learn Spring and Spring Framework","understand Controllers and Rest API", TaskStatus.IN_PROGRESS));
        tasks.add(new Task(102,"Build TaskFlow API","Implement endpoints for managing task", TaskStatus.TODO));
    }


    // get all Tasks

    public List<Task> getTasks() {
        return tasks;
    }

    //get task by id
    public Task getTaskById( int id){
        return tasks.stream()
                .filter(task -> task.getId() == id)
                .findFirst()
                .orElse(null);

    }

    // create tasks
    public  Task createTask(Task task){
        task.setId((int) (tasks.size() + 11));
        tasks.add(task);
        return task;
    }


    // update task
    public Task updateTaskStatus(int id ,TaskStatus status){
        Task task =getTaskById(id);
        if (task !=null){
            task.setStatus(status);

        }
        return task;
    }

    public boolean deleteTask(int id){
        Task task = getTaskById(id);
        if (task !=null){
            tasks.remove(task);
            return true;
        }
        return false;
    }


}
