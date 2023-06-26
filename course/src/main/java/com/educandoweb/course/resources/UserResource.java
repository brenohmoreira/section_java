package com.educandoweb.course.resources;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Controladores REST

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    // Autowired tira a necessidade de um new ..., porém só podemos utilizar para componentes do Spring
    private final UserService service;

    public UserResource(UserService service) {
        this.service = service;
    }

    // ResponseEntity é o tipo referência para respostas para requisições
    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> users_list = service.findAll();

        // Retorna status HTTP OK, escrevendo no body o objeto U
        return ResponseEntity.ok().body(users_list);
    }

    // A rota será o RequestMapping + GetMapping -> /users/{id}
    // @PathVariable faz pegar o valor da URL marcado pelo GetMapping
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User obj = service.findById(id);

        return ResponseEntity.ok().body(obj);
    }
}
