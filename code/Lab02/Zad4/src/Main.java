import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = generateNumbers();
        var statistics = NumberStatistics.create(numbers, 12);

        System.out.printf("Total count:     %d\n", statistics.getTotalCount());
        System.out.printf("Divisible count: %d\n", statistics.getDivisibleCount());
        System.out.printf("Probability:     %.2f\n", statistics.getDivisibilityProbability());
    }

    private static List<Integer> generateNumbers() {
        List<Integer> all = new ArrayList<>();

        List<IntRange> ranges = new ArrayList<>();
        ranges.add(new IntRange(3, 9));
        ranges.add(new IntRange(2, 8));
        ranges.add(new IntRange(4, 9));
        ranges.add(new IntRange(1, 6));
        ranges.add(new IntRange(6, 9));

        List<Integer> permutation = RangedPermutation.initialize(ranges);
        StringBuffer buffer = new StringBuffer();
        do {
            buffer.setLength(0);
            for (Integer digit : permutation) buffer.append(digit);

            int currentNumber = Integer.parseInt(buffer.toString());
            all.add(currentNumber);
        } while (RangedPermutation.tryAdvance(permutation, ranges));

        return all;
    }
}

class NumberStatistics {
    private NumberStatistics() {}
    int totalCount;
    int aboutNumber;
    int divisibleCount;

    public int getTotalCount() { return totalCount; }
    public int getDivisibleCount() { return divisibleCount; }

    public static NumberStatistics create(List<Integer> numbers, int aboutNumber) {
        var result = new NumberStatistics();
        result.aboutNumber = aboutNumber;
        result.totalCount = numbers.size();

        result.divisibleCount = 0;
        for (int number : numbers) {
            if (number % aboutNumber == 0)
                result.divisibleCount++;
        }

        return result;
    }

    public double getDivisibilityProbability() { return getDivisibleCount() / 1.0 / getTotalCount(); }
}

class IntRange {
    int from, to;
    public IntRange(int from, int to) { this.from = from; this.to = to; }
    public int getFrom() { return from; }
    public int getTo() { return to; }
}

class RangedPermutation {
    public static List<Integer> initialize(List<IntRange> ranges) {
        List<Integer> result = new ArrayList<>(ranges.size());

        new IntRange(1, 2);

        for (int i = 0; i < ranges.size(); i++) {
            IntRange current = ranges.get(i);
            result.add(current.getFrom());
        }

        return result;
    }

    public static boolean tryAdvance(List<Integer> permutation, List<IntRange> ranges) {
        if (permutation.size() != ranges.size())
            throw new IllegalArgumentException();
        if (permutation.isEmpty())
            return false;

        int lastIndex = permutation.size() - 1;
        permutation.set(lastIndex, permutation.get(lastIndex) + 1);

        for (int i = lastIndex; i > 0; i--) {
            if (permutation.get(i) > ranges.get(i).getTo()) {
                permutation.set(i, ranges.get(i).getFrom());
                permutation.set(i - 1, permutation.get(i - 1) + 1);
            }
        }

        return permutation.get(0) <= ranges.get(0).getTo();
    }
}