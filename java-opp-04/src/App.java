/*
 * Construtores: são funções inicializadas assim que uma classe é instanciada em um objeto. Utilizamos para:
 *  - Permitir ou obrigar que a classe recebeda dados
 * 
 * This: referência para o próprio objeto
 *  - Diferenciar atributos de variáveis locais (this.name = name)
 *  - Passar o próprio objeto como argumento na chamada de um método ou construtor
 * 
 * Sobrecarga: disponibilizar mais de uma versão da mesma operação, o que diferencia ambas são os parâmetros
 *  - Pode-se criar um segundo construtor que receba dois parâmetros ao em vez de um. O JAVA saberá qual você está chamando
 *  dependendo da quantidade de parâmetros que você usar quando instanciar a classe.
 */ 

import entities.Product;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.printf("Enter the product name: ");
        String name = input.nextLine();

        System.out.printf("Enter the product price: ");
        Double price = Double.parseDouble(input.nextLine());

        System.out.printf("Enter how many products there are: ");
        int quantity = Integer.parseInt(input.nextLine());

        Product product = new Product(name, price, quantity);

        System.out.printf("" + product);

        input.close();
    }
}
