package Zad5;

public class Zad5 {
    public static void main(String[] args) {
        final var out = System.out;
        char[] chars = "ABCabc012$*+/ ".toCharArray();
        for (char c : chars) {
            out.printf("Integral representation of '%s': %d", c, (int) c);
            out.println();
        }
    }
}
