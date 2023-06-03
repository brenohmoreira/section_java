/*
 * Veremos enumeração e composição:
 * 
 * # Enumeração:
 * Tipo especial para especificar de forma literal um conjunto de constantes relacionadas
 * Palavra chave: enum
 * 
 * Vantagem: melhor semântica, código mais legível e auxiliado pelo compilador
 * 
 * - Usado por exemplo para 
 * 
 * Eventualmente, vamos querer que o usuário digite um valor para a ENUM e esse valor virá como String, para converter:
 * Ex -> OrderStatus enteredByUser = OrderStatus.valueOf("DELIVERED"); (== OrderStatus.DELIVERED;)
 * 
 * ** instanciação de enums não precisam do new
 * 
 * # Composição:
 * Em um sistema POO, de certa forma, "tudo" é objeto (tudo gira em torno de objetos)
 * Por questão de design, tais como: organização, flexibilidade, reuso, delegação, etc, há várias categorias de classes:
 * Entities -> Entidades do software (Clientes, pedidos, etc)
 * Services -> Representam serviços
 * Views -> Telas do sistema
 * Controllers -> Intermediação entre as views e o sistema
 * Repositories -> Models, operações com banco de dados
 * 
 * Composição é um tipo de associação que permite que um objeto contenha outro (relação "tem-um" e relação "tem-vários")
 * Fazemos a relação "tem-um" pegando uma classe e, nesta classe, como atributo, receber um objeto de outra classe
 * Fazemos a relação "tem-vários" da mesma forma que "tem-um", mas salvando em uma lista.
 * Não podemos fazer um setter para listas, pois isso seria TROCAR a lista.
 * 
 * OBS: StringBuilder (classe) -> forma não manual de montar uma String muito grande (usado no toString) - é mais performatico
 * 
 * StringBuilder sb = new StringBuilder();
 * 
 * sb.append(variavel + "texto" + "variavel", etc);
 * 
 * return sb.toString();
 */

import entities.Order;
import entities.enums.OrderStatus;
import java.util.Date;

public class App {
    public static void main(String[] args) throws Exception {
        Order order = new Order(10, new Date(), OrderStatus.PENDING_PAYMENT);

        System.out.printf("" + order);
    }
}
