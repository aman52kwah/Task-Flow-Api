package com.example.taskflow_api.model;

public class Task {
    private  int id;
    private String title;
    private String description;
    private  boolean status;  // Values: "TODO", "IN_PROGRESS", "COMPLETED"

    public Task(){};

    public Task(int id, String title, String description, boolean status){
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    // getters and setters for task fields
    public int getId(){
        return id;
}

    public String getTitle(){
    return title;
    }

    public String getDescription(){
        return  description;
    }

    public boolean getStatus(){
        return status;
    }

    //setters
    public int setId(int id){
        return this.id = id;
    }

    public String setTitle(String title){
        return this.title = title;
    }

    public String setDescription(String description){
        return  this.description = description;
    }

    public boolean isStatus(boolean status){
      return   this.status = status;
    }
}
