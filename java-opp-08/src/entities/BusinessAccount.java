package entities;

public class BusinessAccount extends Account {
    private Double loanLimit;

    public BusinessAccount() {
        // Se colocarmos alguma lógica futuramente em base constructor Account, será executado aqui também
        super();
    }

    public BusinessAccount(Integer number, String holder, Double balance, Double loanLimit) {
        // Chama o construtor da classe pai (Account) passando number, holder e loanLimit como parâmetros
        super(number, holder, loanLimit);

        this.loanLimit = loanLimit;
    }

    public Double getLoanLimit() {
        return loanLimit;
    }

    public void setLoanLimit(Double loanLimit) {
        this.loanLimit = loanLimit;
    }

    /*
     * Podemos chamar o super para acessar métodos da superclasse. Dessa forma, iremos fazer a operação de withdraw
     * da Account e descontar mais dois.
     * A palavra final no método não permite que ele seja sobreposto em uma subclasse de BusinessAccount. Geralmente,
     * usa-se a palavra final em métodos sobrepostos, pois múltiplas sobreposições podem gerar confusões e inconsistências.
     */

    @Override
    public final void withdraw(Double amount) {
        super.withdraw(amount);
        balance -= 2;
    }

    public void loan(Double amount) {
        if(amount <= loanLimit) {
            deposit(amount);
        }
        else {
            System.out.println("Limite insuficiente");
        }
    }
}
