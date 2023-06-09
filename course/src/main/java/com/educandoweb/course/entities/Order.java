package com.educandoweb.course.entities;

import com.educandoweb.course.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Na hora de salvar o instante, ele ignora o formato ISO e já coloca na data local. Para mudar isso:
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;

    // Normalmente seria OrderStatus, mas estamos relacionando o código. Isso é um tratamento APENAS dentro de Order
    private Integer orderStatus;

    // Um usuário pode ter muitos pedidos (muitos para um)
    @ManyToOne
    @JoinColumn(name = "clientId")
    private User client;

    // Está em OrderItem. Porém, o mapeamento acontece dentro do id de OrderItem no atributo Order, logo, id.order
    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> itens = new HashSet<>();


    // Um pedido tem um pagamento. A parte do cascade faz a coluna da foreign key do outro lado assuma o id dessa table
    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;

    public Order() { }

    public Order(Long id, Instant moment, OrderStatus orderStatus, User client) {
        this.id = id;
        this.moment = moment;
        this.client = client;
        setOrderStatus(orderStatus);
    }

    public Set<OrderItem> getItens() {
        return itens;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public OrderStatus getOrderStatus() {
        // Retorna o OrderStatus do código específicado
        return OrderStatus.valueOf(orderStatus);
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        if(orderStatus != null) {
            // Pega o código de orderStatus e salva no this.orderStatus
            this.orderStatus = orderStatus.getCode();
        }
    }

    public Double getTotal() {
        double total = 0.0;

        for(OrderItem item : itens) {
            total += item.getSubTotal();
        }

        return total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
