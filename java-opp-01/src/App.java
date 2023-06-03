/*
 * A ideia é fazer um programa que calcula a área de dois triângulos recebendo os dados dos lados e falar qual o maior deles 
 * em área utilizando POO.
 * Note que da forma padrão, utilizaremos váriaveis com a mesma ideia para fazer dois triângulos. Usamos POO aqui por que é
 * mais fácil ter um modelo do que é a entidade triângulo e criar dois objetos triângulos a partir desse modelo.
 * 
 * TODA CLASSE É UMA SUBCLASSE DA CLASSE OBJECT
 * 
 * Classe: tipo estruturado que contém membros, são os modelos dos nossos objetos. Os membros podem ser
 *  - Atributos => dados/campos
 *  - Métodos => funções/operações
 * A classe pode conter outros recursos, como: herança, polimorfismo, encapsulamento, sobrecarga e construtores.
 * 
 * Algo MUITO importante para se entender é a relação do new, instaciação e memória.
 * 
 * Quando declaramos váriaveis, estamos salvando ela em uma área chamada Stack em que é salvo dados estáticos. Então:
 * int z = 10;
 * float w = 20;
 * Triangle x, y;
 * x, y, w e z estão na Stack e possuem um endereço próprio e, dentro desse endereço, há o conteúdo. No caso do endereço da 
 * variável z, existe o valor dez, por exemplo. Quando estamos falando de classes como Triangle, o que vai ser armazenado den
 * tro desse endereço na Stack não são dados, mas sim (quando instanciado com o new), o endereço de um objeto em uma área da
 * memória chamada Heap, que armazena dados dinâmicos.
 * 
 * Ex: 
 * // Por enquanto não tem nada dentro de x, se exibir ela dá erro
 * Triangle x; 
 * // A partir de agora x armazena o endereço de um objeto em Heap, se der println(x), verá o endereço do objeto
 * x = new Triangle();
 */

import java.util.Scanner;

import entities.Triangle;

public class App {
    public static void main(String[] args) throws Exception {
        // Triângulo x e triângulo y, cada um representa um objeto
        Scanner input = new Scanner(System.in);
        Triangle x, y;

        x = new Triangle();
        y = new Triangle();

        /* TRIANGLE X */

        System.out.println("Digite o valor de um lado (x): ");
        x.sides_triangle[0] = Float.parseFloat(input.nextLine());

        System.out.println("Digite o valor de um lado (x): ");
        x.sides_triangle[1] = Float.parseFloat(input.nextLine());

        System.out.println("Digite o valor de um lado (x): ");
        x.sides_triangle[2] = Float.parseFloat(input.nextLine());

        /* TRIANGLE Y */

        System.out.println("Digite o valor de um lado (y): ");
        y.sides_triangle[0] = Float.parseFloat(input.nextLine());

        System.out.println("Digite o valor de um lado (y): ");
        y.sides_triangle[1] = Float.parseFloat(input.nextLine());

        System.out.println("Digite o valor de um lado (y): ");
        y.sides_triangle[2] = Float.parseFloat(input.nextLine());

        // Chamamos na instância x, logo, ele considerará os atributos da instância x no método calcule_area
        double area_x = x.calcule_area();
        double area_y = y.calcule_area();

        if(area_x > area_y)
        {
            System.out.printf("A área do triângulo x (%.2f) é maior\n", area_x);
        } 
        else if(area_x < area_y)
        {
            System.out.printf("A área do triângulo y (%.2f) é maior\n", area_y);
        }
        else
        {
            System.out.printf("A área de x (%.2f) é igual à area de y (%.2f)\n", area_x, area_y);
        }

        input.close();
    }   
}
