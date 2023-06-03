import java.util.Scanner;
import entities.Product;

public class App {
    public static void main(String[] args) throws Exception {
        /*
         * Arrays é o nome dado para arranjos unidimensionais
         * Em vez de fazer varias variáveis em endereços diferentes, você pode pegar um bloco com x espaços e tornar isso algo só
         * Assim sendo, é plausível concluir que arrays são estruturas de dados.
         * Exclusivamente em java, arrays são tipo referência, que se assemelha muito a um ponteiro (não são ponteiros, Java
         * não possui ponteiros como em C/C++, pois o processo é dinamico, enquanto em C é manual)
         * 
         * Particularidades:
         * - Homogênea (dados do mesmo tipo)
         * - Ordenada (elementos acessados por meio de posições)
         * - Alocada de uma vez só, em um bloco contíguo na memória
         * 
         * Vantagens:
         * - Acesso direto aos valores por posições
         * 
         * Desvantagens:
         * - Tamanho fixo
         * - Dificuldade para realizar inserções e deleções (digamos que tiremos um elemento de posição 2 em uma array de tamanho
         * maior que 2, teremos que subir tudo depois de dois uma posição para que a posição 3 antiga vire a nova 2, por exemplo)
         * 
         * Vetores (arrays) podem ou não ser do tipo referência. Se for instanciado com new o vetor com valores primitivos, então
         * o vetor no stack aponta para a estrutura de dados ordenada chamada array no heap. Se, entretanto, usarmos arrays como
         * sendo tipo referência (fiz abaixo), então o vetor aponta para a estrutura de dados de n posições no heap e cada espaço
         * dessa estrutura de dados deve ser instanciada para apontar para um objeto.
         * 
         * foreach em java:
         * for(tipo apelido: array/coleção)
         * {
         *      <commands>
         * }
         */

        Scanner input = new Scanner(System.in);

        Product[] arrayObject = new Product[2];

        // ---------------------------------------------------------- //

        System.out.print("Enter the name product [0]: ");
        String name = input.nextLine();

        System.out.print("Enter the price product [0]: ");
        double price = Double.parseDouble(input.nextLine());

        arrayObject[0] = new Product(name, price);

        // ---------------------------------------------------------- //

        System.out.print("\nEnter the name product [1]: ");
        name = input.nextLine();

        System.out.print("Enter the price product [1]: ");
        price = Double.parseDouble(input.nextLine());

        arrayObject[1] = new Product(name, price);

        // ---------------------------------------------------------- //

        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

        System.out.printf("\nProduct [0] of the arrayObject\n------------------------------\nProduct name: %s\nProduct price: %.2f", arrayObject[0].getName(), arrayObject[0].getPrice());
        System.out.printf("\n\nProduct [1] of the arrayObject\n------------------------------\nProduct name: %s\nProduct price: %.2f\n", arrayObject[1].getName(), arrayObject[1].getPrice());

        input.close();
    }
}
