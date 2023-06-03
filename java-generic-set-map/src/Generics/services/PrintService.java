package Generics.services;

import java.util.ArrayList;
import java.util.List;

// Pode chamar <Nome> de qualquer no lugar de "nome". É um tipo genérico
public class PrintService<Type> {
    private List<Type> list = new ArrayList<>();

    public void addValue(Type value)
    {
        list.add(value);
    }

    public Type first()
    {
        if(list.isEmpty())
        {
            throw new IllegalStateException();
        }

        return list.get(0);
    }

    public void print()
    {
        System.out.print("[");

        if(!list.isEmpty())
        {
            System.out.print(list.get(0));
        }

        for(int i = 1; i < list.size(); i++)
        {
            System.out.print(", " + list.get(i));
        }

        System.out.println("]");
    }
}

/*
 * Você pode fazer métodos genéricos
 *
 * Tipo T pode extender a Comparable para ser utilizado o compareTo.
 * O método recebe uma lista de tipo T e define o índice 0 como o valor máximo. Depois, percorre a lista toda, comparan
 * do e redefinindo o valor máximo por toda lista, para enfim obter de fato o valor máximo (max de tipo T) e depois re
 * tornar T max;
 *
 * public static <T extends Comparable<T>> T max(List<T> list) {
 *      T max = list.get(0);
 *
 *      for(T item : list) {
 *          if(item.compareTo(max) > 0) {
 *              max = item;
 *          }
 *      }
 *
 *      return max;
 * }
 */