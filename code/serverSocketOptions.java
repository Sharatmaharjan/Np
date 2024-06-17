a. TimeoutServer (SO_TIMEOUT)

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class TimeoutServer {
    public static void main(String[] args) {
        int port = 12345;
        
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            serverSocket.setSoTimeout(5000); // Set timeout to 5000 milliseconds (5 seconds)
            System.out.println("TimeoutServer is listening on port " + port);
            
            while (true) {
                try {
                    Socket socket = serverSocket.accept(); // This will block for up to 5 seconds
                    System.out.println("New client connected to TimeoutServer");
                    // Handle the client connection
                } catch (SocketTimeoutException e) {
                    System.out.println("Accept timed out, no incoming connection in 5 seconds");
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

b. ReuseAddressServer (SO_REUSEADDR)

import java.io.IOException;
import java.net.ServerSocket;

public class ReuseAddressServer {
    public static void main(String[] args) {
        int port = 12345;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            serverSocket.setReuseAddress(true); // Enable SO_REUSEADDR
            System.out.println("ReuseAddressServer is listening on port " + port);

            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    System.out.println("New client connected to ReuseAddressServer");
                    // Handle the client connection
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}


c. ReceiveBufferServer (SO_RCVBUF)

import java.io.IOException;
import java.net.ServerSocket;

public class ReceiveBufferServer {
    public static void main(String[] args) {
        int port = 12345;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            serverSocket.setReceiveBufferSize(65536); // Set receive buffer size to 64 KB
            System.out.println("ReceiveBufferServer is listening on port " + port);

            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    System.out.println("New client connected to ReceiveBufferServer with receive buffer size: " +
                            socket.getReceiveBufferSize());
                    // Handle the client connection
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}


d. SimpleClient

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class SimpleClient {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 12345;

        try (Socket socket = new Socket(hostname, port)) {
            System.out.println("Connected to the server");

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String serverResponse = input.readLine();
            System.out.println("Server response: " + serverResponse);
        } catch (IOException ex) {
            System.out.println("Client exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}

