package ch06.sec08.exam01;

public class Calculator {

    int plus(int x, int y) {
        int result = x + y;
        return result;
    }

    double divide(int x, int y) {
        double result = (double)x / (double)y;
        return result;
    }

    public void powerOn() {
        System.out.printf("%s", "전원을 켭니다.\n");

    }

    public void powerOff() {
        System.out.printf("%s", "전원을 끕니다.\n");
    }


}
