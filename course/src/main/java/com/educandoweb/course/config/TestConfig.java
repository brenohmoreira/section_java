package com.educandoweb.course.config;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

/*
 * Inicia programa: perfil teste é iniciado, classe TestConfig é iniciada e o método run é chamado, povoando o banco
 * para o teste
 */

// Configuração para o perfil test (Se estiver no perfil de test, ele irá rodar essa configuração)
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    /*
     * Vamos usar isso para povoar o banco de dados de teste. Injeção de dependência
     */

    // Para ele injetar a dependência e instanciar UserRepository
    private final UserRepository userRepository;

    @Autowired
    public TestConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        // Salvando os usuários no banco de dados
        userRepository.saveAll(Arrays.asList(u1, u2));
    }
}
