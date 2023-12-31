package com.example.PruebaTecnica.Controllers;
import com.example.PruebaTecnica.Models.data.TaskRequest;
import com.example.PruebaTecnica.Models.entities.Task;
import com.example.PruebaTecnica.repositories.TaskRepository;
import com.example.PruebaTecnica.services.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    // @Autowired
    // private TaskRepository taskDao;

    private final TaskService taskService;

    @Autowired
    public Controller(TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping(value = "/tasks")
    public List<Task> getTasks(){
        return taskService.getAll();
    }

    @RequestMapping(value = "/task/{id}")
    public Task getTask(@PathVariable Long id){
        return taskService.getById(id);
    }

    @PostMapping(path  = "/add-task", consumes = "application/json")
    public ResponseEntity<Task> addTask(@RequestBody TaskRequest request) {
        Task nuevaTask = taskService.addTask(request.getDescription(), request.getState());
        return ResponseEntity.ok(nuevaTask);
    }

    @PutMapping("/edit-task/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody TaskRequest taskRequest) {
        Task updatedTask = taskService.updateTask(id, taskRequest.getDescription(), taskRequest.getState());
        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/delete-task/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTaskById(id);
        return ResponseEntity.noContent().build();
    }

}
