import Generics.services.PrintService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("1 - Generics\n2 - Set\n3 - Map\nEnter which you to want: ");
        int optionExercise = Integer.parseInt(input.nextLine());

        switch(optionExercise)
        {
            case 1:
            {
                /*
                 * Generics permitem que interfaces, classes e métodos possam ser parametrizados por tipo.
                 * Geralmente são utilizadas em coleções para reuso.
                 *
                 * Digamos que queiramos utilizar uma classe que possa ser reutilizada por qualquer tipo. Seja uma classe, por exemplo,
                 * que opera uma coleção. Devemos utilizar o Generics <[type]> para conseguir generalizar o tipo e garantir que ela
                 * possa ser utilizada por qualquer tipagem.
                 */

                System.out.print("How many values you wanna add?: ");
                int howManyValues = Integer.parseInt(input.nextLine());

                PrintService<Integer> ps = new PrintService<>();

                for(int i = 1; howManyValues >= i; i++)
                {
                    System.out.print("Enter value: ");
                    Integer value = Integer.parseInt(input.nextLine());

                    ps.addValue(value);
                }

                ps.print();

                // Tipo coringa:

                /*
                 * Todos tipos (wrapper) derivam de Object. Assim sendo, tudo é Object.
                 * Mas há uma exceção: Listas.
                 *
                 * Uma lista de tipo Integer não deriva de uma lista do tipo Object, logo, não podemos comparar.
                 *
                 * O supertipo de qualquer tipo de lista é o List<?>, que é o tipo coringa.
                 */

                List<?> listCoringa = new ArrayList<>();
                List<Integer> listInteger = new ArrayList<>();

                // Podemos fazer. Tratamos todos os itens de listCoringa que vieram de listInteger como Object.
                listCoringa = listInteger;

                // Contudo, não é possível salvar dados em um tipo coringa.

                /*
                 * Podemos adianta delimitar melhor com extends
                 * List<? extends Number>
                 * Essa lista aceita qualquer tipo que seja subtipo de Number (Float, Integer, Byte, etc)
                 * Ainda não podemos utilizar add na list, pois não o programa nunca vai saber se o tipo inserido é
                 * compatível com outro tipo que poderia ser a lista. Esse é o princípio da covariância, pois o GET
                 * é possível, mas o PUT não.
                 * Há também o contrário, a contravariância.
                 * List<? super Number> list
                 * Essa lista aceita qualquer tipo Number (precisa ser NUMBER, não subtipo de) ou Object (superclasse).
                 * Assim sendo, podemos inserir nela números e strings por exemplo. Mas não podemos por exemplo fazer:
                 * Number x = list.get(0)
                 * O motivo é óbvio, não sabemos se o que tem dentro de 0 é um Number de fato, pode ser uma String. No
                 * caso, GET dá erro e PUT funciona.
                 */

                List<Integer> myInts = Arrays.asList(1, 2, 3, 4);
                List<Double> myDoubles = Arrays.asList(3.14, 6.28);
                List<Object> myObjs = new ArrayList<>();

                copy(myInts, myObjs);
                printList(myObjs);
                copy(myDoubles, myObjs);
                printList(myObjs);

                break;
            }
            case 2:
            {
                /*
                 * Set: conjunto de elementos similar ao da álgebra
                 * - Não admite repetições
                 * - Elementos não possuem posição
                 * - Acesso, inserção e remoção de elementos são rápidos
                 * - Oferece operações de conjuntos: interseção, união e diferença
                 * - Principais implementações:
                 *          - HashSet: mais rápido e não ordenado
                 *                  - Compara por Hash, então se for uma classe feita por você, deve-se incluir o método Hash
                 *                  - Ele barra as ocorrências iguais, não tendo dentro de si repetições
                 *          - TreeSet: mais lento e ordenado pelo compareTo
                 *                  - Compara por compareTo, então se for uma classe feita por você, deve-se incluir Comparable
                 *          - LinkedHashSet: velocidade intermediária e elementos na ordem em que foram adicionados
                 */

                Set<String> set = new HashSet<>();

                set.add("Breno");
                set.add("Mariana");
                set.add("Vitor");

                System.out.println(set.contains("Mariana"));

                set.removeIf(x -> x.charAt(0) == 'V');

                for(String name : set) {
                    System.out.println(name);
                }

                Set<Integer> a = new TreeSet<>(Arrays.asList(0, 2, 4, 6, 7));
                Set<Integer> b = new TreeSet<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6));

                // UNIÃO
                Set<Integer> union = new TreeSet<>(a);
                union.addAll(b);
                System.out.println(union);

                // INTERSEÇÃO
                Set<Integer> intersec = new TreeSet<>(a);
                intersec.retainAll(b);
                System.out.println(intersec);

                // DIFERENÇA
                Set<Integer> dif = new TreeSet<>(a);
                dif.removeAll(b);
                System.out.println(dif);

                break;
            }
            case 3:
            {
                /*
                 * Map<K,V>: estrutura de dados genérica que possui dois tipos. Um tipo chave e um tipo valor em PARES.
                 * - Colocamos valores na coleção e associamos uma chave a ele
                 * - Acesso e inserção de elementos rápidos
                 *
                 * Uso comum: cookies e qualquer tipo de acesso value-key
                 *
                 * Principais maps:
                 *      - HashMap: mais rápido e não ordenado
                 *      - TreeMap: mais lento e ordenado pelo compareTo
                 *      - LinkedHashMap: velocidade média e elementos adicionados na ordem em que são colocados
                 *
                 * Métodos importantes:
                 *      - put(key, value) -> adiciona elemento
                 *      - remove(key) -> remove o elemento da key passada
                 *      - containsKey(key) -> a chave existe?
                 *      - get(key) -> recupera o elemento pela chave
                 *              - Baseados em equals e hashCode. Se não existe, comparação por ponteiros
                 *
                 * Não existe ordem! Contudo, utilizando métodos como keySet(), que retorna um Set(), o que vai definir
                 * a ordem é o tipo do Map.
                 */

                // Lembrando que Strings possuem compareTo nativo, então não precisamos implementar
                /*
                Map<String, String> cookies = new TreeMap<>();

                cookies.put("username", "Maria");
                cookies.put("email", "maria@gmail.com");
                cookies.put("phone", "99711122");

                System.out.println("ALL COOKIES: ");*/

                /*
                keySet() retorna uma coleção Set de todas as keys. Podemos usar da seguinte forma:

                for(String key : cookies.keySet())
                {
                    System.out.println(key + ": " + cookies.get(key));
                }
                */

                Map<String, Integer> votes = new LinkedHashMap<>();

                try(BufferedReader bf = new BufferedReader(new FileReader("D:\\Estudos\\development\\sections_php-java\\section_java\\java-generic-set-map\\src\\Files\\candidatos.csv")))
                {
                    String line = bf.readLine();

                    while(line != null)
                    {
                        String[] fields = line.split(",");

                        String name = fields[0];
                        int votos = Integer.parseInt(fields[1]);

                        // Se existir uma quantidade de votos com a key name, executa
                        if(votes.containsKey(name))
                        {
                            // Inclua no conteúdo da chave name o incremento da quantidade de votos
                            votes.put(name, votos += votes.get(name));
                        }
                        else
                        {
                            votes.put(name, votos);
                        }

                        line = bf.readLine();
                    }

                    for(String key : votes.keySet())
                    {
                        System.out.println(key + ": " + votes.get(key));
                    }
                }
                catch(IOException error)
                {
                    System.out.println(error);
                }

                break;
            }
            default:
            {
                System.out.println("Indefined value");
            }
        }

        input.close();
    }

    /*
     * source -> covariância (GET is OK, PUT isn't OK)
     * destiny -> contravariância (GIT isn't OK, PUT is OK)
     */
    public static void copy(List<? extends Number> source, List<? super Number> destiny) {
        for(Number number : source) {
            destiny.add(number);
        }
    }

    public static void printList(List<?> list) {
        for(Object obj : list) {
            System.out.print(obj + " ");
        }
        System.out.println();
    }
}