import model.entities.Account;
import model.exception.DomainException;

import java.text.ParseException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws ParseException {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter account data:");

        System.out.print("Number: ");
        int number = Integer.parseInt(input.nextLine());

        System.out.print("Holder: ");
        String holder = input.nextLine();

        System.out.print("Initial balance: ");
        double initialBalance = Double.parseDouble(input.nextLine());

        System.out.print("Withdraw limit: ");
        double withdrawLimit = Double.parseDouble(input.nextLine());

        Account account = new Account(number, holder, initialBalance, withdrawLimit);

        String option = "";

        do
        {
            System.out.print("Do you wanna deposit or make a withdraw? (D/W): ");
            option = input.nextLine().toUpperCase();

            if(option.equals("D"))
            {
                System.out.print("Enter amount of deposit: ");
                Double amount = Double.parseDouble(input.nextLine());

                account.deposit(amount);

                System.out.printf("New balance: %.2f", account.getBalance());
            }
            else if(option.equals("W"))
            {
                System.out.printf("Enter amount of withdraw (Balance: %.2f, withdrawLimit: %.2f): ", account.getBalance(), account.getWithdrawLimit());
                Double amount = Double.parseDouble((input.nextLine()));

                try
                {
                    account.withdraw(amount);

                    System.out.printf("New balance: %.2f%n", account.getBalance());
                }
                catch(DomainException domainError)
                {
                    System.out.printf("Erro: " + domainError.getMessage());
                }
            }
            else
            {
                System.out.print("Invalid character");
            }

            System.out.printf("%nDo you wanna make other operation? (Y/N): ");
            option = input.nextLine().toUpperCase();

        } while(option.equals("Y"));


        input.close();
    }
}