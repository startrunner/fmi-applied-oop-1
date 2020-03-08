public class Main {
    public static double calculateNapierConstant() {
        final double AccuracyConstant = 1e-8;

        double result = 2;

        double previousAddend = 0;
        double currentDenominator = 1;
        double currentAddend = 1;

        for (int i = 2; Math.abs(currentAddend - previousAddend) > AccuracyConstant; i++) {
            currentDenominator *= i;
            previousAddend = currentAddend;
            currentAddend = 1 / currentDenominator;

            result += currentAddend;
        }

        return result;
    }

    public static void main(String[] args) {
        double napierConstant = calculateNapierConstant();
        System.out.println("Calculated napier constant: " + napierConstant);
    }
}
