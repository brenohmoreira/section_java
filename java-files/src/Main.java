/*
 * Agora veremos a manipulação de arquivos com JAVA.
 *
 * Classes que usaremos:
 *      - Scanner (Leitor de texto)
 *      - File (Representação abstrata de um arquivo e seu respectivo caminho)
 *      - IOException (Exceção padrão de E/S para files) - Herda de exception
 *      - FileReader (Stream/sequência de leitura com arquivos)
 *      - BufferedReader (Instanciada a partir de FileReader e utilizamos a partir dele, pois é mais rápido)
 *      - FileWriter (Stream/sequência de escrita em arquivos)
 *      - BufferedWriter (Instanciado a partir de FileWriter e utilizamos a partir dele, pois é mais rápido)
 */

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        File file = new File("D:\\Estudos\\development\\sections_php-java\\section_java\\java-files\\src\\file.txt");
        String path = "D:\\Estudos\\development\\sections_php-java\\section_java\\java-files\\src\\file.txt";

        /*
         * try-with-resources: Garante que declaremos um recurso no try entre () e ele automaticamente os fecha para
         * diminuir a verbosidade de ter que fechar o Scanner/BufferedReader/FileReader no finally
         */
        try(Scanner scFile = new Scanner(file))
        {

            // Existe uma próxima linha? true/false
            while(scFile.hasNextLine())
            {
                // Imprima a próxima linha
                System.out.println(scFile.nextLine());
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try(BufferedReader br = new BufferedReader(new FileReader(path)))
        {
            // Quando não tiver linhas para ler, retorna null
            String line = br.readLine();

            while(line != null) {
                System.out.println(line);

                line = br.readLine();
            }
        }
        catch(IOException error) {
            System.out.println("Error: " + error.getMessage());
        }

        String[] lines = new String[] {"Good morning", "Good afternoon", "Good night"};

        String pathWriter = "D:\\Estudos\\development\\sections_php-java\\section_java\\java-files\\src\\fileWriter.txt";

        // Se o arquivo não existir, ele cria. Se não quiser recriar, mas escrever depois, deve-se: new FileWriter(pathWriter, true)
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathWriter))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}