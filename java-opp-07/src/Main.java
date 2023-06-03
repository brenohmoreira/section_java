/*
 * Herança e polimorfismo
 *
 * Herança: Tipo de associação de permite que uma classe herde todos os dados e comportamentos de outro.
 * As vantagens compreendem o campo do reuso e do polimorfismo, que falarei depois.
 *      Sintaxe: class 1 extends 2
 *      Classe 1 herda os atributos e métodos da classe 2
 *              Usa-se:
 *              - Quando uma classe possui atributos/métodos em comum com outra classe
 *                      Upcasting: Casting da subclasse para a super classe
 *                      - Uso comum: polimorfismo
 *
 *                      Downcasting: Casting da super classe para a subclasse
 *                      - Palavra instanceof
 *                      - Uso comum: métodos que recebem parâmetros genéricos (equals, por exemplo)
 *
 * Polimorfismo: Objetos do mesmo tipo que são instânciados por classes diferentes que, ao chamar métodos sobrescritos,
 * possuem comportamento diferente.
 *
 */

import entities.Account;
import entities.BusinessAccount;
import entities.SavingAccounts;

public class Main {
    public static void main(String[] args) {
        Account acc = new Account(1001, "Alex", 0.0);
        BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0.0, 500.0);

        // Upcasting: Dizer que um objeto da classe pai é igual a um objeto da classe filha

        Account acc1 =  bacc;

        // Poderei usar todos os métodos e atributos de Account, mas não poderei usar os dos filhos (como se não existissem)
        Account acc2 = new BusinessAccount(1003, "Pedro", 0.0, 1000.0);
        Account acc3 = new SavingAccounts(1004, "Breno", 0.0, 2000.0);

        // Downcasting: Dizer que um objeto da classe filha é igual a um objeto da classe pai

        // acc1 não possui métodos e atributos que bacc1 possui, então precisamos usar casting
        BusinessAccount bacc1 = (BusinessAccount) acc1;

        System.out.printf("" + bacc1.getLoanLimit());

        /*
         * Podemos usar o casting dessa forma se estivermos tratando objetos pai e filho, mas não podemos com irmãos.
         * Assim sendo, não é permitido fazer por exemplo:
         * BusinessAccount bacc2 = (BusinessAccount) acc3;
         * Acontece por que acc3 e bacc2 vêm de classes irmãs. Para garantir que as classes não são irmãs, podemos:
         */

        // se o que estiver em acc3 for um objeto que é instância de BusinessAccount, retorna true
        if(acc3 instanceof BusinessAccount)
        {
            BusinessAccount bacc3 = (BusinessAccount) acc3;
        }
        else
        {
            System.out.print("\nA classe BusinessAccount e SavingAccount são irmãs e, portanto, não podem fazer downcasting\n\n");
        }

        if(acc3 instanceof SavingAccounts)
        {
            SavingAccounts sacc = (SavingAccounts) acc3;
        }

        // POLIMORFISMO

        // Mesmo tipo, mas instâncias diferentes.
        Account x = new Account(2000, "Rafael", 500.0);
        Account y = new SavingAccounts(2001, "Paulatejando", 500.0, 20.0);

        // Mesmo tipo, chamando o mesmo método, mas retorno diferente.
        x.withdraw(50.0);
        y.withdraw(50.0);

        // OBS: O compilador não sabe para qual classe o withdraw está sendo feito, ele apenas está fazendo. (Sabe apenas que são duas variáveis do tipo Account).
        // A associação do tipo específico com o genérico (classe) é feita em tempo de execução (upcasting)
        System.out.printf("%.2f (x) e %.2f (y)", x.getBalance(), y.getBalance());
    }
}