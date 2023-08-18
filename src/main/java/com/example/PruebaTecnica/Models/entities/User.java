package com.example.PruebaTecnica.Models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "Password")
    private String Password;

    // Constructores, getters y setters

    // Constructor sin argumentos (requerido por JPA)
    public User() {
    }

    // Constructor con argumentos para crear una tarea
    public User(String name, String Password) {
        this.name = name;
        this.Password = Password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String description) {
        this.name = description;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String state) {
        this.Password = state;
    }
}
