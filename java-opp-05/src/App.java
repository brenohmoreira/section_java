/*
 * ENCAPSULAMENTO: princípio que esconde detalhes da implementação de uma classe, expondo apenas operações seguras e que
 * mantenham o objeto em um estado consistente.
 * 
 * Regra básica -> um objeto NÃO deve expor nenhum atributo, todos devem ter modificadores de acesso "private". Os atributos
 * devem ser acessados por métodos setters e getters. Classes com modificadores "private" não podem ser acessados por outras
 * classes.
 * Ex: instancia.atributo; não existe, mas sim -> instancia.metodoGet(atributo)
 * 
 * Modificadores de acesso são: public, private, protected ou nada.
 * 
 * nada: o membro só pode ser acessado por classes do mesmo pacote (de entities apenas em entities);
 *  obs -> a classe com o membro sem nada deve ser passada como parametro 
 * private: o membro só pode ser acessado na classe;
 * protected: só pode ser acessado no mesmo pacote e em subclasses (herança) de pacotes diferentes;
 * public: o membro é acessado por todas as classes
 */

import java.util.Scanner;
import entities.People;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        People person = new People();

        System.out.print("Enter the name of the person: ");
        String name = input.nextLine();

        person.setName(name);

        System.out.print("Enter the age of the person: ");
        int age = Integer.parseInt(input.nextLine());

        person.setAge(age);

        // person'S name pois o nome %s é da pessoa mencionada e o their é um pronome neutro que substitui his ou her
        System.out.printf("The person's name is %s and their age is %d years old\n", person.getName(), person.getAge());
        
        input.close();        
    }
}
