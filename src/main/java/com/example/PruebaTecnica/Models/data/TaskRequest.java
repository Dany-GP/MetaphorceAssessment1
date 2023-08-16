package com.example.PruebaTecnica.Models.data;

public class TaskRequest {

    private String description;
    private String state;

    public TaskRequest(String descripcion, String state){
        this.description = descripcion;
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
