package entities;

import entities.enums.OrderStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;

public class Order {
    private LocalDateTime moment;
    private OrderStatus status;

    private List<OrderItem> items = new ArrayList<>();
    private Client client;

    public Order(LocalDateTime moment, OrderStatus status, Client client)
    {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public LocalDateTime getMoment()
    {
        return this.moment;
    }

    public OrderStatus getStatus()
    {
        return this.status;
    }

    public List<OrderItem> getItems()
    {
        return items;
    }

    public void addItem(OrderItem item)
    {
        items.add(item);
    }

    public void removeItem(OrderItem item)
    {
        items.remove(item);
    }

    public Double total()
    {
        double sum = 0.0;

        for(OrderItem item : items)
        {
            sum += item.getPrice() * item.getQuantity();
        }

        return sum;
    }

    public String toString()
    {
        DateTimeFormatter formateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        DateTimeFormatter formateLocal = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        StringBuilder sb = new StringBuilder();

        sb.append("ORDER SUMMARY:\nOrder moment: " + formateTime.format(moment) + "\n");
        sb.append("Order status: " + status + "\n");
        sb.append("Client: " + client.getName() + "(" + formateLocal.format(client.getBirthDate()) + ") - " + client.getEmail() + "\n");
        sb.append("Order items:\n");

        for(OrderItem item : items)
        {
            sb.append(item);
        }

        sb.append("Total price: " + total());

        return sb.toString();
    }
}
