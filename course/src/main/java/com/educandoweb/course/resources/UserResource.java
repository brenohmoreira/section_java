package com.educandoweb.course.resources;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    /*
     * Padrão REST para requisições de inserção é POST
     * Padrão REST para requisições de busca é GET
     * Padrão REST para requisições de deleção é DELETE
     *
     * 200 -> ok
     * 201 -> created
     * 204 -> no content
     * ...
     * 401 -> not found
     */
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

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User user) {
        user = service.insert(user);
        // Para criar um 201, montar da seguinte forma: O path vai vir o GetMapping + o que você digitar. Insira o caminho para acessar o user criado
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(user.getId()).toUri();

        // Retornar um 201 (Criado)
        return ResponseEntity.created(uri).body(user);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);

        // Código 204 -> sem conteúdo
        return ResponseEntity.noContent().build();
    }
}
