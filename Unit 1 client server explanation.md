Explanation:

***Server***
Import Statements:
java.io.* for input and output operations.
java.net.* for networking operations.


Main Method:
The entry point of the server program.

ServerSocket Creation:
ServerSocket serverSocket = new ServerSocket(4567); creates a server socket bound to port 4567.
System.out.println("Waiting for connection..."); prints a message indicating the server is waiting for a client connection.

Accepting a Client Connection:
Socket socket = serverSocket.accept(); waits for a client to connect. This method blocks until a connection is made.
System.out.println("Connected to the client."); prints a message indicating a client has connected.

Setting Up Streams:
BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream())); sets up a reader to receive data from the client.
PrintWriter out_socket = new PrintWriter(socket.getOutputStream(), true); sets up a writer to send data to the client.

Communication:
out_socket.println("Hello Client."); sends "Hello Client." to the client.
String msg = ""; initializes a string to store the client's message.
msg = in_socket.readLine(); reads the message from the client.
System.out.println(msg); prints the received message.

Closing Connections:
socket.close(); closes the client socket.
serverSocket.close(); closes the server socket.

Exception Handling:
catch (Exception e) { e.printStackTrace(); } catches and prints any exceptions that occur.

*****************************************8

***Client***

Import Statements:
Similar to the server, for input/output and networking operations.

Main Method:
The entry point of the client program.

Connecting to the Server:
System.out.println("Waiting for connection..."); prints a message indicating the client is attempting to connect.
Socket socket = new Socket("localhost", 4567); creates a socket and connects to the server on localhost at port 4567.
System.out.println("Connection established."); prints a message indicating the connection was successful.

Setting Up Streams:
BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream())); sets up a reader to receive data from the server.
PrintWriter out_socket = new PrintWriter(socket.getOutputStream(), true); sets up a writer to send data to the server.

Communication:
String msg = ""; initializes a string to store the server's message.
msg = in_socket.readLine(); reads the message from the server.
System.out.println(msg); prints the received message.
out_socket.println("Hello Server."); sends "Hello Server." to the server.

Closing the Connection:
socket.close(); closes the client socket.

Exception Handling:
catch (Exception e) { e.printStackTrace(); } catches and prints any exceptions that occur.

**************************************************************

How it Works

Server Setup:
The server starts and waits for a client to connect.

Client Connection:
The client starts, connects to the server, and establishes the connection.

Message Exchange:
The server sends "Hello Client." to the client.
The client receives this message and prints it.
The client sends "Hello Server." back to the server.
The server receives this message and prints it.

Termination:
Both the server and client close their respective connections.
*******************************************************************
