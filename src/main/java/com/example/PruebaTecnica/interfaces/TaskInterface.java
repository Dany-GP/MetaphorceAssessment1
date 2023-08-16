package com.example.PruebaTecnica.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.PruebaTecnica.Models.Task;

public interface TaskInterface {
    List<Task> getAll(); 
    Task getTask(int id);  
}
