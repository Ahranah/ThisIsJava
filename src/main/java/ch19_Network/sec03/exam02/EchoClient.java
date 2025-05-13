package ch19_Network.sec03.exam02;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient {
    public static void main(String[] args) {
        try {
            // Create Socket and require connection to local port at the same time
            Socket socket = new Socket("localhost", 50001);
            System.out.println("Client: Connected to server");


            // -----------------------//
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter a string: ");

            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            String message = br.readLine();
            dos.writeUTF(message);
            dos.flush();
            System.out.println("Client: Sending data to server: " + message);

            // receive data
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            String response = dis.readUTF();
            System.out.println("Client: Received data from server: " + response);
            // -----------------------//
            socket.close();

            System.out.println("Client: Disconnected from server");
        } catch (
                UnknownHostException e) {
            // IP 잘못 표기한 경우
        } catch (
                IOException e) {
            // IP, Port로 서버에 연결할 수 없는 경우
        }
    }

}
