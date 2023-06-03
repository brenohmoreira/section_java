import util.CurrencyConverter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.printf("What is the dollar price? ");
        double cotacao = Double.parseDouble(input.nextLine());

        System.out.printf("How many dollars will be bought? ");
        double dolarValue = Double.parseDouble(input.next());

        System.out.printf("Amount to be paid in R$ is %.2f\n", CurrencyConverter.converter(cotacao, dolarValue));

        input.close();
    }
}
