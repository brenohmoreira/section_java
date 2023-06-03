package entities;

public class Account {
    private int numberAccount;
    private String nameOwner;
    private double balance;

    // Construtores (sobrecarga)

    public Account()
    {
    }

    // Depositando algum valor inicial
    public Account(int numberAccount, String nameOwner, double initDeposit)
    {
        this.numberAccount = numberAccount;
        this.nameOwner = nameOwner;
        this.deposit(initDeposit);
    }

    // Não depositando nada inicialmente (se não declarar valor para initDeposit, por padrão vem 0.00)
    public Account(int numberAccount, String nameOwner)
    {
        this.numberAccount = numberAccount;
        this.nameOwner = nameOwner;
    }

    // Demais métodos

    public void deposit(double amount)
    {
        this.balance += amount;
    } 

    public void withdraw(double amount)
    {
        this.balance -= amount;
    }

    // Métodos getters e setters

    public void setNameOwner(String nameOwner)
    {
        this.nameOwner = nameOwner;
    }

    public String getNameOwner()
    {
        return this.nameOwner;
    }

    public double getBalance()
    {
        return this.balance;
    }

    public int getNumberAccount()
    {
        return this.numberAccount;
    }

    // toString

    public String toString()
    {
        return this.numberAccount + ", " + this.nameOwner + ". Value deposited: " + this.balance;
    }
}
