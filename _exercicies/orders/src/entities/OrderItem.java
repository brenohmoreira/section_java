package entities;

public class OrderItem {
    private Integer quantity;
    private Double price;
    private Product product;

    public OrderItem(Integer quantity, Double price, Product product)
    {
        this.quantity = quantity;
        this.price = price;

        this.product = product;
    }

    public void setQuantity(Integer quantity)
    {
        this.quantity = quantity;
    }

    public void setPrice(Double price)
    {
        this.price = price;
    }

    public Integer getQuantity()
    {
        return this.quantity;
    }

    public Double getPrice()
    {
        return this.price;
    }

    public Double subTotal()
    {
        return quantity * price;
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        sb.append(product.getName() + ", " + price + ", Quantity: " + quantity + ", Subtotal: " + subTotal() + "\n");

        return sb.toString();
    }
}
