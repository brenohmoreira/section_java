package entities;

// Se usarmos final, não poderá ser criado subclasses que venham de SavingAccounts
public final class SavingAccounts extends Account {
    private Double interestRate;

    public SavingAccounts() {
        super();
    }

    public SavingAccounts(Integer number, String holder, Double balance, Double interestRate) {
        super(number, holder, balance);

        this.interestRate = interestRate;
    }

    public void updateBalance() {
        balance += balance * interestRate;
    }

    /*
     * Sobreposição é quando reescrevemos um método de uma super classe na subclasse
     * Fazemos isso quando queremos definir um comportamento específico daquele método para a subclasse
     * É fortemente recomendável que se use a anotação @Override em um método sobrescrito, facilitando a leitura e com
     * preensão do código, além de avisar o compilador (boa prática).
     */

    @Override
    public void withdraw(Double amount) {
        balance -= amount + 5;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }
}
