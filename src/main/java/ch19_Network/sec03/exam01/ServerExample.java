package ch19_Network.sec03.exam01;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.InetAddress;
import java.io.*;

public class ServerExample {
    private static ServerSocket serverSocket = null;

    public static void main(String[] args) throws IOException {
        System.out.println("Press 'q' or 'Q' and Enter to quit TCP server.");

        // start TCP server
        startServer();

        // keyboard action
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String key = br.readLine();
            if (key.equals("q")) break;
        }
        br.close();

        // Close TCP server
        stopServer();
    }

    public static void startServer() {
        // Define worker thread
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    // Create ServerSocket and Bind port
                    serverSocket = new ServerSocket(50001);
                    System.out.println("Server started on port: " + serverSocket.getLocalPort());

                    while(true) {
                        System.out.println("Waiting for connection...");
                        // accept connection
                        Socket socket = serverSocket.accept();

                        // get Info from connected clients
                        InetSocketAddress address = (InetSocketAddress) socket.getRemoteSocketAddress();

                        System.out.println("Connected to " + address.getHostName()
                                + "(" + address.getHostString() + ")" + " :" + address.getPort());

                        // quit connection
                        socket.close();
                        System.out.println("Closing connection...");
                    }

                } catch (IOException e) {
                    System.out.println("Error accepting connection" + e.getMessage());
                }
            }
        };

        // thread start
        thread.start();
    }

    public static void stopServer() {
        try {
            // close serverSocket and unbind
            serverSocket.close();
            System.out.println("Server stopped.");
        } catch (IOException e) {}
    }
}
