import java.util.Objects;
import java.util.Scanner;
import entities.Account;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner input = new Scanner(System.in);

        System.out.print("Do you wanna register a user? (y/n): ");
        String option = input.nextLine().toUpperCase();
            
        Account account = new Account();

        /*
         * Em C não se utiliza "==", pois o "==" questiona se ambos valores/variáveis possuem o mesmo endereço de memória. Para
         * comparar dois valores/variáveis, use [valor/variavel].equals[valor/variavel]
         */
        if(option.equals("Y"))
        {
            System.out.print("\nEnter the name of the account: ");
            String nameOwner = input.nextLine();

            System.out.print("Enter the number of the account: ");
            int numberAccount = Integer.parseInt(input.nextLine());

            System.out.print("\nDo you wanna add an initial value? (y/n):  ");
            option = input.nextLine().toUpperCase();

            if(option.equals("Y"))
            {
                System.out.print("\nEnter how much money you wanna add: ");
                double initDeposit = Double.parseDouble(input.nextLine());

                account = new Account(numberAccount, nameOwner, initDeposit);
            }
            else
            {
                account = new Account(numberAccount, nameOwner);
            }
        }
        else
        {
            System.out.print("\nUser not will be register\n\n");
        }

        if(!Objects.isNull(account.getNameOwner()))
        {
            System.out.printf("\nAccount data: " + account + "\n");

            System.out.print("\nEnter a deposit value: ");
            double deposit = Double.parseDouble(input.nextLine());

            account.deposit(deposit);

            System.out.printf("\nAccount data: " + account + "\n");

            System.out.print("\nEnter a withdraw value: ");
            double withdraw = Double.parseDouble(input.nextLine());

            account.withdraw(withdraw);

            System.out.printf("\nAccount data: " + account + "\n\n");
        }

        input.close();
    }
}
