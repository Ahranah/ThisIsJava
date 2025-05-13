package ch19_Network.sec05.exam01;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EchoServer {
    private static ServerSocket serverSocket = null;
    private static ExecutorService executor = Executors.newFixedThreadPool(10);

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

                    while (true) {
                        System.out.println("Waiting for connection...");
                        // accept connection
                        Socket socket = serverSocket.accept();

                        executor.execute(() -> {
                            try {
                                // get Info from connected clients
                                InetSocketAddress address = (InetSocketAddress) socket.getRemoteSocketAddress();

                                System.out.println("Connected to " + address.getHostName()
                                        + "(" + address.getHostString() + ")" + " :" + address.getPort());

                                // ------------------------- //

                                // receive data
                                DataInputStream dis = new DataInputStream(socket.getInputStream());
                                // byte[string encoding with UTF-8]
                                String message = dis.readUTF();
                                System.out.println("Message received: " + message);

                                // send data
                                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                                dos.writeUTF(message);
                                dos.flush();
                                System.out.println("Message sent: " + message);

                                // ------------------------- //

                                // quit connection
                                socket.close();
                                System.out.println("Closing connection...");
                            } catch (IOException e) {
                                System.out.println("Error accepting connection" + e.getMessage());
                            }
                        });
                    }
                } catch (IOException e2) {
                    System.out.println("Server: " + e2.getMessage());
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
            executor.shutdownNow();
            System.out.println("Server stopped.");
        } catch (IOException e) {
        }
    }
}

