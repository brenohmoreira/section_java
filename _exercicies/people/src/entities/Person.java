package entities;

public abstract class Person {
    protected String name;
    protected Double anualBalance;

    public Person() {

    }

    public Person(String name, double anualBalance) {
        this.name = name;
        this.anualBalance = anualBalance;
    }

    public abstract Double calculeTax();

    public String getName() {
        return name;
    }

    public Double getAnualBalance() {
        return anualBalance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAnualBalance(double anualBalance) {
        this.anualBalance = anualBalance;
    }

    public String toString() {
        return name + ": $ " + calculeTax() + "%n";
    }
}
