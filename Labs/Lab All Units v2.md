
# Unit 2: Internet Addresses

## 1. Print the Address of `www.javatpoint.com`

```java
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Retrieves and prints the IP address of www.javatpoint.com.
 */
public class JavaInternetAddressByName {
    public static void main(String[] args) {
        try {
            // Resolve the IP address of the host
            InetAddress address = InetAddress.getByName("www.javatpoint.com");
            // Print the resolved address
            System.out.println("Address of www.javatpoint.com: " + address);
        } catch (UnknownHostException e) {
            System.err.println("Couldn't find the host: " + e.getMessage());
        }
    }
}
```

**Sample Output:**
```
Address of www.javatpoint.com: www.javatpoint.com/172.67.160.113
```

**Explanation:**
- We use `InetAddress.getByName` to resolve the hostname to its IP address.
- The output includes both the hostname and the resolved IP address.
- Exception handling ensures robustness if the host cannot be resolved.

---

## 2. Find the Hostname of an IP Address

```java
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Resolves the hostname for a given IP address.
 */
public class ReverseTest {
    public static void main(String[] args) {
        try {
            // Resolve the IP address to an InetAddress object
            InetAddress machine = InetAddress.getByName("104.21.79.8");
            // Print the canonical hostname
            System.out.println("Hostname of 104.21.79.8: " + machine.getCanonicalHostName());
        } catch (UnknownHostException e) {
            System.err.println("No hostname found: " + e.getMessage());
        }
    }
}
```

**Sample Output:**
```
Hostname of 104.21.79.8: www.javatpoint.com
```

**Explanation:**
- We use `getCanonicalHostName` to perform a reverse DNS lookup.
- The method returns the fully qualified domain name (FQDN) for the IP address.
- Proper exception handling is included for cases where the IP cannot be resolved.

---

## 3. Find the IP Address of the Local Machine

```java
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Retrieves and prints the IP address of the local machine.
 */
public class IPLocal {
    public static void main(String[] args) {
        try {
            // Get the local machine's address
            InetAddress machine = InetAddress.getLocalHost();
            // Print the IP address
            System.out.println("Local machine IP Address: " + machine.getHostAddress());
        } catch (UnknownHostException e) {
            System.err.println("No hostname found: " + e.getMessage());
        }
    }
}
```

**Sample Output:**
```
Local machine IP Address: 192.168.1.10
```

**Explanation:**
- `InetAddress.getLocalHost` retrieves the IP address of the local machine.
- The output may vary depending on the machine's network configuration.
- Exception handling ensures the program handles cases where the local host cannot be resolved.

---

## 4. Determine Whether an IP Address is IPv4 or IPv6

```java
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Determines whether a given address uses IPv4 or IPv6.
 */
public class AddressTest {
    public static void main(String[] args) {
        try {
            // Resolve the address of a domain
            InetAddress machine = InetAddress.getByName("www.prime.edu.np");
            // Get the raw IP address bytes
            byte[] address = machine.getAddress();
            // Check the address type based on byte length
            if (address.length == 4) {
                System.out.println("IPv4 is being used.");
            } else {
                System.out.println("IPv6 is being used.");
            }
        } catch (UnknownHostException e) {
            System.err.println("No hostname found: " + e.getMessage());
        }
    }
}
```

**Sample Output:**
```
IPv4 is being used.
```

**Explanation:**
- We check the length of the address byte array (`4` for IPv4, `16` for IPv6).
- The program resolves the hostname and determines the IP version.
- Exception handling ensures robustness for unresolved hosts.

---

## 5. Check if `www.ibiblio.org` and `helios.ibiblio.org` are the Same

```java
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Compares two hostnames to check if they resolve to the same IP address.
 */
public class IBiblioAliases {
    public static void main(String[] args) {
        try {
            // Resolve addresses for both hosts
            InetAddress ibiblio = InetAddress.getByName("www.ibiblio.org");
            InetAddress helios = InetAddress.getByName("helios.ibiblio.org");
            // Compare the resolved addresses
            if (ibiblio.equals(helios)) {
                System.out.println("www.ibiblio.org is the same as helios.ibiblio.org");
            } else {
                System.out.println("www.ibiblio.org is not the same as helios.ibiblio.org");
            }
        } catch (UnknownHostException e) {
            System.err.println("Host lookup failed: " + e.getMessage());
        }
    }
}
```

**Sample Output:**
```
www.ibiblio.org is the same as helios.ibiblio.org
```

**Explanation:**
- We use `InetAddress.getByName` to resolve both hostnames.
- The `equals` method compares the resolved IP addresses.
- Exception handling covers cases where host resolution fails.

---

## 6. List All Network Interfaces

```java
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * Lists all network interfaces available on the machine.
 */
public class InterfaceLister {
    public static void main(String[] args) {
        try {
            // Get all network interfaces
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            // Iterate through and print each interface
            while (interfaces.hasMoreElements()) {
                NetworkInterface ni = interfaces.nextElement();
                System.out.println("Interface: " + ni);
            }
        } catch (SocketException e) {
            System.err.println("Error retrieving network interfaces: " + e.getMessage());
        }
    }
}
```

**Sample Output:**
```
Interface: name:eth0 (eth0)
Interface: name:lo (lo)
```

**Explanation:**
- We use `NetworkInterface.getNetworkInterfaces` to retrieve all network interfaces.
- The program iterates through the interfaces and prints their details.
- Exception handling ensures robustness for network-related errors.

---

## 7. Spam Check Program

```java
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Checks if an IP address or domain is listed in a spam blacklist.
 */
public class SpamCheck {
    private static final String BLACKHOLE = "sbl.spamhaus.org";

    public static void main(String[] args) {
        // Iterate through provided arguments (IP addresses or domains)
        for (String arg : args) {
            if (isSpammer(arg)) {
                System.out.println(arg + " is a known spammer.");
            } else {
                System.out.println(arg + " appears legitimate.");
            }
        }
    }

    private static boolean isSpammer(String arg) {
        try {
            // Resolve the input to an IP address
            InetAddress address = InetAddress.getByName(arg);
            byte[] quad = address.getAddress();
            String query = BLACKHOLE;
            // Reverse the IP address for blacklist query
            for (byte octet : quad) {
                int unsignedByte = octet < 0 ? octet + 256 : octet;
                query = unsignedByte + "." + query;
            }
            // Attempt to resolve the blacklist query
            InetAddress.getByName(query);
            return true; // Listed in blacklist
        } catch (UnknownHostException e) {
            return false; // Not listed in blacklist
        }
    }
}
```

**Sample Output (running with `java SpamCheck 104.21.79.8`):**
```
104.21.79.8 appears legitimate.
```

**Explanation:**
- We reverse the IP address and append it to the blacklist domain (`sbl.spamhaus.org`).
- If the query resolves, the IP is considered a spammer.
- The program handles multiple input arguments and includes proper exception handling.

---

## 8. Process Web Server Log Files

```java
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Processes a web server log file and converts IP addresses to hostnames.
 */
public class Weblog {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Usage: java Weblog <logfile>");
            return;
        }

        try (FileInputStream fin = new FileInputStream(args[0]);
             BufferedReader bin = new BufferedReader(new InputStreamReader(fin))) {
            String entry;
            // Read each line from the log file
            while ((entry = bin.readLine()) != null) {
                // Extract IP address (first word)
                int index = entry.indexOf(' ');
                String ip = entry.substring(0, index);
                String theRest = entry.substring(index);
                try {
                    // Resolve IP to hostname
                    InetAddress address = InetAddress.getByName(ip);
                    System.out.println(address.getHostName() + theRest);
                } catch (UnknownHostException e) {
                    System.err.println(entry); // Print original entry if resolution fails
                }
            }
        } catch (IOException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
}
```

**Sample Log File Input (`access.log`):**
```
104.21.79.8 - - [18/Sep/2025:10:00:00] "GET /index.html"
```

**Sample Output:**
```
www.javatpoint.com - - [18/Sep/2025:10:00:00] "GET /index.html"
```

