package entities;

/*
 * Utilizando "abstract" a classe "Account" não poderá ser instanciada e, dessa forma, não existirá mais as contas do
 * tipo comum, apenas os tipos que herdam atributos e métodos de Account e não são abstratas.
 * Mas, se não podemos instanciar, para que criar? Por dois motivos:
 * - Reuso
 * - Polimorfismo
 *
 * Demo: imagine que você queira somar o saldo de todas as contas ou depositar dez reais em todas as contas.
 *
 *      List<Account> list = new ArrayList<>();
 *
 *      list.add(new BusinessAccount(1001, "Breno", 1000.0, 400.0));
 *      list.add(new SavingAccounts(1002, "Paulo", 2000.0, 000.1));
 *
 *      for (Account acc : list) {
 *          acc.withdraw(10.0);
 *      }
 *
 */

public abstract class Account {
    private Integer number;
    private String holder;
    // Para conseguir ser usada pelas classes filhas
    protected Double balance;

    public Account(){
    }

    public Account(Integer number, String holder, Double balance) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
    }

    public Integer getNumber() {
        return number;
    }

    public String getHolder() {
        return holder;
    }

    public Double getBalance() {
        return balance;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public void withdraw(Double amount) {
        balance -= amount;
    }

    public void deposit(Double amount) {
        balance += amount;
    }
}
