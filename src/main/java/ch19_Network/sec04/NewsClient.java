package ch19_Network.sec04;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class NewsClient {
    public static void main(String[] args) throws IOException {
        try {
            //UDP 데이터 통신을 위한 DatagramSocket
            DatagramSocket socket = new DatagramSocket();

            // 바이트 배열, 바이트 배열에서 보내고자 하는 바이트 수, UDP 서버의 IP, Port 번호
            String kind = "SPORTS";
            byte[] buf = kind.getBytes("UTF-8");
            DatagramPacket sendPacket = new DatagramPacket(buf, buf.length,
                    new InetSocketAddress("localhost", 50001));
            socket.send(sendPacket);

            while (true) {
                // 뉴스 받기 - 항상 받기를 위해 receive()
                DatagramPacket receivePacket = new DatagramPacket(new byte[1024], 1024);
                socket.receive(receivePacket);

                // 받은 뉴스를 문자열로 변환
                String news = new String(receivePacket.getData(), 0, receivePacket.getLength(), "UTF-8");
                System.out.println(news);

                // 10번째 뉴스를 받으면 while 종료
                if (news.contains("뉴스10")) break;
            }
            // 소켓 닫기
            socket.close();
        } catch (Exception e) {}
    }
}
