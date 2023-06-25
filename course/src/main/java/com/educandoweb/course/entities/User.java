package com.educandoweb.course.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Serializable permite que o objeto seja transformado para cadeia de bytes -> passar de arquivos para outros
// Mapeando a entidade. @Entity para informar que é uma Entity e o nome da table @Table, pois User é uma palavra reservada
@Entity
@Table(name = "tb_user")
public class User implements Serializable {
    public static final long serialVersionUID = 1L;

    // Informando qual é a chave primária e formando como se faz a geração do valor
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;

    // Um usuário pode ter vários pedidos. Mapeamento, então, um para muitos em que, do outro lado, é representado por client
    // Isso relaciona cada ordem com o idClient
    @OneToMany(mappedBy = "client")
    private List<Order> orders = new ArrayList<>();

    // Framework obriga a ter um construtor vazio
    public User() {};

    public User(Long id, String name, String email, String phone, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Só ID por enquanto
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
