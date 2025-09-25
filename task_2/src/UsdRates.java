public enum UsdRates {
    USD(1.0),
    EUR(1.171),
    RUR(0.011963),
    JPY(0.006761),
    CNY(0.1406);

    private final double rate;
    UsdRates(double rate) {
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }
}
