import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of products: ");
        int numberProducts = Integer.parseInt(input.nextLine());

        List<Product> products = new ArrayList<>();

        for(int i = 0; i < numberProducts; i++) {
            System.out.printf("Product #%d data:\n", i + 1);

            System.out.print("Common, used or imported? (c/u/i): ");
            String option = input.nextLine();

            if(option.equals("c") || option.equals("C")) {
                System.out.print("Name: ");
                String name = input.nextLine();

                System.out.print("Price: ");
                double price = Double.parseDouble(input.nextLine());

                Product product = new Product(name, price);
                products.add(product);
            }
            else if (option.equals("u") || option.equals("U")) {
                System.out.print("Name: ");
                String name = input.nextLine();

                System.out.print("Price: ");
                double price = Double.parseDouble(input.nextLine());

                System.out.print("Manufacture date (DD/MM/YYYY): ");
                String date = input.nextLine();

                LocalDate manufactureDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                UsedProduct usedProduct = new UsedProduct(name, price, manufactureDate);
                products.add(usedProduct);
            }
            else if (option.equals("i") || option.equals("I")) {
                System.out.print("Name: ");
                String name = input.nextLine();

                System.out.print("Price: ");
                double price = Double.parseDouble(input.nextLine());

                System.out.print("Customs fee: ");
                double customsFee = Double.parseDouble(input.nextLine());

                ImportedProduct importedProduct = new ImportedProduct(name, price, customsFee);
                products.add(importedProduct);
            }
            else {
                System.out.print("Invalid character. Try again.");
                i--;
            }
            System.out.print("------------------\n");
        }

        for(Product product : products) {
            System.out.print(product.priceTag() + "\n");
        }

        input.close();
    }
}