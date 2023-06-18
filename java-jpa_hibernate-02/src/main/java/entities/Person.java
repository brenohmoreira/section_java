package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/*
 * É o próprio JPA que cria as tabelas do banco, assim sendo, os atributos compreendem os nomes das colunas. Podemos
 * mudar para @Column(atributo = [nome])
 */

// Indica que Person é uma entidade do banco
@Entity
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    // Indica que o id é a chave primária e a estratégia de geração desse valor é da identidade (++)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String email;

    public Person() {}

    public Person(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
