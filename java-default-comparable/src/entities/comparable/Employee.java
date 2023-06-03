package entities.comparable;

/*
 * Implementei Comparable<Employee> e agora ela é comparável. Para isso, devemos seguir o contrato de Comparable, que é
 * o método compareTo.
 * Esse método pode retornar um valor negativo, 0 ou um valor positivo, ordenando com base numérica ou alfabética.
 * "maria".compareTo("alex") -> retorna -12 por exemplo, pois alex vem antes na ordem alfabética
 * "alex".compareTo("maria") -> retorna +12 por exemplo, pois alex vem antes na ordem alfabética
 * "maria".compareTo("maria") -> retorna 0, pois são iguais
 */

public class Employee implements Comparable<Employee>{
    private String name;
    private Double salary;

    public Employee(String name, Double salary)
    {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    /*
     * O sort utiliza esse método no automático
     */

    @Override
    public int compareTo(Employee other) {
        // Ordenando por nome
        return name.compareTo(other.getName());
    }
}
