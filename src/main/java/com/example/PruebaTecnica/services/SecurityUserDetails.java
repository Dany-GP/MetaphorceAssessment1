package com.example.PruebaTecnica.services;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.PruebaTecnica.Models.entities.User;
import com.example.PruebaTecnica.repositories.UserRepository;
import com.example.PruebaTecnica.security.SecurityUser;

@Service
public class SecurityUserDetails implements UserDetailsService{
    private final UserRepository userRepository;

    public SecurityUserDetails(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<User> optUser = userRepository.findUserByName(name);
        if(optUser.isPresent()){
            return new SecurityUser(optUser.get());
        }

        throw new UsernameNotFoundException("User not found: " + name);
    }
}
