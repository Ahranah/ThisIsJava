package ch15.sec02.exam03;

import ch15.sec02.exam01.Board;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {
    public static void main(String[] args) {
        List<Board> boards = new LinkedList<>();

        boards.add(new Board("sub1", "cont1", "wri1"));
        boards.add(new Board("sub2", "cont2", "wri2"));
        boards.add(new Board("sub3", "cont3", "wri3"));
        boards.add(new Board("sub4", "cont4", "wri4"));
        boards.add(new Board("sub5", "cont5", "wri5"));

        Iterator<Board> iterator = boards.iterator();
        int idx = 0;
        while (iterator.hasNext()) {
            idx ++;
            Board board = iterator.next();
            System.out.println(board);

            if (idx == 3) {
                System.out.println(boards.get(idx).getContent());
            }
        }
    }
}
