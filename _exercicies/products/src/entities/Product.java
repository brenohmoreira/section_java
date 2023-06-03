package entities;

public class Product {
    protected String name;
    protected Double price;

    public Product() {

    }

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String priceTag() {
        StringBuilder sb = new StringBuilder();

        sb.append(name + " $ " + price);

        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
