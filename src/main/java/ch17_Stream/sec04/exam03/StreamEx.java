package ch17_Stream.sec04.exam03;

import java.util.stream.IntStream;

public class StreamEx {
    public static int sum; // 합계를 구하기 위한 변수
    public static void main(String[] args) {
        IntStream intStream = IntStream.rangeClosed(1, 100);
        sum = intStream.sum();
        System.out.println(sum);
    }
}
