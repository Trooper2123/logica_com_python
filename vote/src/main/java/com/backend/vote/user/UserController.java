package com.backend.vote.user;

import com.backend.vote.validaition.CpfValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Slf4j
@RestController
@RequestMapping(value = "/user")
public class UserController {


    private final UserService service;
    private final CpfValidation cpfValidation;

    @Autowired
    public UserController(UserService service, CpfValidation cpfValidation) {
        this.service = service;
        this.cpfValidation = cpfValidation;
    }


    @GetMapping(value = "/id={id}")
    public ResponseEntity<User> findById(@PathVariable("id") Long id) {
        if (id != null) {
            User obj = service.findById(id);
            return ResponseEntity.ok().body(obj);
        } else {
            log.info("Id não identificado");
            return null;
        }
    }


    @GetMapping(value = "/document={document}")
    public ResponseEntity<User> findByDocument(@PathVariable("document") String document) {
        if (document != null) {
            User obj = service.findByDocument(document);
            return ResponseEntity.ok().body(obj);
        } else {
            log.info("Documento não identificado");
            return null;
        }
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User obj) {
        if (cpfValidation.iscpf(obj.getDocument())) {
            obj = service.insert(obj);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(obj.getId()).toUri();
            return ResponseEntity.created(uri).body(obj);
        } else {
            log.info("Invalid document");
            return ResponseEntity.status(406).build();
        }
    }
}