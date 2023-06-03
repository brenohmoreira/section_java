package entities;

public class Employee
{
    private Integer id;
    private String name;
    private Double salary;

    public Employee(Integer id, String name, Double salary)
    {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Integer getId()
    {
        return this.id;
    }

    public String getName()
    {
        return this.name;
    }

    public Double getSalary()
    {
        return this.salary;
    }

    public void salaryIncrease(double percent)
    {
        this.salary = this.salary * (percent / 100) + this.salary;
    }

    public String toString()
    {
        return "" + this.id + ", " + this.name + ", R$ " + this.salary + "\n";
    }
}