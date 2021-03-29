package com.backend.vote.user;


import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService{

    @Autowired
    private UserRepository repository;

    public User findById(Long id){
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(String.valueOf(id)));
    }

    public User findByDocument(String document) {
        Optional<User> obj = repository.findByDocument(document);
        return obj.orElseThrow(() -> new ResourceNotFoundException(document));
    }

    public User insert(User obj) {
        return repository.save(obj);
    }

    public List<User> findAll() { return repository.findAll(); }
}
