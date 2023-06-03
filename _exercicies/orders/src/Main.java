import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        DateTimeFormatter formater_date = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Client
        System.out.println("Enter client data:");

        System.out.print("Name: ");
        String name = scan.nextLine();

        System.out.print("Email: ");
        String email = scan.nextLine();

        System.out.print("Birth date (DD/MM/YYYY): ");
        String date = scan.nextLine();

        Client client = new Client(name, email, LocalDate.parse(date, formater_date));

        // Order
        System.out.println("Enter order data:");

        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(scan.nextLine());

        System.out.print("How many items to this order?: ");
        int quantityOrders = Integer.parseInt(scan.nextLine());

        Order order = new Order(LocalDateTime.now(), status, client);

        for(int i = 0; i < quantityOrders; i++)
        {
            System.out.printf("Enter #%d item data:\n", i + 1);

            System.out.print("Product name: ");
            name = scan.nextLine();

            System.out.print("Product price: ");
            double price = Double.parseDouble(scan.nextLine());

            System.out.print("Quantity: ");
            int quantity = Integer.parseInt(scan.nextLine());

            Product product = new Product(name, price);

            OrderItem item = new OrderItem(quantity, price, product);

            order.addItem(item);
        }

        System.out.printf("" + order);

        scan.close();
    }
}