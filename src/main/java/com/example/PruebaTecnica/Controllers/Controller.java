package com.example.PruebaTecnica.Controllers;
import com.example.PruebaTecnica.PruebaTecnicaApplication;
import com.example.PruebaTecnica.Models.Task;
import com.example.PruebaTecnica.services.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
public class Controller {

    private static final Logger logger = LoggerFactory.getLogger(PruebaTecnicaApplication.class);

    @Autowired
    private TaskService taskDao;

    @RequestMapping(value = "/tasks")
    public List<Task> getTasks(){
        return taskDao.getAll();
    }

    @RequestMapping(value = "/task/{id}")
    public Task getTask(@PathVariable int id){
        //logger.info("La aplicación se ha iniciado correctamente.");
        return taskDao.getTask(id);
    }

}
