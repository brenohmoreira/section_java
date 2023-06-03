package entities.defaultmethods.service;

import java.security.InvalidParameterException;

public interface InterestService {
    double getInterestRate();

    // Esse método existe para todos que implementam a classe. Ela só pode, todavia, utilizar métodos que já existem nela
    default double payment(double amount, int months) {
        if (months < 1) {
            throw new InvalidParameterException("Month invalid");
        }

        return amount * Math.pow(1 + getInterestRate() / 100, months);
    }
}
