public class Main {
    static final int SIZE = 9;

    public static void main(String[] args) {
        figure01();
        figure02();
        figure03();
        figure04();
        figure05();
        figure06();
    }

    private static void figure06() {
        for (int i = 1; i <= SIZE; i++) {
            for (int j = i; j <= SIZE; j++) printf("  ");
            for (int j = SIZE - i + 1; j < SIZE; j++) printf("%d ", j);
            printf("%d ", SIZE);
            for (int j = SIZE - 1; j > SIZE - i; j--) printf("%d ", j);
            printf("\n");
        }
        printf("\n\n");
    }

    private static void figure05() {
        for (int i = SIZE; i >= 1; i--) {
            for (int j = i; j <= SIZE; j++) printf("  ");
            for (int j = 1; j < i; j++) printf("%d ", j);
            for (int j = i; j >= 1; j--) printf("%d ", j);
            printf("\n");
        }
        printf("\n\n");
    }

    private static void figure04() {
        for (int i = 1; i <= SIZE; i++) {
            for (int j = i; j <= SIZE; j++) printf("  ");
            for (int j = 1; j < i; j++) printf("%d ", j);
            for (int j = i; j >= 1; j--) printf("%d ", j);
            printf("\n");
        }
        printf("\n\n");
    }

    private static void figure03() {
        for (int i = 1; i <= SIZE; i++) {
            for (int j = i; j <= SIZE; j++) printf(" ");
            for (int j = 1; j <= i; j++) printf("* ");
            printf("\n");
        }
        printf("\n\n");
    }

    private static void figure02() {
        for (int i = 1; i <= SIZE; i++) {
            for (int j = i; j <= SIZE; j++) printf(" ");
            for (int j = 1; j <= i; j++) printf("%d ", j);
            printf("\n");
        }
        printf("\n\n");
    }

    private static void figure01() {
        for (int i = 1; i <= SIZE; i++) {
            for (int j = i; j <= SIZE; j++) printf(" ");
            for (int j = 1; j <= i; j++) printf("%d ", i);
            printf("\n");
        }
        printf("\n\n");
    }

    @SuppressWarnings("SpellCheckingInspection")
    private static void printf(String format, Object... stuff) {
        System.out.printf(format, stuff);
    }
}
