package entities;

public class LegalPerson extends Person {
    private Integer employeeNumber;

    public LegalPerson() {
        super();
    }

    public LegalPerson(String name, Double price, Integer employeeNumber) {
        super(name, price);
        this.employeeNumber = employeeNumber;
    }

    public Integer getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(Integer employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    @Override
    public Double calculeTax() {
        double tax = 0.16, result = 0;

        if(employeeNumber > 10)
        {
            tax = 0.14;

        }

        result = anualBalance * tax;

        return result;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
