/*
 * Observação: Interfaces a partir do JAVA 8, possui Default Methods
 *
 * Interface é um tipo que define um conjunto de operações que uma classe deve implementar. É como se fosse uma classe
 * abstrata apenas com métodos abstratos. Contudo, se é parecido, por que usar interfaces? Veremos.
 * - Contrato que classes devem obedecer
 * - Para criar sistemas com baixo acoplamento e flexíveis: acontece que algumas vezes o seu software vai precisar de
 * manutenção. Para evitar que a pessoa fazendo a manutenção precise ficar mudando vários pontos da composição, usamos
 * interface. Não é recomendável que a própria classe instancie suas dependências (depende de quem), utilizamos inter
 * faces e injeção de dependência por meio de construtores para evitar esse problema (isso tudo se chama inversão de
 * controle, tratando-se de tirar de uma classe a necessidade de instanciar suas próprias dependências e é, de forma
 * geral, uma ótica prática para construir sistemas de baixo acoplamento e que, portanto, não precisem em casos de
 * mudanças, serem refatorados em mais de um ponto. A injeção de dependência é uma forma de fazer a inversão de contro
 * le).
 *
 * Aspectos comuns herdar x interface (cumprir contrato)
 *      - Relação é-um
 *      - Generalização / especialização
 *      - Polimorfismo
 *
 * Diferença fundamental herdar x interface
 *      - Objetivo herdar: reuso
 *      - Objetivo interface: cumprir contrato
 *
 * Podemos usar ambas simultaneamente. Basta criar uma classe abstrata com os atributos em comum (não existem atributos
 * em interfaces) e a interface com o contrato, aí as classes específicas que herdam uma classe pai com os atributos de
 * sejados que é abstrato e implementa a interface. Por ser abstrato, ele não precisa cumprir o contrato, os filhos pre
 * cisam.
 *
 * Algumas classes úteis (Collections, por exemplo) não aceitam variáveis/objetos de tipos referência. Collections.sort
 * por exemplo, só consegue ordenar listas de tipo comparable. Isso acontece quando você tenta ordenar uma lista sem de
 * finição clara do que deve ordenar. Digamos que você queira ordenar uma lista com objetos do tipo Employee, e aí? A
 * lista deve ser ordenada com base em salary ou name? As wrapper classes já são comparable, mas no caso de Employee,
 * você precisa torná-la comparable. É possível fazer isso implementando (implement) uma interface comparable.
 */

import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Entre com os dados do contrato: ");

        System.out.print("Número contrato: ");
        int number = Integer.parseInt(input.nextLine());

        System.out.print("Data (dd/mm/yyyy): ");
        LocalDate date = LocalDate.parse(input.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.print("Valor do contrato: ");
        double totalValue = Double.parseDouble(input.nextLine());

        Contract contract = new Contract(number, date, totalValue);

        System.out.print("Digite o número de parcelas: ");
        int n = Integer.parseInt(input.nextLine());

        // OnlinePaymentService onlinePaymentService = new PaypalService() -> upcasting
        ContractService contractService = new ContractService(new PaypalService());

        contractService.processContract(contract, n);

        System.out.println("Parcelas: ");

        for(Installment installment : contract.getInstallments()) {
            System.out.println(installment);
        }

        input.close();
    }
}