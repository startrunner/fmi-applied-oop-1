public class Main {
    public static void main(String[] args) {
        System.out.printf("%f %f\n", sin(.5), Math.sin(.5));
        System.out.printf("%f %f\n", cos(.5), Math.cos(.5));
    }

    private static double sin(double x) {
        final double AccuracyConstant = 0.001;

        double result = 0;

        double currentNominator = 1.0 / x, currentDenominator = 1;
        double previousAdend = -AccuracyConstant, currentAdend = AccuracyConstant;
        for (int i = 0; Math.abs(currentAdend - previousAdend) > AccuracyConstant; i++) {
            currentNominator *= x;
            currentDenominator *= Math.max(1, i);
            if (i % 2 == 1) {
                double coefficient = 1 - 2 * (i / 2 % 2);
                //System.out.printf("%f %f %f\n", coefficient, currentNominator, currentDenominator);
                previousAdend = currentAdend;
                currentAdend = (currentNominator / currentDenominator);
                result += coefficient * currentAdend;
            }
        }

        return result;
    }

    private static double cos(double x) {
        final double AccuracyConstant = 0.001;

        double result = 0;

        double currentNominator = 1.0 / x / x, currentDenominator = 1;
        double previousAdend = -AccuracyConstant, currentAdend = AccuracyConstant;
        for (int i = 0; Math.abs(currentAdend - previousAdend) > AccuracyConstant; i++) {
            currentNominator *= x;
            currentDenominator *= Math.max(1, i - 1);
            if (i % 2 == 1) {
                double coefficient = 1 - 2 * (i / 2 % 2);
                //System.out.printf("%f %f %f\n", coefficient, currentNominator, currentDenominator);
                previousAdend = currentAdend;
                currentAdend = (currentNominator / currentDenominator);
                result += coefficient * currentAdend;
            }
        }

        return result;
    }
}
