package com.example.todo_list_app_android;

public class Task {

    private String name;

    public Task(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
}
