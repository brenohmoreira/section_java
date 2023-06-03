import model.exceptions.DomainException;

import java.text.ParseException;
import java.util.Scanner;

public class Main {
    /*
     * Sempre que no software tiver algum método que dispara exceção, ou tratamos com try ou passamos para a frente
     * com throws ParseException que deverá ser tratada se alguma classe chamar main
     */
    public static void main(String[] args) throws ParseException {
        /*
         * Qualquer condição de erro ou comportamento inesperado encontrado no software em execução
         *
         * Throwable: superclasse de todos os erros
         *      Error: tipo de erro que não se espera que o programador resolva. Exemplos abaixo
         *          - OutOfMemoryError
         *          - VirtualMachineError
         *      Exception: erros que se espera que o programador resolva
         *          - IOException (erros da I/O)
         *          - RuntimeException (erros que o programa não te obriga a resolver, mas deve)
         *                  - IndexOutOfBoundsException
         *                  - NullPointerException
         *
         * Estrutura try-catch-finally:
         *      Bloco try: Contém o trecho de código que pode acarretar um erro em tempo de execução
         *      Bloco catch: Contém o trecho de código executado caso o problema ocorra
         *      Bloco finally: Contém um trecho de código executado independentemente de try ter dado certo ou não
         *
         * throw new [exceção]("message"); -> o método chamado retorna uma exceção com "message" como getMessage();
         */

        Scanner input = new Scanner(System.in);

        try
        {
            System.out.print("Enter users age: ");
            int age = Integer.parseInt(input.nextLine());

            System.out.printf("Age: %d%n", age);

            throwEx();
        }
        // Captura exceções do tipo NumberFormatException (quando o usuário digita uma letra ao em vez de um número para um tipo number)
        catch(NumberFormatException error)
        {
            System.out.print("Erro: " + error.getMessage());
        }
        catch(DomainException error)
        {
            System.out.print("Erro: " + error.getMessage());
        }
        // Eu poderia escrever outro catch a seguir para tratar mais de um erro
        finally
        {
            System.out.printf("%nFinally executed%n");
        }

        input.close();
    }

    // throws permite ao método que ele retorne uma exceção para quem chamou ele
    public static void throwEx() throws DomainException {
        throw new DomainException("Exceção personalizada");
    }
}