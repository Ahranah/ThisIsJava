package ThisisJAVA.ch05;

import java.util.Scanner;

public class Score {
    public static void main(String[] args) {

        boolean run = true;
        Scanner sc = new Scanner(System.in);

        int studentNum = 0;
        Integer[] scoreList = null;
        int max = 0;
        int total = 0;

        while (run) {
            System.out.println(""" 
                    
                    -----------------------------------------------------------------------------------------
                    1. The number of Student || 2. Insert Score || 3. Score List || 4. Analysis || 5. Close
                    -----------------------------------------------------------------------------------------
                    """);
            System.out.println("Enter the number in a given order: ");
            int n = sc.nextInt();

            switch (n) {
                case 1: {
                    System.out.println("Enter the student number: ");
                    studentNum = sc.nextInt();
                    scoreList = new Integer[studentNum];
                    continue;
                }
                case 2: {
                    for (int i = 0; i < studentNum; i++) {
                        System.out.println("Enter student " + (i + 1) + " score: ");
                        scoreList[i] = sc.nextInt();
                    }
                    continue;
                }
                case 3: {
                    if (scoreList == null) {
                        System.out.println("return to prev progress");
                        continue;
                    }
                    for (int i = 0; i < studentNum; i++) {
                        System.out.println("student " + (i + 1) + " score: " + scoreList[i]);
                    }
                    continue;
                }
                case 4: {
                    if (scoreList == null) {
                        System.out.println("return to prev progress");
                        continue;
                    }
                    for (int i = 0; i < studentNum; i++) {
                        if (scoreList[i] > max) {
                            max = scoreList[i];
                        }
                        total += scoreList[i];
                    }
                    System.out.println("Average score: " + total / studentNum);
                    System.out.println("Max score: " + max);
                    continue;
                }
                case 5: {
                    System.out.println("Close the program");
                    run = false;
                }
            }
        }
    }
}
