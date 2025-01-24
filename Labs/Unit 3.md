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
#### Expected output:
```
http is supported
https is supported
ftp is supported
mailto is supported
telnet is not supported
```

---
### 2. Example 2: Download a web page
```java
import java.io.*;
import java.net.*;

public class SourceViewer {
    public static void main(String[] args) {
        try {
            // Open the URL for reading
            URL url = new URL("http://google.com");

            // Buffer the input to improve performance
            BufferedReader inData = new BufferedReader(new InputStreamReader(url.openStream()));

/*The url.openStream() opens the connection and retrieves the web page's content as a byte stream.
The InputStreamReader converts the byte stream into character data.
The BufferedReader reads and stores multiple characters in memory for faster access.*/

            String line;
            while ((line = inData.readLine()) != null) {
                System.out.println(line);
            }

            // Close the BufferedReader
            inData.close();

        } catch (MalformedURLException ex) {
            System.err.println("The provided URL is not valid.");
        } catch (IOException ex) {
            System.err.println("Error reading from the URL: " + ex.getMessage());
        }
    }
}

```

---
#### Example 3: Download an object

```java
import java.io.*;
import java.net.*;

public class ContentGetter {
    public static void main(String[] args) {
        try {
            // Open the URL and retrieve content
            URL url = new URL("https://www.oreilly.com");

            // Get the content from the URL as an Object
            Object content = url.getContent();

            // Print the class name of the content object
            System.out.println("I got a " + content.getClass().getName());
        } catch (MalformedURLException ex) {
            // Handle malformed URL error
            System.err.println("The provided URL is not a valid URL: " + ex.getMessage());
        } catch (IOException ex) {
            // Handle other I/O exceptions (e.g., network issues)
            System.err.println("Error occurred: " + ex.getMessage());
        }
    }
}

```

---
#### Example 4. The parts of a URL
```java
import java.net.*;

public class URLSplitter {
    public static void main(String[] args) {
        try {
            // Create a URL object for a sample URL
            URL url = new URL("https://www.example.com:8080/path/to/resource?name=JohnDoe#section");

            // Print the entire URL
            System.out.println("The URL is: " + url);

            // Print the scheme (protocol)
            System.out.println("The scheme is: " + url.getProtocol());

            // Print user info (if available)
            System.out.println("The user info is: " + url.getUserInfo());

            // Print the host (domain name)
            System.out.println("The host is: " + url.getHost());

            // Print the port number
            System.out.println("The port is: " + url.getPort());

            // Print the path of the resource
            System.out.println("The path is: " + url.getPath());

            // Print the reference (fragment identifier, if available)
            System.out.println("The ref (fragment) is: " + url.getRef());

            // Print the query string (if available)
            System.out.println("The query string is: " + url.getQuery());
        } catch (MalformedURLException ex) {
            System.err.println("It is not a URL I understand.");
        }
        System.out.println();
    }
}

```

```
getProtocol() returns the protocol part of the URL (e.g., https for secure HTTP).
getUserInfo() would return any username and password specified in the URL (e.g., user:password if provided). If not present, it returns null.
getHost() returns the host or domain of the URL (e.g., www.example.com).
getPort() returns the port number. If no port is specified, it returns -1 (indicating the default port for the protocol).
getPath() returns the path part of the URL (e.g., /path/to/resource).
getRef() returns the fragment (or anchor) part of the URL, which is the part after the # symbol (e.g., section).
getQuery() returns the query string (e.g., name=JohnDoe).
```

---
Example 5: Checking URL Equality: Are http://www.ibiblio.org and http://ibiblio.org the same?
```java
import java.net.*;

public class URLEquality {
    public static void main(String[] args) {
        try {
            // Define two URL objects
            URL www = new URL("http://www.ibiblio.org/");
            URL ibiblio = new URL("http://ibiblio.org/");
            
            // Compare the two URLs using equals()
            if (ibiblio.equals(www)) {
                System.out.println(ibiblio + " is the same as " + www);
            } else {
                System.out.println(ibiblio + " is not the same as " + www);
            }
        } catch (MalformedURLException ex) {
            System.err.println("Invalid URL format: " + ex.getMessage());
        }
    }
}

```

#### Expected Output:

```
http://ibiblio.org/ is the same as http://www.ibiblio.org/
```

---
Example 6: The parts of a URI

```java
import java.net.*;

public class URISplitter {
    public static void main(String[] args) {
        try {
            URI u = new URI("https://www.prime.edu.np/");
            // URI u = new URI("mailto:someone@example.com");
            System.out.println("The URI is " + u);
            
            if (u.isOpaque()) { // URI does not describe a path to a resource
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
        } catch (URISyntaxException ex) {
            System.err.println("Does not seem to be a valid URI.");
        }
    }
}

```

```
Types of URIs:
Opaque URI: Does not have a hierarchical structure (e.g., mailto: or telnet: URIs).
Hierarchical URI: Has a clear structure that includes a scheme (e.g., http, https), host, path, and optionally a port, query string, and fragment identifier.
Methods used in the program:
isOpaque(): Checks if the URI is opaque (not hierarchical).
getScheme(): Retrieves the scheme (protocol) of the URI.
getSchemeSpecificPart(): Retrieves the scheme-specific part of the URI.
getHost(), getPort(), getPath(), getUserInfo(), getQuery(), getFragment(): Retrieve different components of the URI.
```

#### Expected Ouput:
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

---
#### Example 7: x-www-form-urlencoded strings
```java
import java.io.*;
import java.net.*;

public class Example7 {
    public static void main(String[] args) {
        try {
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
        } catch (UnsupportedEncodingException ex) {
            System.out.println("Encoding not supported.");
        }
    }
}

```
```
Spaces: The space character is encoded as %20.
Asterisks (*): Asterisks are left unchanged because they are safe for URLs but might be encoded depending on context.
Percent signs (%): These characters are encoded as %25 to avoid confusion with URL-encoding itself.
Pluses (+): Pluses are encoded as %2B.
Slashes (/): Slashes are encoded as %2F.
Quotes ("): Double quotes are encoded as %22.
Colons (:): Colons are encoded as %3A.
Tildes (~): Tildes are encoded as %7E.
Parentheses (()): Parentheses are encoded as %28 and %29.
Periods (.): Periods are left unchanged but could be encoded in some cases.
Equals signs (=): Equals signs are encoded as %3D.
Ampersands (&): Ampersands are encoded as %26.
Non-ASCII characters (like é): These are encoded in their UTF-8 percent-encoded format (e.g., %C3%A9 for é).
```

#### Expected Output:
#### Example 8: URLDecoder
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

---

```java
import java.io.*;
import java.net.*;

public class ExampleDecoder {
    public static void main(String[] args) {
        try {
            // Decode a string where '+' is used for spaces
            System.out.println(URLDecoder.decode("This+string+has+spaces", "UTF-8"));
            
            // Decode a string where '%25' represents '%'
            System.out.println(URLDecoder.decode("This%25string%25has%25percent%25signs", "UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            System.out.println("Encoding not supported.");
        }
    }
}

```

#### Expected Output:

```
This string has spaces
This%string%has%percent%signs
```

---
