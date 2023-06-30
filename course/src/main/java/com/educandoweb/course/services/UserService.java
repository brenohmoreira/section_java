package com.educandoweb.course.services;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.exceptions.DatabaseException;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        // return obj.get(); -> obj.get() pode dar problema se dentro de Optional não tiver nenhum User, por isso:
        // orElseThrow tenta dar o get(), se não tiver, retorna a exceção:
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user) {
        return userRepository.save(user);
    }

    public void delete(Long id) {
        // Você pode capturar no catch primeiro o RuntimeException e ver qual exceção está vindo com error.printStackTrace();
        try {
            if (userRepository.existsById(id)) {
                userRepository.deleteById(id);
            } else {
                throw new ResourceNotFoundException(id);
            }
        } catch (EmptyResultDataAccessException error) {
            throw new ResourceNotFoundException(id);
        }
        catch (DataIntegrityViolationException error) {
            throw new DatabaseException(error.getMessage());
        }

    }

    public User update(Long id, User user) {
        // Faz algo parecido que o findById, mas ele não busca, apenas MONITORA e deixa preparado para uma operação
        try {
            User entity = userRepository.getReferenceById(id);
            updateData(entity, user);
            return userRepository.save(entity);
        } catch (EntityNotFoundException error) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User entity, User user) {
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
    }
}
