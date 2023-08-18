package com.example.PruebaTecnica.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Repository;

import com.example.PruebaTecnica.Models.entities.Task;
import com.example.PruebaTecnica.interfaces.TaskInterface;

@Repository
@Transactional
public class TaskRepository implements TaskInterface {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Task> getAll() {
        String query = "FROM Task";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Task getTask(int id) {
        System.out.println(id);
        String query = "FROM Task WHERE id="+id;
        Task result = (Task) entityManager.createQuery(query).getResultList().get(0);
        return result;
       
        //return (Task) entityManager.createQuery(query).getResultList().get(0);
    }
    
}
