package entities;

public class Account {
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
