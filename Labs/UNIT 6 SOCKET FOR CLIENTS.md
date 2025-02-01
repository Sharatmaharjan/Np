## UNIT 6 SOCKET FOR CLIENTS LH - 5HRS
 
    
### LAB 1: Find out which of the first 1,024 ports seem to be hosting TCP servers on a specified host.(PortScanner)
```java
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class LowPortScanner {
    public static void main(String[] args) {
        String host = "localhost";

        // Scanning ports from 1 to 1024
        for (int port = 1; port <= 1024; port++) {
            try (Socket socket = new Socket(host, port)) {
                // If connection is successful, a server is running on this port
                System.out.println("Server detected on port " + port + " of " + host + ".");
            } catch (UnknownHostException e) {
                System.err.println("Unknown host: " + host);
                break; // Stop scanning if the host is invalid
            } catch (IOException e) {
                // No server is running on this port or connection failed
                // Commented out to reduce clutter, uncomment if needed for debugging
                // System.out.println("No server on port " + port);
            }
        }
    }
}

```

  
