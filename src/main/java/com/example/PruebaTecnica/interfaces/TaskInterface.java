package com.example.PruebaTecnica.interfaces;

import java.util.List;

import com.example.PruebaTecnica.Models.entities.Task;

public interface TaskInterface {
    List<Task> getAll(); 
    Task getTask(int id);  
}
