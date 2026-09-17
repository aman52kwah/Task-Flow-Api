package com.example.taskflow_api.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateTaskRequest {
    @NotBlank(message = "Title is required and cannot be blank")
    private String title;

    @Size(max = 250, message = "Descriptio must not exceed 250 characters")
    private String description;

    // default constructor
    public CreateTaskRequest(){}

    public CreateTaskRequest(String title, String description){
        this.title = title;
        this.description = description;
    }

    // getters
    public String getTitle(){
        return title;
    }

    public String getDescription(){
        return description;
    }


    // setters
    public  void setTitle(String title){
        this.title= title;
    }

    public void  setDescription(String description){
        this.description =description;
    }

}
