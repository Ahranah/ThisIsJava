package ch06.advanced.staticMethod;

import java.util.Scanner;

public class InputTest {
    public static void main(String[] args) {

        String name = "이름: ";
        String defaultName = "이름(홍길동): ";
        String value = "입력값: ";
        String age = "나이: ";
        String end = "종료할까요? ";

            String nameValue = Input.read(name);
            System.out.println(value + nameValue);
            String gildong = Input.read(defaultName,"홍길동");
            System.out.println(value+gildong);
            int ageValue = Input.readInt(age);
            System.out.println(value+ageValue);
            boolean endValue = Input.confirm(end, false);
            System.out.println(value+ endValue);
            boolean endValue2 = Input.confirm(end);

    }
}
