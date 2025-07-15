package ch19_Network.sec07;

import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatServer {
    ServerSocket serverSocket = null;
    ExecutorService threadPool = Executors.newFixedThreadPool(100);
    Map<String, SocketClient> chatRoom = Collections.synchronizedMap(new HashMap<>());

    // method: server start
    public void start() throws IOException {
        serverSocket = new ServerSocket(50001);
        System.out.println("Server started on port 50001");

        Thread thread = new Thread(() -> {
            try {
                while (true) {
                    Socket socket = serverSocket.accept();
                    SocketClient sc = new SocketClient(this, socket);
                }
            } catch (IOException e) {}
        });
        thread.start();
    }


    // method: add SocketClient
    public void addSocketClient(SocketClient socketClient) {
        String key = socketClient.chatName + "@" + socketClient.clientIp;
        chatRoom.put(key, socketClient);
        System.out.println("Added chat room key: " + key);
        System.out.println("The number of current clients is " + chatRoom.size() + "\n");
    }

    // method: remove SocketClient
    public void removeSocketClient(SocketClient socketClient) {
        String key = socketClient.chatName + "@" + socketClient.clientIp;
        chatRoom.remove(key);
        System.out.println("Removed chat room key: " + key);
        System.out.println("The number of current clients is " + chatRoom.size() + "\n");
    }

    // method: msg to All Clients
    public void sendToAll(SocketClient sender, String msg) {
        JSONObject root = new JSONObject();
        root.put("clientIp", sender.clientIp);
        root.put("chatName", sender.chatName);
        root.put("message", msg);
        String json = root.toString();

        Collection<SocketClient> socketClients = chatRoom.values();
        for (SocketClient sc : socketClients) {
            if (sc == sender) continue;
            sc.send(json);
        }
    }

    // method: close() server
    public void stop() {
        try {
            serverSocket.close();
            threadPool.shutdownNow();
            chatRoom.values().stream().forEach(s -> s.close());
            System.out.println("Server closed");
        } catch (IOException e) {
        }
    }

    public static void main(String[] args) throws IOException {
        try {
            ChatServer server = new ChatServer();
            server.start();

            System.out.println("Press any key to stop the server");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                String key = br.readLine();
                if (!key.isEmpty()) break;
            }

            br.close();
            server.stop();
        } catch (IOException ex) {
            System.out.println("[Server] " + ex.getMessage());
        }
    }
}
