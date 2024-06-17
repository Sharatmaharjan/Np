a. LoggedServer.java

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggedServer {
    private static final Logger logger = Logger.getLogger(LoggedServer.class.getName());

    public static void main(String[] args) {
        int port = 12345;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            logger.info("Server is listening on port " + port);

            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    logger.info("New client connected");

                    Thread task = new DaytimeThread(socket);
                    task.start();
                } catch (IOException ex) {
                    logger.log(Level.SEVERE, "Error accepting client connection", ex);
                }
            }
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Couldn't start server", ex);
        }
    }

    private static class DaytimeThread extends Thread {
        private Socket socket;

        DaytimeThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                Writer out = new OutputStreamWriter(socket.getOutputStream());
                Date now = new Date();
                out.write(now.toString() + "\r\n");
                out.flush();
                logger.info("Sent date to client: " + now.toString());
                socket.close();
                logger.info("Client disconnected");
            } catch (IOException ex) {
                logger.log(Level.SEVERE, "Error handling client connection", ex);
            }
        }
    }
}


b. LoggedClient.java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggedClient {
    private static final Logger logger = Logger.getLogger(LoggedClient.class.getName());

    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 12345;

        try (Socket socket = new Socket(hostname, port)) {
            logger.info("Connected to server");

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String serverTime = input.readLine();
            logger.info("Received server time: " + serverTime);
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Client exception", ex);
        }
    }
}
