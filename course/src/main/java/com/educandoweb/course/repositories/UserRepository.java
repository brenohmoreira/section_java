package com.educandoweb.course.repositories;

import com.educandoweb.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * É aqui que serão feitas as operações com a User. Utilizando como exemplo, seria tipo o Model do PHP
 *
 * Não é necessário fazer implementações para essas interfaces, pois o JPA possui uma implementação padrão
 *
 * extends JpaRepository<Para quem, tipo id>
 */

// @Repository não é necessário aqui pois JpaRepository já herda @Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
