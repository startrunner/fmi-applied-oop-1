import java.util.*;

public class Main {
    static List<Double> calculatePIApproximations() {
        final double PIUpperBound = 3.14159;
        List<Double> result = new ArrayList<>();

        double pi = 4;
        for (int i = 1; i % 2 == 1 || pi < PIUpperBound; i++) {
            int currentCoefficient = 1 - 2 * (i % 2);
            int currentDenominator = 1 + 2 * i;
            double currentAddend = currentCoefficient * (4.0 / currentDenominator);
            pi += currentAddend;

            result.add(pi);
        }

        return result;
    }

    public static void main(String[] args) {
        List<Double> approximations = calculatePIApproximations();
        double pi = approximations.get(approximations.size() - 1);

        System.out.println("Best approximation of PI: " + pi);

        printTable(approximations);
    }

    private static void printTable(List<Double> approximations) {
        final int LeftColumnWidth = 8;
        final int RightColumnWidth = 22;

        String lineSeparator = "———————————————————————————————";
        System.out.printf("*%s*\n", lineSeparator);

        String leftHeader = Pad.left("Count", LeftColumnWidth);
        String rightHeader = Pad.right("PI", RightColumnWidth);
        System.out.printf("|%s|%s|\n", leftHeader, rightHeader);

        for (int i = 0; i < approximations.size(); i++) {
            System.out.printf("|%s|\n", lineSeparator);
            String leftCell = Pad.left(i + 1, LeftColumnWidth);
            String rightCell = Pad.right(approximations.get(i), RightColumnWidth);

            System.out.printf("|%s|%s|\n", leftCell, rightCell);
        }
        System.out.printf("*%s*\n", lineSeparator);
    }


}

class Pad {
    public static String left(Object object, int length) {
        String text = object.toString();
        return padding(text.length(), length) + text;
    }

    public static String right(Object object, int length) {
        String text = object.toString();
        return text + padding(text.length(), length);
    }

    private static String padding(int textLength, int desiredLength) {
        if (textLength >= desiredLength)
            return "";

        var builder = new StringBuilder();
        while (builder.length() + textLength < desiredLength)
            builder.append(' ');

        String padding = builder.toString();
        return padding;
    }

    private Pad() {
    }
}