import model.entities.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        List<Employee> employee = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader("D:\\Estudos\\development\\sections_php-java\\section_java\\_exercicies\\functional_exercise\\src\\files\\file.csv"))) {
            String line = br.readLine();

            while(line != null) {
                String[] fields = line.split(",");

                employee.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));

                line = br.readLine();
            }
        }
        catch(IOException error) {
            System.out.println(error);
        }

        employee.forEach(person -> System.out.println(person.getName() + ": " + person.getSalary()));

        System.out.print("Enter salary: ");
        double salary = Double.parseDouble(input.nextLine());

        List<String> emails = employee.stream().filter(x -> x.getSalary() >= salary).map(y -> y.getEmail()).sorted().collect(Collectors.toList());

        System.out.println("Email of people whose salary is more than " + String.format("%.2f", salary));
        emails.forEach(email -> System.out.println(email));

        double sum = employee.stream().filter(x -> x.getName().charAt(0) == 'M').map(x -> x.getSalary()).reduce(0.0, (x, y) -> x + y);

        System.out.println("Sum of salary of people whose name starts with 'M': " + String.format("%.2f", sum));

        input.close();
    }
}