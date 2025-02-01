## UNIT 6 SOCKET FOR CLIENTS LH - 5HRS
 
    
### LAB 1: Find out which of the first 1,024 ports seem to be hosting TCP servers on a specified host.(PortScanner)
```java
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class PortScanner {

    public static void main(String[] args) {
        // Define the range of ports to scan (1 to 1024)
        int startPort = 1;
        int endPort = 1024;

        // Loop through each port in the specified range
        for (int port = startPort; port <= endPort; port++) {
            try {
                // Attempt to create a socket connection to the specified host and port
                Socket socket = new Socket("localhost", port);
                System.out.println("Server is running on port " + port + " of localhost.");
                socket.close(); // Close the socket after successful connection
            } catch (UnknownHostException e) {
                // Handle the case where the host is unknown
                System.out.println("Unknown host: " + e.getMessage());
                break; // Exit the loop if the host is unknown
            } catch (IOException e) {
                // Handle the case where the port is closed or unreachable
                System.out.println("No server is running on port " + port + " of localhost.");
            }
        }
    }
}

```
### LAB 2: Find out which of the ports at or above 1,024 seem to be hosting TCP servers.

```java
import java.io.IOException;
import java.net.Socket;

public class HighPortScanner {

    public static void main(String[] args) {
        // Define the range of ports to scan (1024 to 65535)
        int startPort = 1024;
        int endPort = 65535;

        // Loop through each port in the specified range
        for (int port = startPort; port <= endPort; port++) {
            try {
                // Attempt to create a socket connection to the specified host and port
                Socket socket = new Socket("localhost", port);
                System.out.println("Server is running on port " + port + " of localhost.");
                socket.close(); // Close the socket after successful connection
            } catch (IOException e) {
                // Port is closed or unreachable, so no action is taken
                // Uncomment the line below to see which ports are closed
                // System.out.println("No server is running on port " + port + " of localhost.");
            }
        }
    }
}

```
  
### LAB 3: WAP to attempt to open a socket for www.prime.edu.np or any other host, and then uses these four methods to print the remote host, the remote port, the local address, and the local port.

```java
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketInfoExample {

    public static void main(String[] args) {
        // Define the host and port to connect to
        String host = "www.prime.edu.np";
        int port = 80;

        try {
            // Attempt to open a socket connection to the specified host and port
            Socket socket = new Socket(host, port);

            // Retrieve and print connection details
            System.out.println("Connected to remote host: " + socket.getInetAddress());
            System.out.println("Remote port: " + socket.getPort());
            System.out.println("Local address: " + socket.getLocalAddress());
            System.out.println("Local port: " + socket.getLocalPort());

            // Close the socket after use
            socket.close();
        } catch (UnknownHostException ex) {
            System.err.println("Error: Unable to find the host '" + host + "'.");
        } catch (IOException ex) {
            System.err.println("Error: Could not connect to the host '" + host + "'.");
            ex.printStackTrace();
        }
    }
}

```
### LAB 4: WAP for EchoClient.
**Echoclient.java**
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class EchoClient {

    public static void main(String[] args) {
        // Define the server address and port
        String serverAddress = "localhost";
        int serverPort = 4567;

        // Declare resources outside the try block to ensure they can be closed in the finally block
        Socket clientSocket = null;
        BufferedReader br = null;
        PrintWriter pw = null;
        Scanner scanner = null;

        try {
            System.out.println("Waiting for connection...");
            clientSocket = new Socket(serverAddress, serverPort); // Connect to the server
            System.out.println("Connected to server...");

            // Set up input and output streams
            br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            pw = new PrintWriter(clientSocket.getOutputStream(), true);

            // Set up scanner to read input from the console
            scanner = new Scanner(System.in);

            // Start communication loop
            while (true) {
                System.out.print("Enter text: ");
                String inputLine = scanner.nextLine(); // Read input from the console

                // Check if the user wants to quit
                if (inputLine.equalsIgnoreCase("quit")) {
                    System.out.println("Closing connection...");
                    break;
                }

                pw.println(inputLine); // Send the input to the server

                String response = br.readLine(); // Read the server's response
                System.out.println("Server: " + response); // Print the server's response
            }
        } catch (UnknownHostException e) {
            System.err.println("Error: Unknown host - " + serverAddress);
        } catch (IOException e) {
            System.err.println("Error: Unable to connect to the server - " + e.getMessage());
        } finally {
            // Close resources in the finally block to ensure they are always closed
            try {
                if (scanner != null) scanner.close();
                if (pw != null) pw.close();
                if (br != null) br.close();
                if (clientSocket != null) clientSocket.close();
            } catch (IOException e) {
                System.err.println("Error: Failed to close resources - " + e.getMessage());
            }
        }
    }
}

```


**EchoSever.java**

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    public static void main(String[] args) {
        // Define the port on which the server will listen for connections
        int port = 4567;

        // Declare resources outside the try block to ensure they can be closed in the finally block
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        BufferedReader br = null;
        PrintWriter pw = null;

        try {
            // Create a ServerSocket to listen for incoming connections on the specified port
            serverSocket = new ServerSocket(port);
            System.out.println("EchoServer is running and waiting for connections on port " + port + "...");

            // Accept an incoming client connection
            clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress());

            // Set up input and output streams for communication with the client
            br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            pw = new PrintWriter(clientSocket.getOutputStream(), true);

            // Start communication loop
            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                System.out.println("Received from client: " + inputLine);

                // Echo the received message back to the client
                pw.println(inputLine);
                System.out.println("Sent to client: " + inputLine);
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            // Close resources in the finally block to ensure they are always closed
            try {
                if (pw != null) pw.close();
                if (br != null) br.close();
                if (clientSocket != null) clientSocket.close();
                if (serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                System.err.println("Error: Failed to close resources - " + e.getMessage());
            }
        }
    }
}
```
