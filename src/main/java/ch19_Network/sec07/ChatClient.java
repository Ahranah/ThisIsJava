package ch19_Network.sec07;

import org.json.JSONObject;
import java.io.*;
import java.net.DatagramPacket;
import java.net.Socket;

public class ChatClient {
    public static void main(String[] args) {
        try {
            ChatClient chatClient = new ChatClient();
            chatClient.connect();

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Please enter your name: ");
            chatClient.chatName = br.readLine();

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("command", "incoming");
            jsonObject.put("data", chatClient.chatName);
            String json = jsonObject.toString();
            chatClient.send(json);

            chatClient.receive();

            System.out.println("------------------------");
            System.out.println("보낼 메시지를 입력하고 Enter");
            System.out.println("press 'q' or 'Q' key to exit");
            System.out.println("-----------------------");

            while(true){
                String msg = br.readLine();
                if (msg.toLowerCase().equals("q")) break;
                else {
                    jsonObject = new JSONObject();
                    jsonObject.put("command", "message");
                    jsonObject.put("data", msg);
                    json = jsonObject.toString();
                    chatClient.send(json);
                }
            }

            br.close();
            chatClient.unconnect();
        } catch (Exception e) {
            System.out.println("[Client] server not connected");
        }
    }

    Socket socket;
    DataInputStream dis;
    DataOutputStream dos;
    String chatName;

    // method: connect server
    public void connect() throws IOException {
        socket = new Socket("localhost", 50001);
        dis = new DataInputStream(socket.getInputStream());
        dos = new DataOutputStream(socket.getOutputStream());
        System.out.println("Connected to " + socket.getInetAddress().getHostName());
    }

    // method: get JSON
    public void receive() {
        Thread t = new Thread(()-> {
            try {
                while (true) {
                    String json = dis.readUTF();
                    JSONObject root = new JSONObject(json);
                    String clientIp = root.getString("clientIp");
                    String chatName = root.getString("chatName");
                    String msg = root.getString("message");
                    System.out.println("<" + chatName + "@" + clientIp + "> " + msg);
                }
            } catch (Exception e) {
                System.out.println("Client disconnected");
                System.exit(0);
            }
        });
        t.start();
    }

    // method: send JSON
    public void send(String json) throws IOException {
        dos.writeUTF(json);
        dos.flush();
    }

    // method: close server connection
    public void unconnect() throws IOException {
        socket.close();
    }


}
