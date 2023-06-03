package entities.formas;

import entities.enums.Color;

// Se há um método abstrato dentro em uma classe, essa classe, por lei, deve ser abstrata também
public abstract class Shape {
    private Color color;

    public Shape() {
    }

    public Shape(Color color) {
        this.color = color;
    }

    /*
     * Perceba que não podemos ter a area do ente sem saber qual é o ente, então de forma alguma esse método pode ser
     * chamado direto por Shape, mas sim pelos filhos que serão as formas.
     */
    public abstract double area();

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
