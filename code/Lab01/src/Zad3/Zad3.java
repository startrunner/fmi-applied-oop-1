package Zad3;

import java.util.Scanner;

public class Zad3 {
    private static void doEncryptionSwap(char[] chars) {
        char swap;

        swap = chars[2];
        chars[2] = chars[0];
        chars[0] = swap;

        swap = chars[3];
        chars[3] = chars[1];
        chars[1] = swap;
    }

    private static char[] getFourDigits(int data) {
        String text = Integer.toString(data);
        if (text.length() > 4)
            throw new IllegalArgumentException("Data cannot be longer than 4 chars.");

        while (text.length() < 4)
            text = "0" + text;

        return text.toCharArray();
    }

    static int encrypt(int data) {
        char[] chars = getFourDigits(data);

        for (int i = 0; i < chars.length; i++) {
            int digit = chars[i] - '0';
            digit = (digit + 7) % 10;
            chars[i] = (char) (digit + '0');
        }

        doEncryptionSwap(chars);
        int encryptedData = Integer.parseInt(new String(chars));
        return encryptedData;
    }

    static int decrypt(int encryptedData) {
        char[] chars = getFourDigits(encryptedData);

        doEncryptionSwap(chars);

        for (int i = 0; i < chars.length; i++) {
            int encryptedDigit = chars[i] - '0';

            int decryptedDigit;
            if (encryptedDigit < 7) decryptedDigit = encryptedDigit + 3;
            else decryptedDigit = encryptedDigit - 7;

            chars[i] = (char) (decryptedDigit + '0');
        }

        int decryptedData = Integer.parseInt(new String(chars));
        return decryptedData;
    }

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        int data = scanner.nextInt();

        int encrypted = encrypt(data);
        int decrypted = decrypt(encrypted);

        System.out.printf("Encrypted: %d\n", encrypted);
        System.out.printf("Decrypted: %d\n", decrypted);
    }
}
