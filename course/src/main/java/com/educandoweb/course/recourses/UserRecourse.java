package com.educandoweb.course.recourses;

import com.educandoweb.course.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Controladores REST

@RestController
@RequestMapping(value = "/users")
public class UserRecourse {

    // ResponseEntity é o tipo referência para respostas para requisições
    @GetMapping
    public ResponseEntity<User> findAll() {
        User u = new User(1L, "Maria", "maria@gmail.com", "(19) 99166-3343", "12345");

        // Retorna status HTTP OK, escrevendo no body o objeto U
        return ResponseEntity.ok().body(u);
    }
}
