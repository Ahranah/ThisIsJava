package ch15.sec06.exam02;

import lombok.Data;

@Data
public class Message {
    private String command;
    private String to;

    Message(String command, String to) {
        this.command = command;
        this.to = to;
    }
}
