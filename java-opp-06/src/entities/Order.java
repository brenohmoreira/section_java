package entities;

import entities.enums.OrderStatus;
import java.util.Date;

public class Order {
    private Integer id;
    private Date moment;
    private OrderStatus status;   
    
    public Order(Integer id, Date moment, OrderStatus status)
    {
        this.id = id;
        this.moment = moment;
        this.status = status;
    }   

    // Getters
    public Integer getId()
    {
        return this.id;
    }

    public Date getMoment()
    {
        return this.moment;
    }

    public OrderStatus getStatus()
    {
        return this.status;
    }

    // Setters 

    public void setId(Integer id)
    {
        this.id = id;
    }

    public void setMoment(Date moment)
    {
        this.moment = moment;
    }

    public void setStatus(OrderStatus status)
    {
        this.status = status;
    }

    // toString

    public String toString()
    {
        return "Order: " + this.id + ", moment: " + this.moment + ". Status: " + this.status + "\n";
    }
}
