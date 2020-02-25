package Zad2;

import java.util.Objects;
import java.util.Scanner;

public class Zad2 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        String resultString;

        boolean fiveDigits = number >= 10000 && number <= 99999;
        if (fiveDigits) {
            String numberText = Integer.toString(number);
            String numberTextReverse = new StringBuilder(numberText).reverse().toString();

            boolean isPalindrome = Objects.equals(numberText, numberTextReverse);
            resultString = String.format("The numbers are%s palindromes", isPalindrome ? "" : " not");
        } else {
            resultString = ("Number is NOT five digits long!");
        }

        System.out.println(resultString);
    }
}