**Explanation:**
- We read a log file line by line, extracting the IP address from each entry.
- The IP is resolved to a hostname using `InetAddress.getByName`.
- If resolution fails, the original log entry is printed to `System.err`.
- The program uses try-with-resources for proper resource management.

---

# Unit 3: URLs and URIs

## Lab 1: Check Supported Protocols

```java
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Tests which protocols are supported by the JVM.
 */
public class ProtocolTester {
    public static void main(String[] args) {
        // Test various protocols
        testProtocol("http://www.adc.org");
        testProtocol("https://www.amazon.com/exec/obidos/order2/");
        testProtocol("ftp://ibiblio.org/pub/languages/java/javafaq/");
        testProtocol("mailto:elharo@ibiblio.org");
        testProtocol("telnet://dibner.poly.edu/");
    }

    private static void testProtocol(String url) {
        try {
            URL u = new URL(url);
            System.out.println(u.getProtocol() + " is supported");
        } catch (MalformedURLException e) {
            String protocol = url.substring(0, url.indexOf(':'));
            System.err.println(protocol + " is not supported");
        }
    }
}
```

**Sample Output:**
```
http is supported
https is supported
ftp is supported
mailto is supported
telnet is not supported
```

**Explanation:**
- We attempt to create a `URL` object for each protocol.
- If the protocol is supported, the `URL` constructor succeeds; otherwise, it throws a `MalformedURLException`.
- The program extracts and reports the protocol name for unsupported URLs.

---

## Lab 2: Download a Web Page

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Downloads and prints the content of a web page.
 */
public class SourceViewer {
    public static void main(String[] args) {
        try {
            // Create a URL object
            URL url = new URL("http://google.com");
            // Open a stream and buffer it for reading
            try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))) {
                String line;
                // Read and print each line
                while ((line = in.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } catch (MalformedURLException e) {
            System.err.println("The provided URL is not valid: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading from the URL: " + e.getMessage());
        }
    }
}
```

**Sample Output (Partial):**
```
<!doctype html>
<html itemscope="" itemtype="http://schema.org/WebPage" lang="en">
<head>
    <meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
    <title>Google</title>
    ...
</head>
<body>
    ...
</body>
</html>
```

**Explanation:**
- We use `URL.openStream` to retrieve the web page content as a stream.
- `BufferedReader` is used for efficient reading of the content line by line.
- Try-with-resources ensures proper resource closure.
- Exception handling covers malformed URLs and I/O errors.

---

## Lab 3: Download an Object

```java
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Retrieves and identifies the content type of a URL resource.
 */
public class ContentGetter {
    public static void main(String[] args) {
        try {
            // Create a URL object
            URL url = new URL("https://www.oreilly.com");
            // Get the content object
            Object content = url.getContent();
            // Print the class name of the content
            System.out.println("I got a " + content.getClass().getName());
        } catch (MalformedURLException e) {
            System.err.println("The provided URL is not a valid URL: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error occurred: " + e.getMessage());
        }
    }
}
```

**Sample Output:**
```
I got a sun.net.www.protocol.http.HttpURLConnection$HttpInputStream
```

**Explanation:**
- `URL.getContent` retrieves the resource as an object (typically an `InputStream` for HTTP URLs).
- We print the class name to identify the type of content retrieved.
- Exception handling ensures robustness for malformed URLs and I/O errors.

---

## Lab 4: The Parts of a URL

```java
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Splits and prints the components of a URL.
 */
public class URLSplitter {
    public static void main(String[] args) {
        try {
            // Create a URL object
            URL url = new URL("https://www.example.com:8080/path/to/resource?name=SharatMaharjan#section");
            // Print URL components
            System.out.println("The URL is: " + url);
            System.out.println("The scheme is: " + url.getProtocol());
            System.out.println("The user info is: " + url.getUserInfo());
            System.out.println("The host is: " + url.getHost());
            System.out.println("The port is: " + url.getPort());
            System.out.println("The path is: " + url.getPath());
            System.out.println("The ref (fragment) is: " + url.getRef());
            System.out.println("The query string is: " + url.getQuery());
        } catch (MalformedURLException e) {
            System.err.println("It is not a URL I understand: " + e.getMessage());
        }
    }
}
```

**Sample Output:**
```
The URL is: https://www.example.com:8080/path/to/resource?name=SharatMaharjan#section
The scheme is: https
The user info is: null
The host is: www.example.com
The port is: 8080
The path is: /path/to/resource
The ref (fragment) is: section
The query string is: name=SharatMaharjan
```

**Explanation:**
- We use various `URL` methods to extract components like protocol, host, port, path, query, and fragment.
- The program handles malformed URLs gracefully with exception handling.
- The output clearly displays each component of the URL.

---

## Lab 5: Checking URL Equality

```java
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Checks if two URLs resolve to the same address.
 */
public class URLEquality {
    public static void main(String[] args) {
        try {
            // Define two URL objects
            URL www = new URL("http://www.ibiblio.org/");
            URL ibiblio = new URL("http://ibiblio.org/");
            // Compare the URLs
            if (ibiblio.equals(www)) {
                System.out.println(ibiblio + " is the same as " + www);
            } else {
                System.out.println(ibiblio + " is not the same as " + www);
            }
        } catch (MalformedURLException e) {
            System.err.println("Invalid URL format: " + e.getMessage());
        }
    }
}
```

**Sample Output:**
```
http://ibiblio.org/ is the same as http://www.ibiblio.org/
```

**Explanation:**
- URL.equals() checks both IP resolution and the full URL structure (protocol, host, port, and path).
- Exception handling ensures robustness for malformed URLs.

---

## Lab 6: The Parts of a URI

```java
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Splits and prints the components of a URI.
 */
public class URISplitter {
    public static void main(String[] args) {
        try {
            // Create a URI object
            URI u = new URI("https://www.prime.edu.np/");
            System.out.println("The URI is " + u);
            // Check if the URI is opaque or hierarchical
            if (u.isOpaque()) {
                System.out.println("This is an opaque URI.");
                System.out.println("The scheme is " + u.getScheme());
                System.out.println("The scheme specific part is " + u.getSchemeSpecificPart());
                System.out.println("The fragment ID is " + u.getFragment());
            } else {
                System.out.println("This is a hierarchical URI.");
                System.out.println("The scheme is " + u.getScheme());
                System.out.println("The host is " + u.getHost());
                System.out.println("The user info is " + u.getUserInfo());
                System.out.println("The port is " + u.getPort());
                System.out.println("The path is " + u.getPath());
                System.out.println("The query string is " + u.getQuery());
                System.out.println("The fragment ID is " + u.getFragment());
            }
        } catch (URISyntaxException e) {
            System.err.println("Does not seem to be a valid URI: " + e.getMessage());
        }
    }
}
```

**Sample Output:**
```
The URI is https://www.prime.edu.np/
This is a hierarchical URI.
The scheme is https
The host is www.prime.edu.np
The user info is null
The port is -1
The path is /
The query string is null
The fragment ID is null
```

**Explanation:**
- We use `URI.isOpaque` to determine if the URI is opaque (e.g., `mailto:`) or hierarchical (e.g., `https:`).
- Hierarchical URIs are split into components like scheme, host, port, path, query, and fragment.
- Exception handling ensures robustness for invalid URIs.

---

## Lab 7: x-www-form-urlencoded Strings

```java
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Encodes various strings into x-www-form-urlencoded format.
 */
