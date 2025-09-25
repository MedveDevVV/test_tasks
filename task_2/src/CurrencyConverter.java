public class CurrencyConverter {
    public static double exchange(UsdRates from, UsdRates to, double amount) {
        return (amount * from.getRate()) / to.getRate();
    }
}
