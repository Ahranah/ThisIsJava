package ch06.advanced.staticMethod;

import java.util.Scanner;

public class Input {
    // 정적 참조 변수를 멤버로 선언하면서 즉시 초기화
    private static final Scanner sc = new Scanner(System.in);

    public static String read(String title) {
        System.out.print(title);
        return sc.nextLine();
    }

    public static String read(String title, String defaultValue) {
        System.out.print(title);
        if (sc.nextLine().trim().isEmpty()) {
            return defaultValue;
        } else {
            System.out.print(title);
            return sc.nextLine();
        }
    }

    public static int readInt(String title) {
        System.out.print(title);
        return Integer.parseInt(sc.nextLine());
    }

    public static boolean confirm(String title, boolean defaultValue) {
        String ynPrompt = defaultValue ? "(Y/n)" : "(y/N)";

        System.out.print(title + ynPrompt);

        String answer = sc.nextLine();
        if (answer.isBlank()) {
            return defaultValue;
        } else return answer.equalsIgnoreCase("y");
    }

    public static boolean confirm(String title) {
        return confirm(title, true);
    }

}
