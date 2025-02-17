### Example 1: A Multithreaded Daytime Server

#### a. `DaytimeServer.java`

```java
import java.net.*;
import java.io.*;
import java.util.Date;

public class DaytimeServer {

    public static void main(String[] args) {
        try {
            // Create a server socket listening on port 1234
            ServerSocket server = new ServerSocket(1234);
            System.out.println("Daytime server started on port 1234...");

            // Continuously accept client connections
            while (true) {
                try {
                    // Accept a client connection
                    Socket socket = server.accept();
                    System.out.println("New client connected: " + socket.getInetAddress());

                    // Create a new thread to handle the client request
                    Thread task = new DaytimeThread(socket);
                    task.start();
                } catch (IOException ex) {
                    System.err.println("Error accepting client connection: " + ex.getMessage());
                }
            }
        } catch (IOException ex) {
            System.err.println("Could not start server: " + ex.getMessage());
        }
    }

    // Thread class to handle client requests
    private static class DaytimeThread extends Thread {
        private Socket socket;

        DaytimeThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Get the output stream to send data to the client
                Writer out = new OutputStreamWriter(socket.getOutputStream());

                // Get the current date and time
                Date now = new Date();

                // Send the date and time to the client
                out.write(now.toString() + "\r\n");
                out.flush();

                // Close the socket
                socket.close();
                System.out.println("Client disconnected: " + socket.getInetAddress());
            } catch (IOException ex) {
                System.err.println("Error handling client request: " + ex.getMessage());
            }
        }
    }
}
```

---

#### b. `DaytimeClient.java`

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class DaytimeClient {

    public static void main(String[] args) {
        String hostname = "localhost"; // Server hostname
        int port = 1234; // Server port

        try (Socket socket = new Socket(hostname, port)) {
            // Read the server's response
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String serverTime = input.readLine();

            // Print the server's time
            System.out.println("Server time: " + serverTime);
        } catch (IOException ex) {
            System.out.println("Client exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
```
