import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import entities.Employee;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.print("How many employees will be registered?: ");
        int quantityEmployees = Integer.parseInt(input.nextLine());

        List<Employee> listEmployees = new ArrayList<Employee>();

        for(int i = 0; i < quantityEmployees; i++)
        {
            System.out.printf("Employee #%d:\n", i + 1);

            System.out.print("ID: ");
            int idEmployee = Integer.parseInt(input.nextLine());

            System.out.print("Name: ");
            String nameEmployee = input.nextLine();

            System.out.print("Salary: ");
            double salaryEmployee = Double.parseDouble(input.nextLine());

            Employee employee = new Employee(idEmployee, nameEmployee, salaryEmployee);

            listEmployees.add(employee);

            System.out.printf("\n");
        }

        System.out.print("Enter the employee id that will have salary increase: ");
        int idEmployee = Integer.parseInt(input.nextLine());

        // Procure na lista um elemento que atenda x (apelido para cada indice) -> x.getId() == idEmployee
        if(listEmployees.stream().filter(x -> x.getId() == idEmployee).findFirst().orElse(null) != null)
        {
            System.out.print("Enter the percentage: ");
            double percent = Double.parseDouble(input.nextLine());
            
            // Percorre os índices
            for(int i = 0; i < listEmployees.size(); i++)
            {
                // Testa se o índice i é igual ao índice desejado
                if(listEmployees.get(i).getId() == idEmployee)
                {
                    listEmployees.get(i).salaryIncrease(percent);
                }
            }
        }
        else
        {
            System.out.print("Invalid ID");
        }

        System.out.print("Employee list:\n");

        for(Employee employee : listEmployees)
        {
            System.out.printf("" + employee);
        }

        input.close();
    }
}
