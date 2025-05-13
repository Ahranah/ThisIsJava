package ch19_Network.sec04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;

// 클라이언트가 구독하고 싶은 뉴스 10개 전송하는 서버
public class NewsServer {
    private static DatagramSocket socket = null;

    public static void main(String[] args) throws IOException {
        System.out.println("Press any key to stop the server...");

        startServer();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String message = br.readLine();
            if (message.isEmpty()) break;
        }
        br.close();

        // 소켓 닫고 포트 언바인딩
        socket.close();
    }

    public static void startServer() {
        // worker thread
        Thread serverThread = new Thread() {
            @Override
            public void run() {
                try {
                    socket = new DatagramSocket(50001);
                    System.out.println("Server started on port: " + socket.getLocalPort());

                    while (true) {
                        // 클라이언트가 구독하고 싶은 뉴스 주제 얻기
                        DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
                        socket.receive(packet);

                        String newsKind = new String(packet.getData(), 0, packet.getLength(), "UTF-8");

                        // 클라이언트의 IP와 Port 얻기
                        SocketAddress sendAdd = packet.getSocketAddress();

                        // 클라이언트로 10개의 뉴스 전송하기
                        for (int i = 0; i <= 10; i++) {
                            String data = newsKind + ": news" + i;
                            byte[] buf = data.getBytes("UTF-8");
                            DatagramPacket sendPacket = new DatagramPacket(buf, buf.length, sendAdd);
                            socket.send(sendPacket);
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Server| " + e.getMessage());
                }
            }
        };

        serverThread.start();
    }
}
