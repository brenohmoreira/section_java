import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter path file: ");
        String path = input.nextLine();

        boolean success = new File(path + "\\out").mkdir();

        String newPath = path + "\\out\\summary.csv";

        try(BufferedReader bw = new BufferedReader(new FileReader(newPath)))
        {
            String item = bw.readLine();

            while(item != null) {
                System.out.println(item);
                item = bw.readLine();
            }
        }
        catch(IOException error)
        {
            System.out.println(error);
        }
        input.close();

    }
}
