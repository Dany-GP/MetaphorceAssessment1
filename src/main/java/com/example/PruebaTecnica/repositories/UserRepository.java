package com.example.PruebaTecnica.repositories;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.PruebaTecnica.Models.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findUserByName(String name);
}
