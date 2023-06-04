import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        /*
         * Stream: solução para processar sequências de dados de forma:
         *      - Declarativa (iteração interna: escondida do programador)
         *      - Parallel-friendly (imutável -> thread safe)
         *      - Sem efeitos colaterais
         *      - Sob demanda (lazy evaluation)
         *      - Acesso sequencial (não há indices)
         *      - Single-use: só pode ser "usada" uma vez
         *
         * Pipeline: operações em streams retornam novas streams. Então é possível criar uma cadeia de operações. É
         * composto por zero ou mais operações intermediárias e ao menos uma operação terminal.
         *      - Intermediária: Produz novas streams. Ela é lazy, só executa quando uma operação terminal é invocada.
         *          Operações intermediárias -> filter, map, flatmap, peek, distinct, sorted, skip, limit (*)
         *      - Terminal: Produz um objeto no-stream (coleções ou outro). Ela determina o final do processamento da
         *      stream.
         *          Operações terminais -> forEach, toArray, collect, min, max count, etc.
         *      Note como as intermediárias, de forma geral, processam e tratam os dados, fazendo outra stream. As
         *      terminais, contudo, normalmente entregam a Stream.
         *
         * (*): short-circuit. Possui algum predicado dentro de si, que quando satisfeito, a operação termina.
         *
         * Uma stream é criada a partir de uma fonte de dados, como coleções por exemplo. Para criar streams com base em
         * coleções, podemos utilizar stream() ou parallelStream(). Há outras formas: Stream.of, Stream.ofNullable e
         * Stream.iterate.
         */

        List<Integer> list = Arrays.asList(1, 2, 3, 4);

        // Criando Stream a partir de uma lista
        Stream<Integer> st1 = list.stream();
        Stream<Integer> st2 = list.stream().map(x -> x * 10);

        // Operação terminal toArray() passa a Stream para Array. Arrays.toString permite que isso seja ok para println.
        System.out.println(Arrays.toString(st1.toArray()));

        // Utilizando uma operação intermediária
        System.out.println(Arrays.toString(st2.toArray()));

        // Podemos criar a stream já passando os valores com .of
        Stream<String> st3 = Stream.of("Breno", "Mariana", "Enzo", "Nome genérico");
        System.out.println(Arrays.toString(st3.toArray()));

        /*
         * Operação com iterate. O primeiro valor indica o início, no caso, começa com 0. A cada índice, armazena o valor
         * passado em x e soma x + 2 para o próximo índice.
         */
        Stream<Integer> st4 = Stream.iterate(0, x -> x + 2);

        // É uma stream potencialmente infinita, então usaremos limit para limitar o número de valores.
        System.out.println(Arrays.toString(st4.limit(10).toArray()));

        /*
         * Começa com uma array indicando o valor na posição 0 (0L) e na posição 1 (1L)
         * A cada próxima casa, teremos p[1] como próximo p[0] e p[1] como p[0] + p[1] antigo
         * Colocando em termos práticos
         *
         * array([0] 0, [1] 1)
         * array([0] 1, [1] 0 + 1 = 1)
         * array([0] 1, [1] 1 + 1 = 2)
         * array([0] 2, [1] 1 + 2 = 3)
         * array([0] 3, [1] 2 + 3 = 5)
         *
         * Note o fibonacci se formando no índice 0
         *
         * Por isso usamos o map, para retornar para cada iteração, a posição 0
         */
        Stream<Long> fibonacci = Stream.iterate(new Long[] {0L, 1L}, p -> new Long[] { p[1], p[0] + p[1] }).map(p -> p[0]);

        System.out.println(Arrays.toString(fibonacci.limit(30).toArray()));

        Stream<Integer> st5 = Stream.of(1, 1, 3, 5, 9);

        // Queremos fazer um somatório. Para isso, utilizamos a operação terminal reduce para aplicar operações em todos elementos
        /*
         * Somatório começa com 0, que vai para x e o primeiro elemento para y. Então:
         * 0, [1] -> 0 + [1]
         *
         * O próximo vai armazenar o resultado da antiga em x e pegar o próximo elemento em y, fazendo o somatório novamente
         */
        int sum = st5.reduce(0, (x, y) -> x + y);
        // Mesma coisa. Porém, note que na multiplicação o início deve ser 1, pois 0 fará a multiplicação total ser igual a 0
        int mult = st5.reduce (1, (x, y) -> x * y);

        List<Integer> pipelineDemo = Arrays.asList(1, 2, 3, 4, 5, 6);

        // Transforma uma lista em stream, pega todos os elementos que satisfaçam x -> x % 2 == 0 (par) e multiplica cada por dez, no final transforma em lista denovo
        List<Integer> newList = pipelineDemo.stream().filter(x -> x % 2 == 0).map(x -> x * 10).collect(Collectors.toList());
    }
}