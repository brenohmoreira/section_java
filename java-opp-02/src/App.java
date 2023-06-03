import java.util.Scanner;
import entities.Product;


/*
 * Toda classe é uma subclasse da classe Object
 * Toda classe, então, possui métodos da classe Object. Alguns deles são: equals, toString, etc. Veremos toString();
 * 
 * O método toString() já existe em Object, logo, qualquer classe tem ele. Contudo, não há nada nesse método e por isso,
 * precisamos reescrever o método (sobreposição) lá na classe que queremos, aí podemos retornar uma String da forma que
 * queremos. Contudo, no que isso se diferencia de qualquer outro método? Simples, o Java já entende que um método toString
 * de uma classe qualquer retorna, por lei, uma String e assim sendo, você não precisa chamar o método quando for usar, pois
 * o Java entende que o contexto exige uma String e automaticamente chama o método toString.
 * 
 * Em vez de usar product.toString(), podemos usar apenas product 
 */

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        /*
         * Product produto = new Product(); 
         * igual à
         * Product produto;
         * 
         * produto = new Product();
         */
        Product product = new Product();

        System.out.printf("Enter the product name: ");
        product.name = input.nextLine();

        System.out.printf("Enter the product price: ");
        product.price = Double.parseDouble(input.nextLine());

        System.out.printf("Enter how many products there are: ");
        product.quantity = Integer.parseInt(input.nextLine());

        // product == product.toString()
        System.out.println("Product data: " + product);

        System.out.printf("Enter how many products you wanna add on storage: ");
        int quantity = Integer.parseInt(input.nextLine());

        product.addProduct(quantity);

        System.out.println("Updated data: " + product);

        System.out.printf("Enter how many products you wanna take out of the storage: ");
        quantity = Integer.parseInt(input.nextLine());

        product.removeProduct(quantity);

        System.out.println("Updated data: " + product);

        input.close();
    }
}
