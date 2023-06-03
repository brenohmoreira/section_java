import entities.NaturalPerson;
import entities.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of tax payers: ");
        int numberPayers = Integer.parseInt(input.nextLine());

        List<Person> peoples = new ArrayList<>();

        for(int i = 0; i < numberPayers; i++) {
            System.out.printf("Tax payer #%d data:%n", i + 1);

            System.out.print("Individual or company (i/c): ");
            String option = input.nextLine().toUpperCase();

            // Curiosidade: .equals só pode ser utilizada por wrapper class, como, por exemplo, a String
            if(option.equals("I"))
            {
                System.out.print("Name: ");
                String name = input.nextLine();

                System.out.print("Anual income: ");
                double anualIncome = Double.parseDouble(input.nextLine());

                System.out.print("Health expenditures: ");
                double healthExpenses = Double.parseDouble(input.nextLine());

                peoples.add(new NaturalPerson(name, anualIncome, healthExpenses));
            }
            else if(option.equals("C"))
            {
                System.out.print("Name: ");
                String name = input.nextLine();

                System.out.print("Anual income: ");
                double anualIncome = Double.parseDouble(input.nextLine());

                System.out.print("Number of employees: ");
                int numberEmployee = Integer.parseInt(input.nextLine());

                peoples.add(new NaturalPerson(name, anualIncome, numberEmployee));
            }
            else
            {
                System.out.print("Enter a valid value");
                i--;
            }
        }

        for(Person person : peoples) {
            System.out.printf("%s", person);
        }

        input.close();
    }
}