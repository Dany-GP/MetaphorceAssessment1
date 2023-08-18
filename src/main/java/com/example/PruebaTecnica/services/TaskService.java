package com.example.PruebaTecnica.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PruebaTecnica.Exceptions.NotFoundException;
import com.example.PruebaTecnica.Models.entities.Task;
import com.example.PruebaTecnica.repositories.TaskOperationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskOperationRepository taskRepository;

    @Autowired
    public TaskService(TaskOperationRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    public List<Task> getAll(){
        return taskRepository.findAll();
    }

    public Task getById(Long id){
        Optional<Task> optionalTask = taskRepository.findById(id);
        if(optionalTask.isPresent()){
            return optionalTask.get();
        }else{
            throw new NotFoundException("No se encontró la tarea con ID: " + id);
        }
    }

    // Método para insertar una nueva tarea en la base de datos
    public Task addTask(String description, String state) {
        Task task = new Task(description, state);
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, String nuevaDescription, String nuevoState) {
        Optional<Task> optionalTask = taskRepository.findById(id);

        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setDescription(nuevaDescription);
            task.setState(nuevoState);
            return taskRepository.save(task);
        } else {
            throw new NotFoundException("No se encontró la tarea con ID: " + id);
        }
    }

    public void deleteTaskById(Long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);

        if (optionalTask.isPresent()) {
            taskRepository.delete(optionalTask.get());
        } else {
            throw new NotFoundException("No se encontró la tarea con ID: " + id);
        }
    }
}
