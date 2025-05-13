package ch19_Network.sec03.exam01;

import java.net.Socket;
import java.net.UnknownHostException;
import java.io.IOException;

public class ClientExample {
    public static void main(String[] args) {
        try {
            // Create Socket and require connection to local port at the same time
            Socket socket = new Socket("localhost", 50001);
            System.out.println("Client: Connected to server");

            socket.close();

            System.out.println("Client: Disconnected from server");
        } catch (UnknownHostException e) {
            // IP 잘못 표기한 경우
        } catch (IOException e) {
            // IP, Port로 서버에 연결할 수 없는 경우
        }
    }
}
