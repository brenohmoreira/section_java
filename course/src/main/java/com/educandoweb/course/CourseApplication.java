package com.educandoweb.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourseApplication {

    public static void main(String[] args) {
        /*
         * A grosso modo, falando da arquitetura:
         * - TestConfig povoa o banco de dados de teste
         * - User é a entidade que vamos mapear. O banco é criado a partir dele
         * - Os recursos é onde fazemos o mapeamento de rotas, conversa diretamente e exclusivamente com os serviços (Services)
         * - Services utiliza os repositórios para fazer as operações
         */
        SpringApplication.run(CourseApplication.class, args);
    }

}
