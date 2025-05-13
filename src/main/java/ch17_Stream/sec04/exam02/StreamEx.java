package ch17_Stream.sec04.exam02;

import java.util.stream.Stream;
import java.util.Arrays;
import java.util.stream.IntStream;

public class StreamEx {
    public static void main(String[] args) {
        String[] strArray = {"a", "b", "c"};
        int[] intArray = {1, 2, 3, 4, 5};

        IntStream intStream = Arrays.stream(intArray);
        intStream.forEach( item -> System.out.print(item + ", "));

        Stream<String> stream = Arrays.stream(strArray);
        stream.forEach(System.out::println);
    }
}
