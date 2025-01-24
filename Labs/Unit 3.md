### Example 1: Which protocols does a virtual machine support?

```java
import java.net.*;

public class ProtocolTester {
    public static void main(String[] args) {
        // Testing various protocols

        // Hypertext Transfer Protocol (HTTP)
        testProtocol("http://www.adc.org");

        // Secure Hypertext Transfer Protocol (HTTPS)
        testProtocol("https://www.amazon.com/exec/obidos/order2/");

        // File Transfer Protocol (FTP)
        testProtocol("ftp://ibiblio.org/pub/languages/java/javafaq/");

        // Simple Mail Transfer Protocol (MAILTO)
        testProtocol("mailto:elharo@ibiblio.org");

        // Telnet Protocol
        testProtocol("telnet://dibner.poly.edu/");
    }

    private static void testProtocol(String url) {
        try {
            // Try to create a URL object; throws MalformedURLException if protocol is not supported
            URL u = new URL(url);
            System.out.println(u.getProtocol() + " is supported");
        } catch (MalformedURLException ex) {
            // Extracting the protocol from the URL string
            String protocol = url.substring(0, url.indexOf(':'));
            System.out.println(protocol + " is not supported");
        }
    }
}
```

---
