package model.util;

import model.entities.Product;

import java.util.function.Function;

// Entra Product e sai String
public class UppercaseName implements Function<Product, String> {
    @Override
    public String apply(Product product) {
        return product.getName().toUpperCase();
    }
}
