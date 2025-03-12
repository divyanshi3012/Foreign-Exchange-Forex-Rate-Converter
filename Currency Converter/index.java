import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {

    // Placeholder for exchange rates (these would be fetched dynamically in a real scenario)
    private static Map<String, Double> exchangeRates = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Sample exchange rates
        exchangeRates.put("USD_TO_INR", 82.50);
        exchangeRates.put("INR_TO_USD", 0.0121);
        exchangeRates.put("USD_TO_EUR", 0.85);
        exchangeRates.put("EUR_TO_USD", 1.17);
        exchangeRates.put("INR_TO_EUR", 0.0103);
        exchangeRates.put("EUR_TO_INR", 97.25);

        System.out.println("Welcome to the Currency Converter!");

        // Take input for base currency and target currency
        System.out.print("Enter the base currency (USD, INR, EUR): ");
        String baseCurrency = scanner.next().toUpperCase();

        System.out.print("Enter the target currency (USD, INR, EUR): ");
        String targetCurrency = scanner.next().toUpperCase();

        // Take input for the amount to convert
        System.out.print("Enter the amount you want to convert: ");
        double amount = scanner.nextDouble();

        // Convert the amount
        double convertedAmount = convertCurrency(baseCurrency, targetCurrency, amount);

        if (convertedAmount != -1) {
            System.out.printf("%.2f %s = %.2f %s\n", amount, baseCurrency, convertedAmount, targetCurrency);
        } else {
            System.out.println("Invalid currency combination.");
        }

        scanner.close();
    }

    // Function to convert the currency based on base and target currency
    private static double convertCurrency(String baseCurrency, String targetCurrency, double amount) {
        String key = baseCurrency + "_TO_" + targetCurrency;
        if (exchangeRates.containsKey(key)) {
            double rate = exchangeRates.get(key);
            return amount * rate;
        }
        return -1; // Invalid currency pair
    }

}
