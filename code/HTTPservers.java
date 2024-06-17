1. SingleFileServer.java

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class SingleFileServer {
    public static void main(String[] args) {
        int port = 8080;
        String fileUrl = "https://raw.githubusercontent.com/Sharatmaharjan/Np/main/code/index.html"; // Raw file URL from GitHub

        try {
            // Fetch the HTML content from the URL
            String content = fetchContentFromUrl(fileUrl);
            
            try (ServerSocket serverSocket = new ServerSocket(port)) {
                System.out.println("SingleFileServer is listening on port " + port);

                while (true) {
                    try (Socket socket = serverSocket.accept()) {
                        System.out.println("New client connected");

                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                        // Read the HTTP request (only the first line for simplicity)
                        String requestLine = in.readLine();
                        System.out.println("Request: " + requestLine);

                        if (requestLine != null && requestLine.startsWith("GET")) {
                            // Send HTTP response
                            out.println("HTTP/1.1 200 OK");
                            out.println("Content-Type: text/html");
                            out.println("Content-Length: " + content.length());
                            out.println();
                            out.println(content);
                        }

                        socket.close();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String fetchContentFromUrl(String fileUrl) throws IOException {
        StringBuilder content = new StringBuilder();
        URL url = new URL(fileUrl);
        try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine).append("\n");
            }
        }
        return content.toString();
    }
}


2. Redirector.java

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Redirector {
    public static void main(String[] args) {
        int port = 8080;
        String redirectUrl = "http://example.com";

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Redirector is listening on port " + port);

            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    System.out.println("New client connected");

                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                    // Read the HTTP request (only the first line for simplicity)
                    String requestLine = in.readLine();
                    System.out.println("Request: " + requestLine);

                    if (requestLine != null && requestLine.startsWith("GET")) {
                        // Send HTTP redirect response
                        out.println("HTTP/1.1 302 Found");
                        out.println("Location: " + redirectUrl);
                        out.println();
                    }

                    socket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

3. FullFledgedHttpServer.java

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class FullFledgedHttpServer {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/", new RootHandler());
        server.createContext("/hello", new HelloHandler());
        server.setExecutor(null); // creates a default executor
        System.out.println("FullFledgedHttpServer is listening on port " + port);
        server.start();
    }

    static class RootHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = "Welcome to the Full-Fledged HTTP Server!";
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    static class HelloHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = "Hello, world!";
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}


