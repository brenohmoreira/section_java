/*
 * STATIC: Métodos e/ou atributos que são chamados sem serem instanciados. Sendo: Objeto.[método/atributo]
 * OBS: Não é possível chamar um método instanciável dentro de um método estático numa mesma classe.
 */

import java.util.Scanner;
import util.Calculator;

public class App 
{
    public static void main(String[] args) throws Exception 
    {
        Scanner input = new Scanner(System.in);

        System.out.printf("Enter radius: ");
        double radius = Double.parseDouble(input.next());

        // Não é necessario instância. Objeto.metodo(param) ou Objeto.atributo
        System.out.printf("Circunference: %.2f\n", Calculator.circunference(radius));
        System.out.printf("Volume: %.2f\n", Calculator.volume(radius));
        System.out.printf("Pi value: %.2f\n", Calculator.PI);

        input.close();
    }
}
