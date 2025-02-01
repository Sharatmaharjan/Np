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

### Lab 5 WhoIs GUI

```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class WhoisGUI extends JFrame {

    private JTextField domainField;
    private JTextArea resultArea;

    public WhoisGUI() {
        setTitle("Whois Lookup");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel for input components
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        JLabel domainLabel = new JLabel("Enter Domain:");
        domainField = new JTextField(20);
        domainField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String domain = domainField.getText().trim();
                if (!domain.isEmpty()) {
                    lookupWhois(domain);
                }
            }
        });

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String domain = domainField.getText().trim();
                if (!domain.isEmpty()) {
                    lookupWhois(domain);
                }
            }
        });

        inputPanel.add(domainLabel);
        inputPanel.add(domainField);
        inputPanel.add(submitButton);

        // Panel for result text area
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new BorderLayout());

        JLabel resultLabel = new JLabel("Whois Result:");
        resultArea = new JTextArea(20, 50);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        resultPanel.add(resultLabel, BorderLayout.NORTH);
        resultPanel.add(scrollPane, BorderLayout.CENTER);

        // Adding panels to the main frame
        add(inputPanel, BorderLayout.NORTH);
        add(resultPanel, BorderLayout.CENTER);
        
        // Scroll to top after updating result
        resultArea.setCaretPosition(0);
    }

    private void lookupWhois(String domain) {
        String whoisServer = "whois.verisign-grs.com";
        int port = 43;

        try (Socket socket = new Socket(whoisServer, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // Send domain query
            out.println(domain);

            // Receive and display response
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                response.append(line).append("\n");
            }

            // Update GUI with result and scroll to top
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    resultArea.setText(response.toString());
                    resultArea.setCaretPosition(0); // Scroll to top
                }
            });

        } catch (IOException e) {
        // Handle specific exceptions or provide user feedback
        JOptionPane.showMessageDialog(this, "Error performing Whois lookup:\n" + e.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace(); // For debugging, log the exception
    }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                WhoisGUI gui = new WhoisGUI();
                gui.setVisible(true);
            }
        });
    }
}
```

### Lab 6 NetworkClient

```java
a. simplechatserver.java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SimpleChatServer {

    private static final int PORT = 9000;
    private static List<ClientHandler> clients = new ArrayList<>();
    private static int nextUserId = 1;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is running on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected");

                ClientHandler clientHandler = new ClientHandler(clientSocket, "User" + nextUserId);
                nextUserId++;
                clients.add(clientHandler);
                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ClientHandler implements Runnable {
        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;
        private String username;

        public ClientHandler(Socket socket, String username) {
            this.clientSocket = socket;
            this.username = username;
            try {
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                // Notify client of their username
                out.println("You are connected as: " + username);

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println(username + ": " + message);
                    broadcastMessage(username + ": " + message, this);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    in.close();
                    out.close();
                    clientSocket.close();
                    clients.remove(this);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private void broadcastMessage(String message, ClientHandler sender) {
            for (ClientHandler client : clients) {
                if (client != sender) {
                    client.sendMessage(message);
                }
            }
        }

        private void sendMessage(String message) {
            out.println(message);
        }
    }
}

 

b. networkclient.java

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SimpleNetworkClientGUI extends JFrame {

    private JTextField serverAddressField;
    private JTextField portField;
    private JTextArea chatArea;
    private JTextArea messageArea;
    private JButton sendButton;

    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    public SimpleNetworkClientGUI() {
        setTitle("Simple Network Client");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel for connection details
        JPanel connectionPanel = new JPanel(new FlowLayout());
        serverAddressField = new JTextField("localhost", 15);
        portField = new JTextField("9000", 5);
        JButton connectButton = new JButton("Connect");
        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connectToServer();
            }
        });

        connectionPanel.add(new JLabel("Server Address:"));
        connectionPanel.add(serverAddressField);
        connectionPanel.add(new JLabel("Port:"));
        connectionPanel.add(portField);
        connectionPanel.add(connectButton);

        // Panel for chat area
        JPanel chatPanel = new JPanel(new BorderLayout());
        chatArea = new JTextArea(15, 50);
        chatArea.setEditable(false);
        JScrollPane chatScrollPane = new JScrollPane(chatArea);
        chatPanel.add(chatScrollPane, BorderLayout.CENTER);

        // Panel for message area and send button
        JPanel messagePanel = new JPanel(new BorderLayout());
        messageArea = new JTextArea(5, 50);
        messageArea.setLineWrap(true);
        messageArea.setWrapStyleWord(true);
        JScrollPane messageScrollPane = new JScrollPane(messageArea);
        messagePanel.add(messageScrollPane, BorderLayout.CENTER);

        sendButton = new JButton("Send");
        sendButton.setPreferredSize(new Dimension(80, 30));
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
        messagePanel.add(sendButton, BorderLayout.EAST);

        // Add panels to the main frame
        add(connectionPanel, BorderLayout.NORTH);
        add(chatPanel, BorderLayout.CENTER);
        add(messagePanel, BorderLayout.SOUTH);
    }

    private void connectToServer() {
        String serverAddress = serverAddressField.getText().trim();
        int port = Integer.parseInt(portField.getText().trim());

        try {
            socket = new Socket(serverAddress, port);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            appendToChatArea("Connected to server at " + serverAddress + ":" + port);

            // Start a thread to continuously read messages from server
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        String message;
                        while ((message = in.readLine()) != null) {
                            appendToChatArea(message);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        } catch (IOException e) {
            appendToChatArea("Error connecting to server: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void sendMessage() {
        if (out != null) {
            String message = messageArea.getText().trim();
            if (!message.isEmpty()) {
                out.println("You: " + message); // Prefix with "You:"
                appendToChatArea("You: " + message); // Append to chatArea with prefix
                messageArea.setText(""); // Clear message area
            }
        }
    }

    private void appendToChatArea(String message) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                chatArea.append(message + "\n");
                chatArea.setCaretPosition(chatArea.getDocument().getLength());
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SimpleNetworkClientGUI clientGUI = new SimpleNetworkClientGUI();
                clientGUI.setVisible(true);
            }
        });
    }
}
```
