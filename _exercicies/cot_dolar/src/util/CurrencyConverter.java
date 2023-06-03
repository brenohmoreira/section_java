package util;

public class CurrencyConverter {
    public static double converter(double cotacao, double dolarValue)
    {
        return ((dolarValue * 0.06) + dolarValue) * cotacao;
    }
}
