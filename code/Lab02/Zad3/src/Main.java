public class Main {
    static double calculatePowerOfNapierConstant(double power) {
        final double AccuracyConstant = 0.001;

        double result = 0;

        double previousAddend = 0, currentAddend = 1;
        double currentDenominator = 1, currentNominator = 1;
        for (int i = 1; Math.abs(currentAddend - previousAddend) > AccuracyConstant; i++) {
            currentAddend = currentNominator / currentDenominator;
            result += currentAddend;

            currentNominator *= power;
            currentDenominator *= i;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Math.pow(Math.E, 12));
        System.out.println(calculatePowerOfNapierConstant(12));
    }
}
