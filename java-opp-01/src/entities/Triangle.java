package entities;

public class Triangle {

    // Padrão de nome de constante é tudo maíusculo
    final public int SIDES = 3;

    public double[] sides_triangle = new double[(int)SIDES];

    public double calcule_area()
    {
        double p = sides_triangle[0] + sides_triangle[1] + sides_triangle[2];
        
        return Math.sqrt(p * (p - sides_triangle[0]) * (p - sides_triangle[1]) * (p - sides_triangle[2]));
    }
    
}
