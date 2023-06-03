package entities.defaultmethods.service;

public class USAInterestService implements InterestService{
    private Double interestRate;

    public USAInterestService(Double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public double getInterestRate() {
        return interestRate;
    }
}
