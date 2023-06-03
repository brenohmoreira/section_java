package entities;

public class NaturalPerson extends Person {
    private Double healthExpenses;

    public NaturalPerson() {
        super();
    }

    public NaturalPerson(String name, double anualBalance, double healthExpenses) {
        super(name, anualBalance);
        this.healthExpenses = healthExpenses;
    }

    public Double getHealthExpenses() {
        return healthExpenses;
    }

    public void setHealthExpenses(double healthExpenses) {
        this.healthExpenses = healthExpenses;
    }

    @Override
    public Double calculeTax() {
        double tax = 0, result = 0;

        if(anualBalance >= 20000.0)
        {
            tax = 0.25;

        }
        else
        {
            tax = 0.15;

        }

        if(healthExpenses > 0)
        {
            result = (anualBalance * tax) - (healthExpenses * 0.5);
        }

        return result;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
