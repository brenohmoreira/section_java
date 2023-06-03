import model.entities.Product;
import model.service.ProductService;
import model.util.PriceUpdate;
import model.util.ProductPredicate;
import model.util.UppercaseName;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        /*
         * A primeira função funcional que veremos é o Comparator, que faz o que o Comparable faz sem a necessidade
         * de manutenção na classe, que é indesejado.
         */

        List<Product> products = new ArrayList<>();

        products.add(new Product("TV", 1900.0));
        products.add(new Product("PC", 2000.0));

        /*
         * Isso é um comparator feito manualmente como classe e sendo instanciado dentro do método sort. Contudo, não
         * queremos toda essa verbosidade. Para resolver o problema, instanciaremos o Comparator na main que retorna
         * a comparação desejada.
         * products.sort(new MyComparator());
         */

        /*
         * Em vez de fazer uma classe MyComparator. Resolve-se simplesmente construindo a função da seguinte forma:
         * Comparator<Product> comp = new Comparator<Product>() {
         *     @Override
         *     public int compare(Product o1, Product o2) {
         *         return 0;
         *     }
         * }
         * Contudo, ainda está verboso demais. Vamos resolver isso com uma expressão lambda / arrow function / anonymous function
         */

        /*
         * Pronto! Agora comp recebe o retorno de uma arrow function que executa a operação de Comparator
         *  Comparator<Product> comp = (p1, p2) -> {
         *      return p1.getPrice().compareTo(p2.getPrice());
         *  };
         * Mas podemos reduzir mais ainda. Em vez de associar em comp, por que não já não utilizar em sort? Como o código
         * só possui uma linha, interessante ressaltar também que o return é desnecessário
         */

        products.sort((p1, p2) -> p1.getPrice().compareTo(p2.getPrice()));

        for (Product product : products) {
            System.out.println(product);
        }

        /*
         * Antes do Java 8, o único paradigma aceito no Java, assim como no C# < versão 3, é o orientado a objetos.
         * Contudo, depois do Java 8, o Java já é considerado uma linguagem multiparadigma, assumindo para si também
         * a programação funcional (paradigma funcional) - Atenção: não é o mesmo paradigma de C, que usa a imperativa.
         * Aspectos da funcional:
         *      - Transparência funcional: funções que dependem exclusivamente dos parâmetros/dados de entrada
         *      - Comum que os objetos sejam imutáveis
         *      - Funções como parâmetros (função de 1ª ordem) são comuns
         *
         * Expressão – lambda: função anônima de primeira classe. A tipagem como argumento da função pode estar omitida.
         * Ela retorna um valor e pode ser usada como parâmetro para outras funções e métodos.
         *
         * Interfaces funcionais: são interfaces com apenas um método abstrato. Suas implementações são equivalentes a
         * expressões lambdas e devemos dar preferência para o uso lambda. Há algumas interfaces funcionais comuns:
         *      - Predicate
         *      - Function
         *      - Consumer
         */

        Scanner input = new Scanner(System.in);

        System.out.print("1 - Predicate\n2 - Consumer\n3 - Function\nVocê deseja qual opção? ");
        int option = Integer.parseInt(input.nextLine());

        switch(option)
        {
            // Predicate
            case 1:
            {
                /*
                 * Interface predicate: possui apenas um método abstrato chamado test.
                 */

                List<Product> pdt = new ArrayList<>();

                pdt.add(new Product("Tv", 900.00));
                pdt.add(new Product("Pc", 1800.00));
                pdt.add(new Product("Mesa", 1500.00));

                /*
                 * Podemos fazer por expressão lambda passando um predicado:
                 * pdt.removeIf(p -> p.getPrice() >= 1500.00);
                 * Podemos implementar uma classe que implementa a Interface<Product> com o método test
                 * pdt.removeIf(new ProductPredicate());
                 * Podemos utilizar métodos estáticos como argumento
                 * pdt.removeIf(Product::staticProduct);
                 * Podemos utilizar métodos não estáticos como argumento também
                 * pdt.removeIf(Product::nonStaticProduct);
                 * Podemos utilizar uma expressão lambda com a interface
                 * Predicate<Product> pred = p -> p.getPrice() >= 100;
                 * Podemos usar inline:
                 */

                /*
                 * Percorre pdt. Para cada item, armazena em p e vê se p.getPrice() >= 100 retorna true ou false
                 */
                pdt.removeIf(p -> p.getPrice() >= 1500.00);

                for (Product prod : pdt) {
                    System.out.println(prod);
                }

                break;
            }
            case 2:
            {
                List<Product> pdt = new ArrayList<>();

                pdt.add(new Product("Tv", 900.00));
                pdt.add(new Product("Pc", 1800.00));
                pdt.add(new Product("Mesa", 1500.00));

                // forEach é um default method da List que recebe um Consumer para fazer alguma coisa em todos objetos da lista
                pdt.forEach(new PriceUpdate());

                // Por método estático
                pdt.forEach(Product::staticPriceUpdate);

                // Por método não estático
                pdt.forEach(Product::nonStaticPriceUpdate);

                // Expressão lambda declarada
                Consumer<Product> cons = p -> {
                    p.setPrice(p.getPrice() * 1.1);
                };

                pdt.forEach(cons);

                // Expressão lambda inline
                pdt.forEach(p -> { p.setPrice(p.getPrice() * 1.1); });

                // System.out é um consumer também!
                pdt.forEach(System.out::println);

                break;
            }
            case 3:
            {
                /*
                 * Agora veremos a função funcional: Function
                 * Há dois tipos (Function<E,S>), um de entrada e outro de saída
                 */

                List<Product> pdt = new ArrayList<>();

                pdt.add(new Product("Tv", 900.00));
                pdt.add(new Product("Pc", 1800.00));
                pdt.add(new Product("Mesa", 1500.00));

                // A função map é uma função que aplica uma função a todos elementos de uma stream (veremos depois)
                /*
                 * Conversões:
                 *      List para stream: .stream()
                 *      Stream para list: .collect(Collectors.toList())
                 */

                // Pega uma lista, converte para stream, aplica função map que recebe a função Function e volta para lista
                List<String> names = pdt.stream().map(new UppercaseName()).collect(Collectors.toList());
                // Também dá: List<String> names = pdt.stream().map(Product::staticUpperCase).collect(Collectors.toList());
                // Também dá: List<String> names = pdt.stream().map(Product::nonStaticUpperCase).collect(Collectors.toList());
                // Também dá: List<String> names = pdt.stream().map(product -> product.getName().toUpperCase()).collect(Collectors.toList());
                
                names.forEach(System.out::println);

                break;
            }
            default:
            {
                System.out.println("Dígito inválido");
            }
        }

        /*
         * removeIf(Predicate) -> Predicate é um teste que retorna true ou false
         * forEach(Consumer)
         * map(Function)
         *
         * Faremos agora uma função que recebe funções personalizadas
         */

        List<Product> productsList = new ArrayList<>();

        productsList.add(new Product("TV", 1900.0));
        productsList.add(new Product("Tela", 2000.0));
        productsList.add(new Product("PC", 2000.0));

        ProductService ps = new ProductService();

        double sum = ps.filteredSum(productsList, p -> p.getName().charAt(0) == 'T');

        System.out.println(sum);

        input.close();
    }
}