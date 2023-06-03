import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception {
        /*
         * Listas:
         * 
         * Assim como uma array, a lista é uma estrutura de dados. Suas peculiaridades iguais às arrays são:
         * - Homogênea (contém dados do mesmo tipo)
         * - Ordenada (elementos dentro dela são acessados de forma ordenada (0, ...))
         * Contudo, se diferencia em:
         * - Inicia vazia, seus elementos são alocados sob demanda (apenas quando precisar)
         * - Cada elemento em cada posição está armazenado no que chamamos de nodo. O nodo da posição 0 possui dois espaços, um 
         * para o valor daquela posição e um espaço que é um ponteiro para a próxima posição. Isso acontece de maneira sequenci
         * al, só parando quando um ponteiro apontar para um nodo vazio.
         * 
         * Tipo (é uma interface, não uma classe, logo, não pode ser instanciada): List. Para instanciar o tipo List, precisamos
         * usar uma classe que implementa a interface List (há varias), as conhecidas são: ArrayList, LinkedList, etc.
         * 
         * Vantagens:
         * - Tamanho variável
         * - Facilidade para realizar inserções e deleções
         * 
         * Desvantagens:
         * - Acesso sequencial aos elementos (as vezes essa navegação é otimizada, dependendo da classe utilizada). Isso signifi
         * ca que para chegar na posição 10, ele precisa passar pela 0, 1, 2, 3, 4, 5 [...].
         */

        // Só aceita wrapper class, não tipagem primitiva
        List<String> list = new ArrayList<>();

        list.add("Maria");
        list.add("Breno");
        
        // Colocando "Breno" na posição 0. Todo resto vai ir para frente
        list.add(0, "Hugo");

        // Tira o "Hugo" e tudo que estava na frente dele vai para trás
        list.remove("Hugo");

        // Tira o que está no index 1
        list.remove(1);

        list.add("João");
        list.add("Joaquim");
        list.add("Paulo");
        list.add("Marcos");

        // Forma que o JAVA encontrou para realizar operações lambda (Java 8+) com as listas já existentes até então

        /*
         * list.stream() faz a lista ser compatível com operações lambda
         * filter serve para filtrar pela operação lambda
         * collect(Collector.toList()) é para converter o que retorna apra lista
         */

        List<String> initJ = list.stream().filter(x -> x.charAt(0) == 'J').collect(Collectors.toList());

        // Apague x para tal x de string com char no index 0 sendo igual a J, logo, que começa com J
        // Isso é uma função lambda, veremos melhor depois. Essa função lambda em específico chama-se predicado
        list.removeIf(x -> x.charAt(0) == 'J');

        // Armazene em index o indice de Paulo. Quando o indexOf não encontra o elemento, retorna -1
        int index = list.indexOf("Paulo");

        System.out.printf("Indice de Paulo: " + index + "\n");

        System.out.printf("" + list.size() + "\n");

        /*
         * list.stream() para tornar a list compatível com operações lambda
         * filter para filtrar com operação lambda
         * findFirst para pegar o primeiro que atenda a necessidade lambda
         * orElse para caso não ache nada que atenda a necessidade lambda, no caso, retorne null
         */

        String name = list.stream().filter(x -> x.charAt(0) == 'M').findFirst().orElse(null);

        System.out.printf("" + name + "\n");

        for(String listSurname : list)
        {
            System.out.printf("" + listSurname + "\n");
        }

        System.out.print("---------------------\n");

        for(String listSurname : initJ)
        {
            System.out.printf("" + listSurname + "\n");
        }
    }
}
