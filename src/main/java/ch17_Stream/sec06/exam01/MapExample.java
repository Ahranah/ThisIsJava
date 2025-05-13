package ch17_Stream.sec06.exam01;

import java.util.*;
import java.util.stream.IntStream;

public class MapExample {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("홍길동", 85));
        studentList.add(new Student("홍길동", 92));
        studentList.add(new Student("홍길동", 87));
        //Student 스트림을 score 스트림으로 변환하여 요소 출력
        IntStream<Student> score = studentList.stream()
                        .mapToInt(s -> s.getScore())
                        .forEach(System.out::println);
    }
}
