package ch16.sec01;

public class LambdaExample {
    public static void main(String[] args) {

        // x + y
        action((x, y) -> {
            int result = x + y;
            System.out.println(result);
        });

        // x - y
        action((x, y) -> {
            int result = x - y;
            System.out.println(result);
        });

    }

    public static void action(Calculable calculable) {
        int x = 10;
        int y = 4;
        calculable.calculate(x, y);
    }
}
