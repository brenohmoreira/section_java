package entities;

public class Product {
    public String name;
    public double price;
    public int quantity;

    public double totalValue()
    {
        return price * quantity;
    }

    public void addProduct(int quantity)
    {
        this.quantity += quantity;
    }

    public void removeProduct(int quantity)
    {
        this.quantity -= quantity;
    }

    public String toString()
    {
        return this.name + ", $ " + this.price + ", " + this.quantity + " unit. Total value: $ " + totalValue();
    }
}
