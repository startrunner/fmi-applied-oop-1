package Zad4;

import java.util.ArrayList;
import java.util.Scanner;

public class Zad4 {
    public static String decode(int n) throws Exception {
        char[] chars = new char[4];

        for (int i = 3, number = n; i >= 0; i--) {
            int pow4 = (int) Math.pow(4, i);
            int characterCode = number / n;

            char character;
            switch (characterCode) {
                case 0:
                    character = 'A';
                    break;
                case 1:
                    character = 'C';
                    break;
                case 2:
                    character = 'G';
                    break;
                case 3:
                    character = 'T';
                    break;
                default:
                    throw new Exception("???");
            }

            chars[i] = character;
            number %= n;
        }

        return new String(chars);
    }

    public static void main(String[] args) throws Exception {
        var scanner = new Scanner(System.in);
        int stamat = scanner.nextInt();
        System.out.println(decode(stamat));
    }
}
