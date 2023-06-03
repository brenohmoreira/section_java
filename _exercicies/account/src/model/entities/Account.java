package model.entities;

import model.exception.DomainException;

public class Account {
    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account() {
    }

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(Double amount) {
        balance += amount;
    }

    public void withdraw(Double amount) throws DomainException {
        if(amount <= withdrawLimit && amount <= balance)
        {
            balance -= amount;
        }
        else if (amount > withdrawLimit)
        {
            throw new DomainException("Quantity exceeds the limit");
        }
        else if (amount > balance)
        {
            throw new DomainException("You don't have money to withdraw");
        }
        else
        {
            throw new DomainException("Undefined error");
        }
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

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }
}
