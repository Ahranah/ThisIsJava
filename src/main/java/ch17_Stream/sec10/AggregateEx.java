package ch17_Stream.sec10;

import java.util.*;

public class AggregateEx {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};

        //2의 배수 카운팅
        long count = Arrays.stream(arr)
                .filter(n-> n%2 == 0)
                .count();
        System.out.println("The number of 2n " + count);

        //2의 배수 총합
        long sum = Arrays.stream(arr)
                .filter(n-> n%2 == 0)
                .sum();
        System.out.println("The sum of 2n " + sum);

        //2의 배수 평균
        double avg = Arrays.stream(arr)
                .filter(n-> n%2 == 0)
                .average()
                .getAsDouble();
        System.out.println("The avg of 2n " + avg);

        //2의 배수 중 최대값
        int max = Arrays.stream(arr)
                .filter(n-> n%2 == 0)
                .max().getAsInt();
        System.out.println("Max value in 2n " + max);

        //2의 배수 중 최소값
        int min = Arrays.stream(arr)
                .filter(n-> n%2 == 0)
                .min().getAsInt();
        System.out.println("Min value in 2n " + min);


        //첫 번째 3의 배수
        int third = Arrays.stream(arr)
                .filter(n-> n%3 == 0)
                .findFirst().getAsInt();
        System.out.println("The first multiple of three " + third);
    }
}
