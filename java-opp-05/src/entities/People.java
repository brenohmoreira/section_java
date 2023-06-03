package entities;

public class People {
    private String name;
    private int age;

    public People()
    {
        System.out.println("Contruct method called");
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public int getAge()
    {
        return this.age;
    }
}
