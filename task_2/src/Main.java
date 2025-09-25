import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Выберите валюту для конвертации");
        UsdRates[] currencyList = UsdRates.values();
        for (int i = 0; i < currencyList.length; ++i) {
            System.out.println(i + " - " + currencyList[i]);
        }
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice < 0 || choice > currencyList.length) {
            System.out.print("Введите число от 0 до " + currencyList.length + " : ");
            while (!scanner.hasNextInt()) {
                System.out.println("Введите число от 0 до " + currencyList.length + " : ");
                scanner.next();
            }
            choice = scanner.nextInt();
        }
        double amount = -1;
        while (!(amount > 0)) {
            System.out.print("Введите сумму в " + currencyList[choice] + " : ");
            while (!scanner.hasNextInt()) {
                System.out.println("Введите сумму в " + currencyList[choice] + " : ");
                scanner.next();
            }
            amount = scanner.nextInt();
        }

        for (int i = 0; i < currencyList.length; ++i) {
            if (i == choice) continue;
            System.out.println(String.format("%.2f",amount) + " " + currencyList[choice] + " = "
                    + String.format("%.2f", CurrencyConverter.exchange(currencyList[choice], currencyList[i], amount))
                    + " " + currencyList[i]);
        }
    }
}