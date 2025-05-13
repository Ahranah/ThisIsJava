package ch19_Network.sec07;

import java.net.ServerSocket;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatServer {
        ServerSocket serverSocket = null;
        ExecutorService executor = Executors.newFixedThreadPool(100);
        Map<String, SocketClient> chatRoom = Collection.synchroizedMap(new HashMap<>());
}
