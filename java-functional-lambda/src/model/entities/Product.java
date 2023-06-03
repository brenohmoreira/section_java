package model.entities;

public class Product {
    private String name;
    private Double price;

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String toString()
    {
        return "Product: " + name + ". Price: R$ " + price;
    }

    // Trabalha com o product passado para ele
    public static boolean staticProduct(Product product) {
        return product.getPrice() >= 100;
    }

    // Trabalha com ele mesmo
    public boolean nonStaticProduct() {
        return price >= 100;
    }

    public static void staticPriceUpdate(Product product) {
        product.setPrice(product.getPrice() * 1.1);
    }

    public void nonStaticPriceUpdate() {
        price = price * 1.1;
    }

    public static String staticUpperCase(Product product) {
        return product.getName().toUpperCase();
    }

    public String nonStaticUpperCase() {
        return name.toUpperCase();
    }
}
