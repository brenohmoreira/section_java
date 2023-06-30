package com.educandoweb.course.services;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Component torna UserService um componente do Spring e permite que escrevamos @Autowired para injeta-lo, Service e Repository faz o mesmo
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        // findById retorna um Optional<User>
        Optional<User> obj = userRepository.findById(id);

        // Pega, no Optional, o objeto do tipo especificado
        return obj.get();
    }

    public User insert(User user) {
        return userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
