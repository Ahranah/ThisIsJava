package ch15.sec02.exam01;

import java.util.*;

public class ArrayListExample {
    public static void main(String[] args) {
        List<Board> list = new ArrayList<>();
        list.add(new Board("Kim", "intellij", "INTERO"));
        list.add(new Board("Kim", "intellij", "INTERO"));
        list.add(new Board("Kim", "intellij", "INTERO"));
        list.add(new Board("Kim", "intellij", "INTERO"));
        list.add(new Board("Kim", "intellij", "INTERO"));


    for (int i =0 ; i<list.size() ; i++) {
        if (i == 2) {
            System.out.println(list.get(i));
            list.remove(i);
        }
    }


    for (Board board : list) {
        System.out.println(board);
    }


    }
}
