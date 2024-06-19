
a. MultiThreadedBinaryServer.java
  
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadedBinaryServer {

    public static void main(String[] args) {
        int port = 12345; // The port number the server will listen on

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                // Create a new thread for each client connection
                new ServerThread(socket).start();
            }
        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}

class ServerThread extends Thread {
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try (DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {
            // Send binary data to the client
            byte[] binaryData = {1, 2, 3, 4, 5}; // Example binary data
            out.write(binaryData);
            out.flush();

            System.out.println("Sent binary data to client");

        } catch (IOException ex) {
            System.out.println("ServerThread exception: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                socket.close();
                System.out.println("Client disconnected");
            } catch (IOException ex) {
                System.out.println("Failed to close socket: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }
}

b. BinaryDataClient.java
  
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class BinaryDataClient {

    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 12345;

        try (Socket socket = new Socket(hostname, port)) {
            DataInputStream input = new DataInputStream(socket.getInputStream());

            // Read binary data from the server
            byte[] binaryData = new byte[5];
            input.readFully(binaryData);

            System.out.println("Received binary data from server:");
            for (byte b : binaryData) {
                System.out.print(b + " ");
            }

        } catch (IOException ex) {
            System.out.println("Client exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
