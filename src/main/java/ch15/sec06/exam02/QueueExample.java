package ch15.sec06.exam02;

import java.util.*;

public class QueueExample {
    public static void main(String[] args) {
        Queue<Message> queue = new LinkedList<>();

        queue.add(new Message("sendMail", "홍길동"));
        queue.add(new Message("sendSMS", "신용권"));
        queue.add(new Message("sendKakaotalk", "감자바"));

        while (!queue.isEmpty()) {
            Message message = queue.poll();
            String command = message.getCommand().substring(4);
            String particle = null;
            if (command.equals("Mail") || command.equals("Kakaotalk")) {
                particle = "을";
            } else particle = "를";
            System.out.println(message.getTo() + "님에게 " + command + particle + " 보냅니다.");
        }
    }
}
