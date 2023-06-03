import java.util.Scanner;
import java.security.SecureRandom;

// Classe "App" (letra maíscula) de acesso público 
public class App 
{	 
    // Método público, estático (pode ser acessado sem ser necessário instanciar a classe) e void, pois não retorna nada
    public static void main(String[] args) throws Exception {

        /*
         * Conveção de names: 
         * Camel case: lastName
         * - váriaveis
         * - atributos
         * - métodos
         * - pacotes
         * - parâmetors
         * 
         * Pascal case: LastName
         * - classes
         * 
         * Váriaveis declaradas em escopo global na função pode ser acessada na função toda. Se, entretanto, a váriavel for
         * declarada dentro de um escopo de menor escopo, ele só poderá ser acessado nesse escopo. Um exemplo é o if-else, se
         * declararmos uma váriavel dentro de um if-else, essa váriavel só poderá ser acessada no if-else, fora dele não. O
         * certo seria:
         * 
         * // Deve-se assumir o valor zero para a váriavel pois o if-else é uma condicional e, portanto, pode não ser atendida.
         * int value = 0;
         * 
         * if()
         * {
         *      value = 10;
         * }
         * 
         * // Aparecerá 10
         * System.out.println(value);
         * 
         */

        // Ler informações do teclado com scan
        Scanner input = new Scanner(System.in);

        // Constante 
        final int tam_MAX = 5;

        // Array sem tamanho definido. O tamanho muda de acordo com a quantidade de elementos
        int[] num = {1, 2};
        // Criando uma array do tipo String, com tamanho definido (tam_MAX = 5) -> 0, 1, 2, 3, 4 
        String[] peoples = new String[tam_MAX];

        for(int x = 0; x < peoples.length; x++)
        {
            peoples[x] = "" + x;
            System.out.printf("%s de índice %d\n", peoples[x], x);
        }

        System.out.printf("" + peoples.length + " Posições\n");

        String nome = "Breno"; 
        int age = 18;

        // "println" já quebra a linha logo no final -> printf("Hello, World\n") (o barra + n também funciona)
        System.out.println("Hello, World!");
        System.out.printf("String: %s - Número inteiro: %d - Soma: %d\n", nome, age, num[0] + num[1]);

        /*
         * Estruturas de repetição e condição é o padrão: switch/case, if/else, for, while, do/while, etc
         * Existe uma forma inline de fazer um' if_else que vale citar
         */

        /*
         * Você pode ler as informações com nextLine e nextInt, sendo que nextInt pega um valor inteiro do teclado e o nextLine
         * uma String. Acontece que se você usar os dois seguidos, ele não executará um deles, pois o buffer precisaria ser 
         * limpo, dado que ele interpreta o "Enter" como o próximo nextLine depois do nextInt. Sendo assim, use apenas nextLine
         * e quando precisar que ele vire um valor inteiro ou algo assim, use Integer.parseInt(variavel) por exemplo
         */

        System.out.printf("Digite a nota do aluno: ");
        int nota = Integer.parseInt(input.nextLine());

        System.out.printf("Digite o nome do aluno: ");
        String name_aluno = input.nextLine();

        String message = (nota >= 6 ? "True - O aluno " + name_aluno + " Tirou " + nota + "\n": "O aluno repetiu\n");
        
        System.out.printf("Message: %s", message);

        /*
         * MÉTODOS DE CLASSE ARRAY
         * 
         * Arrays.sort(array); -> Ordena a array (2, 3, 0, 5, 4 -> 0, 2, 3, 4, 5)
         * Arrays.fill(array, valor); -> Preenche a array toda com o valor
         * System.arraycopy(Array copiada, posição que vai começar a cópia, Array que receberá a cópia, posição que vai começar
         * a cópia, número de posições copiadas);
         * Arrays.equals(array1, array2); -> Retorna false ou true depois de comparar duas arrays
         */

         /*
          * MATRIZES:
          */

          final int rows = 3;
          final int columns = 3;

          int[][] matriz_example = new int[rows][columns];

          for(int r = 0; r < rows; r++)
          {
            for(int c = 0; c < columns; c++)
            {
                matriz_example[r][c] = new SecureRandom().nextInt(100);
            }
          }

          for(int r = 0; r < rows; r++)
          {
            for(int c = 0; c < columns; c++)
            {
                if(matriz_example[r][c] < 100 && matriz_example[r][c] >= 10)
                {
                    System.out.printf("0%d ", matriz_example[r][c]);
                } else if(matriz_example[r][c] < 10)
                {
                    System.out.printf("00%d ", matriz_example[r][c]);
                } else
                {
                    System.out.printf("%d ", matriz_example[r][c]);
                }
            }
            System.out.printf("\n");
          }

          // É uma boa prática específicar "f" depois do valor float se for float e "." depois do valor double se for double
          float example_float = 10f;
          double example_double = 10.;

          // Isso é um exemplo de casting, pois o método parseInt só pode ser de String para int
          int example_casting = (int)example_double;

          System.out.println(example_float);
          System.out.println(example_double);
          System.out.println(example_casting);

          // Precisa dar close no scanner (input)
          input.close();
    }
}
