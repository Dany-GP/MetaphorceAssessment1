package com.example.PruebaTecnica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.PruebaTecnica.Models.entities.Task;

public interface TaskOperationRepository extends JpaRepository<Task, Long>{
    
}
