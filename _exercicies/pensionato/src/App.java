import java.util.Scanner;
import java.util.Objects;
import entities.Room;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        Room[] room = new Room[10];
        
        int quantityRent = 0;

        try 
        {
            System.out.print("Digite quantos quartos serão alugados (1-10): ");
            quantityRent = Integer.parseInt(input.nextLine());;
        } 
        catch (Exception e) 
        {
            System.out.print("Erro: " + e);
        } 

        if(quantityRent >= 1 && quantityRent <= 10)
        {
            for(int i = 0; i < quantityRent; i++)
            {
                System.out.printf("\nAluguel #%d\n", i);
                System.out.print("Room (1-10): ");
                int numberRoom = Integer.parseInt(input.nextLine());

                if(numberRoom >= 1 && numberRoom <= 10)
                {
                    if(Objects.isNull(room[numberRoom - 1]))
                    {
                        System.out.print("Name: ");
                        String nameOwner = input.nextLine();
        
                        System.out.print("Email: ");
                        String emailOwner = input.nextLine(); 
    
                        room[numberRoom - 1] = new Room(numberRoom, nameOwner, emailOwner);
                    }
                    else
                    {
                        System.out.print("Esse quarto ja esta alugado");
                        i--;
                    }
                }
                else
                {
                    System.out.print("\nDigite um número válido (1-10)\n");
                    i--;
                }
            }
        }
        else
        {
            System.out.print("\nDigite um número válido (1-10)\n\n");
        }

        System.out.print("\nQuartos alugados:\n");

        for(Room roomSurname : room)
        {
            if(!Objects.isNull(roomSurname))
            {
                System.out.printf("" + roomSurname);
                System.out.printf("\n");
            }
        }

        input.close();
    }
}