public class Example7 {
    public static void main(String[] args) {
        try {
            // Encode various strings using UTF-8
            System.out.println(URLEncoder.encode("This string has spaces", "UTF-8"));
            System.out.println(URLEncoder.encode("This*string*has*asterisks", "UTF-8"));
            System.out.println(URLEncoder.encode("This%string%has%percent%signs", "UTF-8"));
            System.out.println(URLEncoder.encode("This+string+has+pluses", "UTF-8"));
            System.out.println(URLEncoder.encode("This/string/has/slashes", "UTF-8"));
            System.out.println(URLEncoder.encode("This\"string\"has\"quote\"marks", "UTF-8"));
            System.out.println(URLEncoder.encode("This:string:has:colons", "UTF-8"));
            System.out.println(URLEncoder.encode("This~string~has~tildes", "UTF-8"));
            System.out.println(URLEncoder.encode("This(string)has(parentheses)", "UTF-8"));
            System.out.println(URLEncoder.encode("This.string.has.periods", "UTF-8"));
            System.out.println(URLEncoder.encode("This=string=has=equals=signs", "UTF-8"));
            System.out.println(URLEncoder.encode("This&string&has&ampersands", "UTF-8"));
            System.out.println(URLEncoder.encode("Thiséstringéhasénon-ASCII characters", "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            System.err.println("Encoding not supported: " + e.getMessage());
        }
    }
}
```

**Sample Output:**
```
This%20string%20has%20spaces
This%2Astring%2Ahas%2Aasterisks
This%25string%25has%25percent%25signs
This%2Bstring%2Bhas%2Bpluses
This%2Fstring%2Fhas%2Fslashes
This%22string%22has%22quote%22marks
This%3Astring%3Ahas%3Acolons
This%7Estring%7Ehas%7Etildes
This%28string%29has%28parentheses%29
This.string.has.periods
This%3Dstring%3Dhas%3Dequals%3Dsigns
This%26string%26has%26ampersands
This%C3%A9string%C3%A9has%C3%A9non-ASCII%20characters
```

**Explanation:**
- We use `URLEncoder.encode` to convert special characters into their percent-encoded equivalents.
- The program demonstrates encoding for spaces, special characters, and non-ASCII characters.
- UTF-8 is used as the encoding scheme, with exception handling for unsupported encodings.

---

## Lab 8: URLDecoder

```java
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Decodes x-www-form-urlencoded strings back to their original form.
 */
public class ExampleDecoder {
    public static void main(String[] args) {
        try {
            // Decode strings with encoded characters
            System.out.println(URLDecoder.decode("This+string+has+spaces", "UTF-8"));
            System.out.println(URLDecoder.decode("This%25string%25has%25percent%25signs", "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            System.err.println("Encoding not supported: " + e.getMessage());
        }
    }
}
```

**Sample Output:**
```
This string has spaces
This%string%has%percent%signs
```

**Explanation:**
- We use `URLDecoder.decode` to convert encoded strings back to their original form.
- The program handles `+` (spaces) and `%25` (percent signs) correctly.
- Exception handling ensures robustness for unsupported encodings.

---

# Unit 4: HTTP

## Significance of Controlling HTTP Keep-Alive System Properties

**HTTP Keep-Alive** allows a single TCP connection to handle multiple HTTP requests/responses, reducing connection overhead.

### Significance:
1. **Performance Improvement**:
   - Reusing connections minimizes TCP handshake latency.
   - Speeds up page loads for multiple requests.
2. **Resource Management**:
   - Properly tuned timeouts prevent resource exhaustion.
   - Limits the number of open connections.
3. **Load Balancing & Scalability**:
   - Optimizes server throughput in high-traffic scenarios.
4. **Energy Efficiency**:
   - Reduces CPU usage and battery drain on devices.
5. **Custom Control**:
   - Java system properties like `http.keepAlive`, `http.maxConnections`, and `http.keepAlive.duration` allow fine-tuning.

---

## Lab 1: Cookie Policy to Block `.gov` Cookies

```java
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Implements a cookie policy that blocks cookies from .gov domains.
 */
public class CustomCookiePolicy {
    public static void main(String[] args) {
        // Create a CookieManager with a custom policy
        CookieManager manager = new CookieManager(null, new CookiePolicy() {
            @Override
            public boolean shouldAccept(URI uri, HttpCookie cookie) {
                if (uri.getHost().endsWith(".gov")) {
                    System.out.println("Blocked cookie from: " + uri.getHost() + " -> " + cookie);
                    return false;
                }
                System.out.println("Allowed cookie from: " + uri.getHost() + " -> " + cookie);
                return true;
            }
        });

        // Set the custom cookie handler
        CookieHandler.setDefault(manager);

        try {
            // Test with a sample URL
            URL url = new URL("http://example.com");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }
            System.out.println("Request finished.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
```

**Sample Output (for `http://example.com`):**
```
Allowed cookie from: example.com -> user=sharat
<!DOCTYPE html>
<html>
<head><title>Example Domain</title></head>
<body>
...
</body>
</html>
Request finished.
```

**Sample Output (for `http://whitehouse.gov`):**
```
Blocked cookie from: whitehouse.gov -> sessionid=XYZ123
...
Request finished.
```

**Explanation:**
- We create a `CookieManager` with a custom `CookiePolicy` that blocks `.gov` domains.
- `CookieHandler.setDefault` applies the policy globally.
- The program tests the policy with an HTTP request, printing the response.

---

# Unit 5: URLConnection

## Lab 1: Demonstrating `URLConnection`

```java
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Retrieves and prints the content type of a URL resource.
 */
public class URLConnectionExample {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.prime.edu.np/");
            URLConnection urlConnection = url.openConnection();
            System.out.println("Content Type: " + urlConnection.getContentType());
        } catch (MalformedURLException e) {
            System.err.println("Error: The URL is not properly formatted: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error: Unable to connect to the URL: " + e.getMessage());
        }
    }
}
```

**Sample Output:**
```
Content Type: text/html; charset=UTF-8
```

**Explanation:**
- We use `URLConnection.getContentType` to retrieve the MIME type of the resource.
- Try-catch blocks handle malformed URLs and connection issues.
- The program is concise and focused on demonstrating `URLConnection`.

---

## Lab 2: Downloading a Web Page Using `URLConnection`

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Downloads and prints the content of a web page using URLConnection.
 */
public class DownloadWebPage {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.prime.edu.np/");
            URLConnection urlConnection = url.openConnection();
            try (BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))) {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println(inputLine);
                }
            }
        } catch (MalformedURLException e) {
            System.err.println("Error: The URL is not properly formatted: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error: Unable to retrieve web page content: " + e.getMessage());
        }
    }
}
```

**Sample Output (Partial):**
```
<!doctype html>
<html dir="ltr" lang="en-US" prefix="og: https://ogp.me/ns#">
<head>
    <meta charset="UTF-8">
    <title>Prime College</title>
    ...
</head>
<body>
    ...
</body>
</html>
```

**Explanation:**
- We use `URLConnection.getInputStream` to read the web page content.
- `BufferedReader` ensures efficient reading.
- Try-with-resources manages resource closure.
- Exception handling covers malformed URLs and I/O errors.

---

## Lab 3: Retrieving HTTP Headers Using `URLConnection`

```java
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

/**
 * Retrieves and prints HTTP headers from a URL.
 */
public class URLHeaderInfo {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.prime.edu.np/");
            URLConnection urlConnection = url.openConnection();
            System.out.println("Content-type: " + urlConnection.getContentType());
            if (urlConnection.getContentEncoding() != null) {
                System.out.println("Content-encoding: " + urlConnection.getContentEncoding());
            }
            if (urlConnection.getDate() != 0) {
                System.out.println("Date: " + new Date(urlConnection.getDate()));
            }
            if (urlConnection.getLastModified() != 0) {
                System.out.println("Last modified: " + new Date(urlConnection.getLastModified()));
            }
            if (urlConnection.getExpiration() != 0) {
                System.out.println("Expiration date: " + new Date(urlConnection.getExpiration()));
            }
            if (urlConnection.getContentLength() != -1) {
                System.out.println("Content-length: " + urlConnection.getContentLength());
            }
        } catch (MalformedURLException e) {
            System.err.println("Error: It is not a valid URL: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
```

**Sample Output:**
```
Content-type: text/html; charset=UTF-8
Date: Fri Sep 19 12:45:13 NPT 2025
Last modified: Thu Jan 01 05:30:00 NPT 1970
Expiration date: Thu Jan 01 05:30:00 NPT 1970
```

**Explanation:**
- We retrieve various HTTP headers using `URLConnection` methods.
- Checks for `0` or `null` ensure headers are only printed if available.
- Exception handling ensures robustness.

---

## Lab 4: Printing the Entire HTTP Header

```java
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Prints all HTTP headers from a URL connection.
 */
public class HTTPHeaderPrinter {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.prime.edu.np/");
            URLConnection urlConnection = url.openConnection();
            int i = 1;
            while (urlConnection.getHeaderField(i) != null) {
                System.out.println(urlConnection.getHeaderFieldKey(i) + ": " + urlConnection.getHeaderField(i));
                i++;
            }
        } catch (MalformedURLException e) {
            System.err.println("Error: It is not a valid URL: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
```

**Sample Output:**
```
Date: Fri, 19 Sep 2025 12:45:31 GMT
Content-Type: text/html; charset=UTF-8
Transfer-Encoding: chunked
Connection: keep-alive
x-powered-by: PHP/7.4.33
link: <https://prime.edu.np/wp-json/>; rel="https://api.w.org/"
...
Server: cloudflare
```

**Explanation:**
- We iterate through header fields using `getHeaderField` and `getHeaderFieldKey`.
- The loop stops when no more headers are available.
- Exception handling covers malformed URLs and I/O errors.

---

## Lab 5: Printing the URL of a `URLConnection`

```java
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Prints the URL associated with a URLConnection.
 */
public class URLPrinter {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.oreilly.com/");
            URLConnection urlConnection = url.openConnection();
            System.out.println("Connected URL: " + urlConnection.getURL());
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
```

**Sample Output:**
```
Connected URL: https://www.oreilly.com/
```

**Explanation:**
- `URLConnection.getURL` retrieves the URL, accounting for possible redirects.
- The output may reflect a redirect (e.g., HTTP to HTTPS).
- Exception handling ensures robustness.

---

## Lab 6: Print All Responses from Server

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Prints the HTTP status and all response headers and content from a server.
 */
public class Example6 {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.prime.edu.np");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            int responseCode = connection.getResponseCode();
            String responseMessage = connection.getResponseMessage();
            System.out.println("HTTP/1.x " + responseCode + " " + responseMessage);
            int headerIndex = 1;
            while (connection.getHeaderField(headerIndex) != null) {
                System.out.println(connection.getHeaderFieldKey(headerIndex) + ": " + connection.getHeaderField(headerIndex));
                headerIndex++;
            }
            System.out.println("\n--- Response Content ---");
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } catch (MalformedURLException e) {
            System.err.println("Invalid URL format: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error in connection: " + e.getMessage());
        }
    }
}
```

**Sample Output (Partial):**
```
HTTP/1.x 200 OK
Date: Fri, 19 Sep 2025 12:45:36 GMT
Content-Type: text/html; charset=UTF-8
...
--- Response Content ---
<!doctype html>
<html dir="ltr" lang="en-US">
<head>
    <meta charset="UTF-8">
    <title>Prime College</title>
    ...
</head>
<body>
    ...
</body>
</html>
```

**Explanation:**
- We use `HttpURLConnection` to retrieve the HTTP status, headers, and content.
- Headers are printed using a loop, and content is read line by line.
- Try-with-resources ensures proper resource closure.

---

# Unit 6: Socket for Clients

## Lab 1: Port Scanner (Ports 1-1024)

```java
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Scans ports 1 to 1024 on localhost to find active TCP servers.
 */
public class PortScanner {
    public static void main(String[] args) {
        int startPort = 1;
        int endPort = 1024;
        for (int port = startPort; port <= endPort; port++) {
            try (Socket socket = new Socket("localhost", port)) {
                System.out.println("Server is running on port " + port + " of localhost.");
            } catch (UnknownHostException e) {
                System.err.println("Unknown host: " + e.getMessage());
                break;
            } catch (IOException e) {
                System.out.println("No server is running on port " + port + " of localhost.");
            }
        }
    }
}
```

**Sample Output (Partial):**
```
No server is running on port 1 of localhost.
No server is running on port 2 of localhost.
...
Server is running on port 80 of localhost.
...
No server is running on port 1024 of localhost.
```

**Explanation:**
- We attempt to connect to each port using a `Socket`.
- Successful connections indicate an active server.
- Try-with-resources ensures sockets are closed properly.

---

## Lab 2: High Port Scanner (Ports 1024-65535)

```java
import java.io.IOException;
import java.net.Socket;

/**
 * Scans ports 1024 to 65535 on localhost for active TCP servers.
 */
public class HighPortScanner {
    public static void main(String[] args) {
        int startPort = 1024;
        int endPort = 65535;
        for (int port = startPort; port <= endPort; port++) {
            try (Socket socket = new Socket("localhost", port)) {
                System.out.println("Server is running on port " + port + " of localhost.");
            } catch (IOException e) {
                // Silently skip closed ports
            }
        }
    }
}
```

**Sample Output (Partial):**
```
Server is running on port 8080 of localhost.
Server is running on port 3306 of localhost.
```

**Explanation:**
- Similar to Lab 1, but scans higher ports.
- Closed ports are ignored to reduce output verbosity.
- Try-with-resources ensures proper socket closure.

---

## Lab 3: Socket Information

```java
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Connects to a host and prints socket connection details.
 */
public class SocketInfoExample {
    public static void main(String[] args) {
        String host = "www.prime.edu.np";
        int port = 80;
        try (Socket socket = new Socket(host, port)) {
            System.out.println("Connected to remote host: " + socket.getInetAddress());
            System.out.println("Remote port: " + socket.getPort());
            System.out.println("Local address: " + socket.getLocalAddress());
            System.out.println("Local port: " + socket.getLocalPort());
        } catch (UnknownHostException e) {
            System.err.println("Error: Unable to find the host '" + host + "': " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error: Could not connect to the host '" + host + "': " + e.getMessage());
        }
    }
}
```

**Sample Output:**
```
Connected to remote host: www.prime.edu.np/104.21.83.162
Remote port: 80
Local address: /192.168.1.10
Local port: 54321
```

**Explanation:**
- We connect to a specified host and port using a `Socket`.
- Methods like `getInetAddress`, `getPort`, `getLocalAddress`, and `getLocalPort` provide connection details.
- Try-with-resources ensures the socket is closed.

---

## Lab 4: Echo Client and Server

### a. EchoClient.java

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * A client that sends messages to an echo server and receives the echoed response.
 */
public class EchoClient {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int serverPort = 4567;
        try (Socket clientSocket = new Socket(serverAddress, serverPort);
             BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter pw = new PrintWriter(clientSocket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {
            System.out.println("Connected to server...");
            while (true) {
                System.out.print("Enter text: ");
                String inputLine = scanner.nextLine();
                if (inputLine.equalsIgnoreCase("quit")) {
                    System.out.println("Closing connection...");
                    break;
                }
                pw.println(inputLine);
                String response = br.readLine();
                System.out.println("Server: " + response);
            }
        } catch (IOException e) {
            System.err.println("Error: Unable to connect to the server: " + e.getMessage());
        }
    }
}
```

### b. EchoServer.java

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * An echo server that receives messages from a client and echoes them back.
 */
public class EchoServer {
    public static void main(String[] args) {
        int port = 4567;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("EchoServer is running on port " + port + "...");
            try (Socket clientSocket = serverSocket.accept();
                 BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter pw = new PrintWriter(clientSocket.getOutputStream(), true)) {
                System.out.println("Client connected: " + clientSocket.getInetAddress());
                String inputLine;
                while ((inputLine = br.readLine()) != null) {
                    System.out.println("Received from client: " + inputLine);
                    pw.println(inputLine);
                    System.out.println("Sent to client: " + inputLine);
                }
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
```

**Sample Output (Client):**
```
Connected to server...
Enter text: hello
Server: hello
Enter text: quit
Closing connection...
```

**Sample Output (Server):**
```
EchoServer is running on port 4567...
Client connected: /127.0.0.1
Received from client: hello
Sent to client: hello
```

**Explanation:**
- The client sends messages to the server, which echoes them back.
- Try-with-resources ensures all resources (sockets, streams, scanner) are closed.
- The client exits on "quit" input.

---

## Lab 5: Whois GUI

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

/**
 * A GUI application for performing Whois lookups.
 */
public class WhoisGUI extends JFrame {
    private JTextField domainField;
    private JTextArea resultArea;

    public WhoisGUI() {
        setTitle("Whois Lookup");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Input panel
        JPanel inputPanel = new JPanel(new FlowLayout());
        JLabel domainLabel = new JLabel("Enter Domain:");
        domainField = new JTextField(20);
        domainField.addActionListener(e -> {
            String domain = domainField.getText().trim();
            if (!domain.isEmpty()) {
                lookupWhois(domain);
            }
        });
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> {
            String domain = domainField.getText().trim();
            if (!domain.isEmpty()) {
                lookupWhois(domain);
            }
        });
        inputPanel.add(domainLabel);
        inputPanel.add(domainField);
        inputPanel.add(submitButton);

        // Result panel
        JPanel resultPanel = new JPanel(new BorderLayout());
        JLabel resultLabel = new JLabel("Whois Result:");
        resultArea = new JTextArea(20, 50);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        resultPanel.add(resultLabel, BorderLayout.NORTH);
        resultPanel.add(scrollPane, BorderLayout.CENTER);

        // Add panels to frame
        add(inputPanel, BorderLayout.NORTH);
        add(resultPanel, BorderLayout.CENTER);
    }

    private void lookupWhois(String domain) {
        String whoisServer = "whois.verisign-grs.com";
        int port = 43;
        try (Socket socket = new Socket(whoisServer, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            out.println(domain);
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                response.append(line).append("\n");
            }
            SwingUtilities.invokeLater(() -> {
                resultArea.setText(response.toString());
                resultArea.setCaretPosition(0);
            });
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error performing Whois lookup: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            WhoisGUI gui = new WhoisGUI();
            gui.setVisible(true);
        });
    }
}
```

**Sample Output (GUI):**
```
[User enters "example.com" in the text field and clicks Submit]
[Result area displays:]
Domain Name: EXAMPLE.COM
Registry Domain ID: 2336799_DOMAIN_COM-VRSN
Registrar WHOIS Server: whois.iana.org
...
```

**Explanation:**
- We create a Swing GUI with a text field for domain input and a text area for results.
- The `lookupWhois` method connects to a Whois server and retrieves domain information.
- `SwingUtilities.invokeLater` ensures thread-safe GUI updates.

---

## Lab 6: Network Client

### a. SimpleChatServer.java

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * A multi-client chat server that broadcasts messages to all connected clients.
 */
public class SimpleChatServer {
    private static final int PORT = 9000;
    private static final List<ClientHandler> clients = new ArrayList<>();
    private static int nextUserId = 1;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is running on port " + PORT);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected");
                ClientHandler clientHandler = new ClientHandler(clientSocket, "User" + nextUserId++);
                clients.add(clientHandler);
                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            System.err.println("Server exception: " + e.getMessage());
        }
    }

    static class ClientHandler implements Runnable {
        private final Socket clientSocket;
        private final PrintWriter out;
        private final BufferedReader in;
        private final String username;

        public ClientHandler(Socket socket, String username) {
            this.clientSocket = socket;
            this.username = username;
            try {
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            } catch (IOException e) {
                throw new RuntimeException("Error setting up streams: " + e.getMessage());
            }
        }

        @Override
        public void run() {
            try {
                out.println("You are connected as: " + username);
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println(username + ": " + message);
                    broadcastMessage(username + ": " + message, this);
                }
            } catch (IOException e) {
                System.err.println("Client error: " + e.getMessage());
            } finally {
                try {
                    clients.remove(this);
                    in.close();
                    out.close();
                    clientSocket.close();
                    System.out.println(username + " disconnected");
                } catch (IOException e) {
                    System.err.println("Error closing resources: " + e.getMessage());
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
```

### b. SimpleNetworkClientGUI.java

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

/**
 * A GUI-based client for a multi-user chat application.
 */
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

        // Connection panel
        JPanel connectionPanel = new JPanel(new FlowLayout());
        serverAddressField = new JTextField("localhost", 15);
        portField = new JTextField("9000", 5);
        JButton connectButton = new JButton("Connect");
        connectButton.addActionListener(e -> connectToServer());
        connectionPanel.add(new JLabel("Server Address:"));
        connectionPanel.add(serverAddressField);
        connectionPanel.add(new JLabel("Port:"));
        connectionPanel.add(portField);
        connectionPanel.add(connectButton);

        // Chat area
        JPanel chatPanel = new JPanel(new BorderLayout());
        chatArea = new JTextArea(15, 50);
        chatArea.setEditable(false);
        chatPanel.add(new JScrollPane(chatArea), BorderLayout.CENTER);

        // Message area
        JPanel messagePanel = new JPanel(new BorderLayout());
        messageArea = new JTextArea(5, 50);
        messageArea.setLineWrap(true);
        messageArea.setWrapStyleWord(true);
        messagePanel.add(new JScrollPane(messageArea), BorderLayout.CENTER);
        sendButton = new JButton("Send");
        sendButton.setPreferredSize(new Dimension(80, 30));
        sendButton.addActionListener(e -> sendMessage());
        messagePanel.add(sendButton, BorderLayout.EAST);

        // Add panels to frame
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
            new Thread(() -> {
                try {
                    String message;
                    while ((message = in.readLine()) != null) {
                        appendToChatArea(message);
                    }
                } catch (IOException e) {
                    appendToChatArea("Error: " + e.getMessage());
                }
            }).start();
        } catch (IOException e) {
            appendToChatArea("Error connecting to server: " + e.getMessage());
        }
    }

    private void sendMessage() {
        if (out != null) {
            String message = messageArea.getText().trim();
            if (!message.isEmpty()) {
                out.println(message);
                appendToChatArea("You: " + message);
                messageArea.setText("");
            }
        }
    }

    private void appendToChatArea(String message) {
        SwingUtilities.invokeLater(() -> {
            chatArea.append(message + "\n");
            chatArea.setCaretPosition(chatArea.getDocument().getLength());
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SimpleNetworkClientGUI clientGUI = new SimpleNetworkClientGUI();
            clientGUI.setVisible(true);
        });
    }
}
```

**Sample Output (Server):**
```
Server is running on port 9000
New client connected
User1: Hello everyone!
```

**Sample Output (Client GUI):**
```
Connected to server at localhost:9000
You are connected as: User1
You: Hello everyone!
User2: Hi there!
```

**Explanation:**
- The server supports multiple clients, broadcasting messages to all except the sender.
- The client GUI allows users to connect, send, and receive messages.
- Thread safety is ensured with `SwingUtilities.invokeLater`.

---

# Unit 7: Server Socket

## Lab 1: A Multithreaded Daytime Server

### a. `DaytimeServer.java`

```java
import java.io.*;
import java.net.*;
import java.util.Date;

/**
 * A multithreaded server that sends the current date and time to clients.
 */
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

**Sample Output (Server side):**
```
Daytime server started on port 1234...
New client connected: /127.0.0.1
Client disconnected: /127.0.0.1
```

**Explanation:**
- We create a server socket on port 1234 to listen for client connections.
- For each client connection, we spawn a new `DaytimeThread` to handle the request.
- The thread sends the current date and time to the client and closes the connection.

### b. `DaytimeClient.java`

```java
import java.io.*;
import java.net.*;

/**
 * A client that connects to a Daytime server to retrieve the current date and time.
 */
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

**Sample Output (Client side):**
```
Server time: Fri Sep 19 13:04:05 NPT 2025
```

**Explanation:**
- We connect to the server at `localhost:1234` using a `Socket`.
- We read the server's response (current date and time) and print it.
- The socket is automatically closed using try-with-resources.

---

## Lab 2: MultiThreaded Binary Server and Client

### a. `MultiThreadedBinaryServer.java`

```java
import java.io.*;
import java.net.*;

/**
 * A multithreaded server that sends binary data to clients.
 */
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

/**
 * Thread class to handle client connections and send binary data.
 */
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
```

**Sample Output (Server side):**
```
Server is listening on port 12345
New client connected
Sent binary data to client
Client disconnected
```

**Explanation:**
- We create a server socket on port 12345 to accept client connections.
- For each connection, we spawn a `ServerThread` that sends a fixed byte array `{1, 2, 3, 4, 5}` to the client.
- The thread closes the socket after sending the data.

### b. `BinaryDataClient.java`

```java
import java.io.*;
import java.net.*;

/**
 * A client that receives binary data from a server.
 */
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
```

**Sample Output (Client side):**
```
Received binary data from server:
1 2 3 4 5
```

**Explanation:**
- We connect to the server at `localhost:12345` using a `Socket`.
- We read exactly 5 bytes of binary data from the server using `DataInputStream`.
- The received bytes are printed to the console.

---

## Lab 3: Logging

### a. `LoggedServer.java`

```java
import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A server that sends the current date and time to clients with logging.
 */
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
```

**Sample Output (Server side):**
```
Sep 19, 2025 1:04:05 PM LoggedServer main
INFO: Server is listening on port 12345
Sep 19, 2025 1:04:10 PM LoggedServer main
INFO: New client connected
Sep 19, 2025 1:04:10 PM LoggedServer$DaytimeThread run
INFO: Sent date to client: Fri Sep 19 13:04:10 NPT 2025
Sep 19, 2025 1:04:10 PM LoggedServer$DaytimeThread run
INFO: Client disconnected
```

**Explanation:**
- We use Java's `Logger` to log server events such as starting, client connections, and sending data.
- The server listens on port 12345 and spawns a `DaytimeThread` for each client.
- Each thread sends the current date and time to the client and logs the action.

### b. `LoggedClient.java`

```java
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A client that connects to a server to retrieve the current date and time with logging.
 */
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
```

**Sample Output (Client side):**
```
Sep 19, 2025 1:04:10 PM LoggedClient main
INFO: Connected to server
Sep 19, 2025 1:04:10 PM LoggedClient main
INFO: Received server time: Fri Sep 19 13:04:10 NPT 2025
```

**Explanation:**
- We connect to the server at `localhost:12345` and log the connection event.
- We read the server's response (current date and time) and log it.
- The socket is closed automatically using try-with-resources.

---

## Lab 4: Server Socket Options

### a. `TimeoutServer.java` (SO_TIMEOUT)

```java
import java.io.*;
import java.net.*;

/**
 * A server that demonstrates the SO_TIMEOUT socket option.
 */
public class TimeoutServer {
    public static void main(String[] args) {
        int port = 12345;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            serverSocket.setSoTimeout(5000); // Set timeout to 5000 milliseconds (5 seconds)
            System.out.println("TimeoutServer is listening on port " + port);

            while (true) {
                try {
                    Socket socket = serverSocket.accept(); // This will block for up to 5 seconds
                    System.out.println("New client connected to TimeoutServer");
                    // Handle the client connection
                } catch (SocketTimeoutException e) {
                    System.out.println("Accept timed out, no incoming connection in 5 seconds");
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
```

**Sample Output (Server side, no client connecting):**
```
TimeoutServer is listening on port 12345
Accept timed out, no incoming connection in 5 seconds
Accept timed out, no incoming connection in 5 seconds
```

**Explanation:**
- We set the `SO_TIMEOUT` option to 5 seconds, causing `accept()` to throw a `SocketTimeoutException` if no client connects within that time.
- The server continues to listen after each timeout.

### b. `ReuseAddressServer.java` (SO_REUSEADDR)

```java
import java.io.*;
import java.net.*;

/**
 * A server that demonstrates the SO_REUSEADDR socket option.
 */
public class ReuseAddressServer {
    public static void main(String[] args) {
        int port = 12345;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            serverSocket.setReuseAddress(true); // Enable SO_REUSEADDR
            System.out.println("ReuseAddressServer is listening on port " + port);

            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    System.out.println("New client connected to ReuseAddressServer");
                    // Handle the client connection
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
```

**Sample Output (Server side):**
```
ReuseAddressServer is listening on port 12345
New client connected to ReuseAddressServer
```

**Explanation:**
- We enable `SO_REUSEADDR` to allow the server to bind to the port even if it was recently used.
- This is useful for restarting the server without waiting for the port to be released.

### c. `ReceiveBufferServer.java` (SO_RCVBUF)

```java
import java.io.*;
import java.net.*;

/**
 * A server that demonstrates the SO_RCVBUF socket option.
 */
public class ReceiveBufferServer {
    public static void main(String[] args) {
        int port = 12345;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            serverSocket.setReceiveBufferSize(65536); // Set receive buffer size to 64 KB
            System.out.println("ReceiveBufferServer is listening on port " + port);

            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    System.out.println("New client connected to ReceiveBufferServer with receive buffer size: " +
                            socket.getReceiveBufferSize());
                    // Handle the client connection
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
```

**Sample Output (Server side):**
```
ReceiveBufferServer is listening on port 12345
New client connected to ReceiveBufferServer with receive buffer size: 65536
```

**Explanation:**
- We set the receive buffer size to 64 KB using `setReceiveBufferSize`.
- The buffer size is logged when a client connects, though the actual size may depend on the OS.

### d. `SimpleClient.java`

```java
import java.io.*;
import java.net.*;

/**
 * A simple client that connects to a server and reads its response.
 */
public class SimpleClient {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 12345;

        try (Socket socket = new Socket(hostname, port)) {
            System.out.println("Connected to the server");

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String serverResponse = input.readLine();
            System.out.println("Server response: " + serverResponse);
        } catch (IOException ex) {
            System.out.println("Client exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
```

**Sample Output (Client side, assuming used with `LoggedServer`):**
```
Connected to the server
Server response: Fri Sep 19 13:04:10 NPT 2025
```

**Explanation:**
- We connect to the server at `localhost:12345` and read a single line of response.
- This client is generic and can work with servers like `TimeoutServer`, `ReuseAddressServer`, or `LoggedServer`.

---

## Lab 5: HTTP Servers

### a. `SingleFileServer.java`

```java
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

/**
 * A simple HTTP server that serves a single HTML file from a URL.
 */
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
```

**Sample Output (Server side):**
```
SingleFileServer is listening on port 8080
New client connected
Request: GET / HTTP/1.1
```

**Sample Output (Client side, via browser):**
```
[Contents of index.html displayed in the browser]
```

**Explanation:**
- We fetch an HTML file from a specified URL and serve it to clients via HTTP.
- The server listens on port 8080, responds to GET requests with the HTML content, and includes proper HTTP headers.

### b. `Redirector.java`

```java
import java.io.*;
import java.net.*;

/**
 * An HTTP server that redirects clients to a specified URL.
 */
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
```

**Sample Output (Server side):**
```
Redirector is listening on port 8080
New client connected
Request: GET / HTTP/1.1
```

**Sample Output (Client side, via browser):**
```
[Browser redirects to http://example.com]
```

**Explanation:**
- We create an HTTP server that responds to GET requests with a 302 redirect to `http://example.com`.
- The server listens on port 8080 and sends the `Location` header to instruct the client to redirect.

### c. `FullFledgedHttpServer.java`

```java
import com.sun.net.httpserver.*;
import java.io.*;
import java.net.InetSocketAddress;

/**
 * A full-fledged HTTP server using Java's HttpServer API with multiple endpoints.
 */
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
```

**Sample Output (Server side):**
```
FullFledgedHttpServer is listening on port 8080
```

**Sample Output (Client side, via browser):**
- For `http://localhost:8080/`:
```
Welcome to the Full-Fledged HTTP Server!
```
- For `http://localhost:8080/hello`:
```
Hello, world!
```

**Explanation:**
- We use Java’s `HttpServer` API to create a server with two endpoints: `/` and `/hello`.
- The server listens on port 8080 and responds with different messages based on the requested path.

---

## Lab 6: Two-way Chat Application

### a. `ChatServer.java`

```java
import java.io.*;
import java.net.*;

/**
 * A server for a two-way chat application using TCP.
 */
public class ChatServer {
    public static void main(String[] args) throws IOException {
        int port = 4567;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("ChatServer is running on port " + port);

        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected: " + clientSocket.getInetAddress());

        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        // Thread to read messages from client
        Thread readThread = new Thread(() -> {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Client: " + message);
                }
            } catch (IOException e) {
                System.out.println("Connection closed.");
            }
        });
        readThread.start();

        // Main thread to send messages to client
        String line;
        while ((line = console.readLine()) != null) {
            if (line.equalsIgnoreCase("quit")) break;
            out.println(line);
        }

        clientSocket.close();
        serverSocket.close();
        System.out.println("Server closed.");
    }
}
```

**Sample Output (Server side):**
```
ChatServer is running on port 4567
Client connected: /127.0.0.1
Client: Hello, server!
[Server types: Hi, client!]
Client: How are you?
[Server types: I'm doing great!]
[Server types: quit]
Server closed.
```

**Explanation:**
- We create a TCP server on port 4567 that accepts a single client connection.
- A separate thread reads messages from the client, while the main thread sends messages typed in the console.
- The server exits when the user types "quit".

### b. `ChatClient.java`

```java
import java.io.*;
import java.net.*;

/**
 * A client for a two-way chat application using TCP.
 */
public class ChatClient {
    public static void main(String[] args) throws IOException {
        String serverAddress = "localhost";
        int port = 4567;

        Socket socket = new Socket(serverAddress, port);
        System.out.println("Connected to server.");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        // Thread to read messages from server
        Thread readThread = new Thread(() -> {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Server: " + message);
                }
            } catch (IOException e) {
                System.out.println("Connection closed.");
            }
        });
        readThread.start();

        // Main thread to send messages to server
        String line;
        while ((line = console.readLine()) != null) {
            if (line.equalsIgnoreCase("quit")) break;
            out.println(line);
        }

        socket.close();
        System.out.println("Client closed.");
    }
}
```

**Sample Output (Client side):**
```
Connected to server.
[Client types: Hello, server!]
Server: Hi, client!
[Client types: How are you?]
Server: I'm doing great!
[Client types: quit]
Client closed.
```

**Explanation:**
- We connect to the server at `localhost:4567` using a `Socket`.
- A separate thread reads messages from the server, while the main thread sends console input to the server.
- The client exits when the user types "quit".

---

# Unit 9: Non-Blocking I/O

- In traditional (blocking) I/O:
    Each client connection uses its own thread, and methods like read() or accept() block until something happens.

- In non-blocking I/O (NIO):
    All client connections are handled by a single thread, using a Selector that tells when each socket is ready for an operation (accept, read, write).

- A Selector monitors multiple channels (sockets) at once.
- It can tell which ones are ready to read, ready to write, or ready to accept connections.

This design is highly scalable — one thread can handle hundreds or thousands of clients efficiently.

## Lab 1: Non-Blocking I/O

### a. `NonBlockingServer.java`

```java
import java.io.*;
import java.net.*;
import java.nio.*;
import java.nio.channels.*;
import java.util.*;

/**
 * A non-blocking server using Java NIO to handle client connections and messages.
 */
public class NonBlockingServer {
    public static void main(String[] args) throws IOException {
        // Open a Selector for handling multiple channels at once in non-blocking mode
        Selector selector = Selector.open();    //Selector → To monitor multiple sockets at once

        // Open a ServerSocketChannel to listen for incoming client connections
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();    //using a static factory method since ServerSocketChannel doesn’t have a public constructor

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
```

**Sample Output (Server side):**
```
Hello from client
```

**Explanation:**
- We use a `Selector` to manage non-blocking `ServerSocketChannel` and `SocketChannel` operations.
- The server listens on `localhost:8080` for client connections (`OP_ACCEPT`) and reads data (`OP_READ`).
- After reading a message, the client connection is closed.

### b. `NonBlockingClient.java`

```java
import java.io.*;
import java.net.*;
import java.nio.*;
import java.nio.channels.*;

/**
 * A non-blocking client that sends a message to a server using Java NIO.
 */
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
```

**Sample Output (Client side):**
```
[No output, as the client only sends a message and exits]
```

**Explanation:**
- We use a `SocketChannel` to connect to the server at `localhost:8080`.
- We send a single message ("Hello from client") using a `ByteBuffer` and close the connection.

---

# Unit 10: UDP Programs

## Lab 1: UDP Client (Basic)

```java
import java.net.*;

/**
 * A basic UDP client that sends a message to a server and receives a response.
 */
public class Client {
    public static void main(String[] args) {
        try {
            // Create DatagramSocket (client side)
            DatagramSocket socket = new DatagramSocket();

            // Prepare message to send
            String message = "hello server";
            byte[] buffer = message.getBytes();

            // Create packet with message, server IP and port
            DatagramPacket packet = new DatagramPacket(
                buffer, buffer.length,
                InetAddress.getByName("127.0.0.1"), // Server address (localhost)
                4567                               // Server port
            );

            // Send message to server
            socket.send(packet);
            System.out.println("Message sent: " + message);

            // Prepare buffer to receive response
            packet = new DatagramPacket(new byte[1500], 1500);
            socket.receive(packet); // Receive reply from server

            // Convert received bytes to string
            message = new String(packet.getData()).trim();
            System.out.println("Message received: " + message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

**Sample Output (Client side):**
```
Message sent: hello server
Message received: hello client
```

**Explanation:**
- We create a `DatagramSocket` to send a UDP packet containing "hello server" to `127.0.0.1:4567`.
- We receive a response from the server and print it.

## Lab 2: UDP Server (Basic)

```java
import java.net.*;

/**
 * A basic UDP server that receives a message and sends a response.
 */
public class Server {
    public static void main(String[] args) {
        try {
            // Create DatagramSocket bound to port 4567
            DatagramSocket socket = new DatagramSocket(4567);
            System.out.println("Server is running...");

            // Buffer to store client message
            byte[] buffer = new byte[1500];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            // Wait for client message
            socket.receive(packet);
            String message = new String(packet.getData()).trim();
            System.out.println("Message received: " + message);

            // Prepare reply message
            InetAddress clientAddress = packet.getAddress();
            int clientPort = packet.getPort();
            message = "hello client";
            buffer = message.getBytes();

            // Send reply back to client
            packet = new DatagramPacket(buffer, buffer.length, clientAddress, clientPort);
            socket.send(packet);
            System.out.println("Message sent: " + message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

**Sample Output (Server side):**
```
Server is running...
Message received: hello server
Message sent: hello client
```

**Explanation:**
- We create a `DatagramSocket` on port 4567 to receive a UDP packet from a client.
- We send a response ("hello client") back to the client’s address and port.

## Lab 3: UDP Client (Interactive with Scanner)

```java
import java.net.*;
import java.util.Scanner;

/**
 * An interactive UDP client that sends user input to a server and receives responses.
 */
public class Client {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();
            Scanner scanner = new Scanner(System.in);
            String message;

            // Keep sending messages until user types 'exit'
            while (!(message = scanner.nextLine()).equalsIgnoreCase("exit")) {
                // Convert message into byte array
                byte[] buffer = message.getBytes();

                // Send packet to server
                DatagramPacket packet = new DatagramPacket(
                    buffer, buffer.length,
                    InetAddress.getByName("127.0.0.1"),
                    4567
                );
                socket.send(packet);
                System.out.println("Message sent: " + message);

                // Receive reply from server
                packet = new DatagramPacket(new byte[1500], 1500);
                socket.receive(packet);
                String reply = new String(packet.getData()).trim();
                System.out.println("Message received: " + reply);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

**Sample Output (Client side, interactive):**
```
hello
Message sent: hello
Message received: hello
how are you
Message sent: how are you
Message received: how are you
exit
```

**Explanation:**
- We create a `DatagramSocket` and use a `Scanner` to read user input.
- We send each input as a UDP packet to `127.0.0.1:4567` and receive an echo response.
- The client exits when the user types "exit".

## Lab 4: UDP Server (Echo Server with Loop)

```java
import java.net.*;

/**
 * A UDP echo server that continuously receives and echoes back client messages.
 */
public class Server {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(4567);
            System.out.println("Server is running...");

            while (true) {
                // Receive message from client
                byte[] buffer = new byte[1500];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                String message = new String(packet.getData()).trim();
                System.out.println("Client: " + message);

                // Echo back the message
                InetAddress clientAddress = packet.getAddress();
                int clientPort = packet.getPort();
                buffer = message.getBytes();
                packet = new DatagramPacket(buffer, buffer.length, clientAddress, clientPort);
                socket.send(packet);
                System.out.println("Server: " + message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

**Sample Output (Server side, when multiple messages arrive):**
```
Server is running...
Client: hello
Server: hello
Client: how are you
Server: how are you
```

**Explanation:**
- We create a `DatagramSocket` on port 4567 to continuously receive UDP packets.
- We echo each received message back to the client’s address and port.

---

# Unit 11: Multicasting

## Lab 1: Creating a Multicast Socket

```java
import java.io.*;
import java.net.*;

/**
 * A program that demonstrates creating and joining a multicast socket.
 */
public class MulticastExample {
    public static void main(String[] args) {
        try {
            // Create a MulticastSocket bound to port 4446
            MulticastSocket multicastSocket = new MulticastSocket(4446);
            System.out.println("Multicast Socket created on port 4446");

            // Join a multicast group at 230.0.0.0
            InetAddress group = InetAddress.getByName("230.0.0.0");
            multicastSocket.joinGroup(group);
            System.out.println("Joined multicast group: 230.0.0.0");

            // Leave the group and close
            multicastSocket.leaveGroup(group);
            multicastSocket.close();
            System.out.println("Left group and socket closed");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

**Sample Output:**
```
Multicast Socket created on port 4446
Joined multicast group: 230.0.0.0
Left group and socket closed
```

**Explanation:**
- We create a `MulticastSocket` on port 4446 and join the multicast group `230.0.0.0`.
- We leave the group and close the socket immediately after joining.

## Lab 2: Sending Data to a Multicast Group

```java
import java.io.*;
import java.net.*;

/**
 * A program that sends a message to a multicast group.
 */
public class MulticastSender {
    public static void main(String[] args) {
        try {
            // Create multicast socket
            MulticastSocket socket = new MulticastSocket();

            // Multicast group
            InetAddress group = InetAddress.getByName("230.0.0.0");

            // Message to send
            String message = "Hello, multicast group!";
            byte[] buffer = message.getBytes();

            // Packet for multicast group at port 4446
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, 4446);

            // Send packet
            socket.send(packet);
            System.out.println("Message sent: " + message);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

**Sample Output:**
```
Message sent: Hello, multicast group!
```

**Explanation:**
- We create a `MulticastSocket` and send a message to the multicast group `230.0.0.0` on port 4446.
- The socket is closed after sending the message.

## Lab 3: Receiving Data from a Multicast Group

```java
import java.io.*;
import java.net.*;

/**
 * A program that receives messages from a multicast group.
 */
public class MulticastReceiver {
    public static void main(String[] args) {
        try {
            // Create socket bound to port 4446
            MulticastSocket socket = new MulticastSocket(4446);

            // Join multicast group
            InetAddress group = InetAddress.getByName("230.0.0.0");
            socket.joinGroup(group);
            System.out.println("Joined multicast group: 230.0.0.0");

            // Prepare buffer for receiving
            byte[] buffer = new byte[256];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            // Receive packet
            socket.receive(packet);
            String received = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Received message: " + received);

            // Leave group
            socket.leaveGroup(group);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

**Sample Output (when sender is running):**
```
Joined multicast group: 230.0.0.0
Received message: Hello, multicast group!
```

**Explanation:**
- We create a `MulticastSocket` on port 4446 and join the multicast group `230.0.0.0`.
- We receive a single message from the group and print it, then leave the group and close the socket.

---

# Unit 12: Remote Method Invocation (RMI)

## 12.1 Defining and Implementing RMI Service Interface

### Step 1: Define the RMI Service Interface

```java
import java.rmi.*;

/**
 * Remote interface for a calculator service.
 */
public interface Calculator extends Remote {
    // Each remote method must throw RemoteException
    int add(int a, int b) throws RemoteException;
    int subtract(int a, int b) throws RemoteException;
}
```

**Explanation:**
- We define a `Calculator` interface that extends `Remote`.
- We declare two remote methods (`add` and `subtract`) that throw `RemoteException`.

### Step 2: Implement the RMI Service Interface

```java
import java.rmi.*;
import java.rmi.server.*;

/**
 * Implementation of the Calculator remote interface.
 */
public class CalculatorImpl extends UnicastRemoteObject implements Calculator {
    // Constructor must throw RemoteException
    protected CalculatorImpl() throws RemoteException {
        super();
    }

    // Implement add method
    @Override
    public int add(int a, int b) throws RemoteException {
        return a + b;
    }

    // Implement subtract method
    @Override
    public int subtract(int a, int b) throws RemoteException {
        return a - b;
    }
}
```

**Explanation:**
- We implement the `Calculator` interface by extending `UnicastRemoteObject`.
- We provide implementations for the `add` and `subtract` methods.

### Step 3: Create the RMI Server

```java
import java.rmi.*;
import java.rmi.registry.*;

/**
 * RMI server that registers a Calculator service.
 */
public class RMIServer {
    public static void main(String[] args) {
        try {
            // Create remote object
            CalculatorImpl calculator = new CalculatorImpl();

            // Start RMI registry on port 1099
            LocateRegistry.createRegistry(1099);

            // Bind the remote object with name "CalculatorService"
            Naming.rebind("rmi://localhost:1099/CalculatorService", calculator);

            System.out.println("RMI Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

**Sample Output (Server side):**
```
RMI Server is running...
```

**Explanation:**
- We create an instance of `CalculatorImpl` and register it with the RMI registry on port 1099.
- The service is bound to the name `CalculatorService`.

### Step 4: Create the RMI Client

```java
import java.rmi.*;

/**
 * RMI client that invokes methods on a remote Calculator service.
 */
public class RMIClient {
    public static void main(String[] args) {
        try {
            // Look up the CalculatorService from RMI registry
            Calculator calculator = (Calculator) Naming.lookup("rmi://localhost:1099/CalculatorService");

            // Invoke remote methods
            int sum = calculator.add(5, 3);
            int difference = calculator.subtract(5, 3);

            // Print results
            System.out.println("Sum: " + sum);
            System.out.println("Difference: " + difference);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

**Sample Output (Client side):**
```
Sum: 8
Difference: 2
```

**Explanation:**
- We look up the `CalculatorService` in the RMI registry.
- We invoke the remote `add` and `subtract` methods and print the results.

---

## 12.2 Creating an RMI Server and Client (Summary Flow)

1. **Remote Interface** (`Calculator.java`): Defines remote methods.
2. **Implementation** (`CalculatorImpl.java`): Provides method logic.
3. **Server** (`RMIServer.java`): Registers the remote object with the RMI registry.
4. **Client** (`RMIClient.java`): Looks up and invokes methods on the remote object.

---

## 12.3 Running the RMI System

### Step 1: Compile Programs

```sh
javac Calculator.java CalculatorImpl.java RMIServer.java RMIClient.java
```

### Step 2: Start RMI Registry

```sh
rmiregistry
```

*(keep this terminal running)*

### Step 3: Run the RMI Server

```sh
java RMIServer
```

### Step 4: Run the RMI Client

```sh
java RMIClient
```

---
