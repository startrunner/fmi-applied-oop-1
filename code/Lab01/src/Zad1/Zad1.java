package Zad1;

import java.util.Scanner;

public class Zad1 {
    public static double fahrenheitToCelsius(double fahrenheit) {
        double celsius = 5.0 / 9.0 * (fahrenheit - 32);
        return celsius;
    }

    public static double celsiusToFahrenheit(double celsius) {
        double fahrenheit = 9.0 / 5.0 * celsius + 32;
        return fahrenheit;
    }

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        String temperatureAndUnit = scanner.nextLine().trim();

        int temperature = Integer.parseInt(temperatureAndUnit.substring(0, temperatureAndUnit.length() - 1));
        char unit = Character.toLowerCase(temperatureAndUnit.charAt(temperatureAndUnit.length() - 1));

        if (unit == 'c') {
            Double fahrenheit = celsiusToFahrenheit(temperature);
            System.out.printf("That is %.2fF!", fahrenheit);
        } else if (unit == 'f') {
            double celsius = fahrenheitToCelsius(temperature);
            System.out.printf("That is %.2fC", celsius);
        } else {
            System.out.printf("Unit '%s' is invalid!", unit);
        }
    }
}
