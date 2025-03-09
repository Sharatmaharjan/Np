a. NonBlockingServer.java

  import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NonBlockingServer {
    public static void main(String[] args) throws IOException {
        // Open a Selector for handling multiple channels in non-blocking mode
        Selector selector = Selector.open();

        // Open a ServerSocketChannel to listen for incoming client connections
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        // Bind the server socket to localhost on port 8080
        serverSocketChannel.bind(new InetSocketAddress("localhost", 8080));

        // Configure the server socket channel to operate in non-blocking mode
        serverSocketChannel.configureBlocking(false);

        // Register the server socket channel with the selector for "accept" operations
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        // Infinite loop to continuously handle incoming events
        while (true) {
            // Block until at least one channel is ready for an operation
            selector.select();

            // Get the set of keys corresponding to the channels that are ready
            Set<SelectionKey> selectedKeys = selector.selectedKeys();

            // Use an iterator to process each key
            Iterator<SelectionKey> it = selectedKeys.iterator();

            while (it.hasNext()) {
                SelectionKey key = it.next();

                // Check if the key indicates that a new client connection is ready to be accepted
                if (key.isAcceptable()) {
                    // Accept the incoming client connection
                    ServerSocketChannel server = (ServerSocketChannel) key.channel();
                    SocketChannel client = server.accept();

                    // Configure the client socket channel to operate in non-blocking mode
                    client.configureBlocking(false);

                    // Register the client channel with the selector for "read" operations
                    client.register(selector, SelectionKey.OP_READ);
                } 
                // Check if the key indicates that data is available to be read from a client
                else if (key.isReadable()) {
                    // Get the client channel and read data into a buffer
                    SocketChannel client = (SocketChannel) key.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(256); // Allocate a buffer of size 256 bytes

                    // Read data from the client into the buffer
                    client.read(buffer);

                    // Prepare the buffer for reading by flipping it
                    buffer.flip();

                    // Convert the buffer's content to a string and print it
                    System.out.println(new String(buffer.array()).trim());

                    // Close the client connection after reading the data
                    client.close();
                }

                // Remove the processed key to avoid reprocessing it
                it.remove();
            }
        }
    }
}

b. NonBlockingClient.java

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NonBlockingClient {
    public static void main(String[] args) throws IOException {
        // Define the server address (localhost on port 8080)
        InetSocketAddress address = new InetSocketAddress("localhost", 8080);

        // Open a SocketChannel and connect to the server
        SocketChannel client = SocketChannel.open(address);

        // Prepare the message to send to the server
        String message = "Hello from client";

        // Wrap the message bytes into a ByteBuffer for sending over the channel
        ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());

        // Write the message to the server through the channel
        client.write(buffer);

        // Clear the buffer after writing (optional, as we're closing the channel next)
        buffer.clear();

        // Close the client channel after sending the message
        client.close();
    }
}
