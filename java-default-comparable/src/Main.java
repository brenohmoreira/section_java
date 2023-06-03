import entities.comparable.Employee;
import entities.defaultmethods.service.InterestService;
import entities.defaultmethods.service.USAInterestService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.printf("1 - Comparable%n2 - Default methods%n");
        System.out.print("Enter which program you wanna run: ");
        int optionProgram = Integer.parseInt(input.nextLine());

        switch(optionProgram)
        {
            // Comparable
            case 1:
            {
                List<Employee> list = new ArrayList<>();

                String path = "D:\\Estudos\\development\\sections_php-java\\section_java\\java-default-comparable\\src\\files\\in.txt";

                try(BufferedReader br = new BufferedReader(new FileReader(path)))
                {
                    String employee = br.readLine();

                    while(employee != null)
                    {
                        String[] fields = employee.split(", ");
                        list.add(new Employee(fields[0], Double.parseDouble(fields[1])));
                        employee = br.readLine();
                    }

                    Collections.sort(list);

                    for(Employee infoEmployee : list)
                    {
                        System.out.printf("Name: %s, Salary: %.2f%n", infoEmployee.getName(), infoEmployee.getSalary());
                    }
                }
                catch(IOException error)
                {
                    System.out.println(error);
                }

                break;
            }
            // Default methods
            case 2:
            {
                /*
                 * Disponível a partir do Java 8
                 * A intenção é prover uma implementação padrão para métodos, de modo que evite:
                 *      - Repetição de implementação em toda classe que implemente uma interface
                 *      - Necessidade de se criar classes abstratas para prover reuso da implementação
                 */

                System.out.print("Amount: ");
                double amount = Double.parseDouble(input.nextLine());

                System.out.print("Mounths: ");
                int months = Integer.parseInt(input.nextLine());

                InterestService usa = new USAInterestService(1.0);

                double payment = usa.payment(amount, months);

                System.out.println("Payment after " + months + " months: " + String.format("%.2f", payment));

                break;
            }
            default:
            {
                System.out.println("You entered an invalid value");
            }
        }


        input.close();
    }
}