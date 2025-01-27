The `URLConnection` class in Java is used to establish a connection between the application and a URL resource. It allows retrieving data from web pages, such as content type, header fields, and input streams to read the page's content.

Note: Differences between URL and URLConnection.
- URLConnection provides access to the HTTP header.
- URLConnection can configure the request parameters sent to the server.
- URLConnection can write data to the server as well as read data from the server.

### **Example 1: Demonstrating `URLConnection` in Java**

```java
import java.io.*;
import java.net.*;

public class URLConnectionExample {
    public static void main(String[] args) {
        try {
            // Define the URL to connect to
            URL url = new URL("https://www.prime.edu.np/");
            
            // Open a connection to the specified URL
            URLConnection urlConnection = url.openConnection();
            
            // Retrieve and print the content type of the URL resource
            System.out.println("Content Type: " + urlConnection.getContentType());
            
        } catch (MalformedURLException e) {
            // Handle incorrect or badly formatted URLs
            System.err.println("Error: The URL is not properly formatted.");
        } catch (IOException e) {
            // Handle IO errors such as connection failures
            System.err.println("Error: Unable to connect to the URL. " + e.getMessage());
        }
    }
}
```

### **Sample Output**

If the connection is successful:

```
Content Type: text/html; charset=UTF-8
```

If the URL is incorrect:

```
Error: The URL is not properly formatted.
```

If there's a connection issue:

```
Error: Unable to connect to the URL. Connection timed out.
```

---

### **Example 2: Downloading a Web Page Using `URLConnection` in Java**

```java
import java.io.*;
import java.net.*;

public class DownloadWebPage {
    public static void main(String[] args) {
        try {
            // Create a URL object pointing to the desired web page
            URL url = new URL("https://www.prime.edu.np/");
            
            // Open a connection to the specified URL
            URLConnection urlConnection = url.openConnection();
            
            // Create a BufferedReader to read the web page content line by line
            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            
            String inputLine;
            
            // Read each line from the web page and print it
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
            
            // Close the BufferedReader
            in.close();
            
        } catch (MalformedURLException e) {
            // Handle incorrect or malformed URLs
            System.err.println("Error: The URL is not properly formatted.");
        } catch (IOException e) {
            // Handle connection or reading issues
            System.err.println("Error: Unable to retrieve web page content. " + e.getMessage());
        }
    }
}
```

### **Sample Output (Partial HTML Content of the Page)**

```html
<!doctype html>
<html dir="ltr" lang="en-US" prefix="og: https://ogp.me/ns#">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="profile" href="https://gmpg.org/xfn/11">
	 <title>Prime College</title>
<link rel="icon" href="https://prime.edu.np/wp-content/themes/prime-college/assets/img/favicon.png">
    <!-- -----Style Library----- -->
    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://prime.edu.np/wp-content/themes/prime-college/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://prime.edu.np/wp-content/themes/prime-college/assets/vendor/fontawesome/css/all.min.css">
    <link
  rel="stylesheet"
  href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css"
/>

              ........

</body>
</html>
</div>
```

If the URL is incorrect:

```
Error: The URL is not properly formatted.
```

If there's a connection issue:

```
Error: Unable to retrieve web page content. Connection timed out.
```

---

### **Example 3: Retrieving HTTP Headers Using `URLConnection` in Java**

The `URLConnection` class provides methods to retrieve HTTP headers from a given URL, such as content type, encoding, modification date, expiration date, and content length.

```java
import java.net.*;
import java.util.Date;
import java.io.*;

public class URLHeaderInfo {
    public static void main(String[] args) {
        try {
            // Create a URL object pointing to the desired web page
            URL url = new URL("https://www.prime.edu.np/");
            
            // Open a connection to the URL
            URLConnection urlConnection = url.openConnection();
            
            // Display content type of the resource
            System.out.println("Content-type: " + urlConnection.getContentType());
            
            // Check and display content encoding if available
            if (urlConnection.getContentEncoding() != null) {
                System.out.println("Content-encoding: " + urlConnection.getContentEncoding());
            }
            
            // Check and display the date of the resource if available
            if (urlConnection.getDate() != -1) {
                System.out.println("Date: " + new Date(urlConnection.getDate()));
            }
            
            // Check and display the last modified date if available
            if (urlConnection.getLastModified() != -1) {
                System.out.println("Last modified: " + new Date(urlConnection.getLastModified()));
            }
            
            // Check and display expiration date if available
            if (urlConnection.getExpiration() != -1) {
                System.out.println("Expiration date: " + new Date(urlConnection.getExpiration()));
            }
            
            // Check and display content length if available
            if (urlConnection.getContentLength() != -1) {
                System.out.println("Content-length: " + urlConnection.getContentLength());
            }
            
        } catch (MalformedURLException e) {
            // Handle an invalid URL format
            System.err.println("Error: It is not a valid URL.");
        } catch (IOException e) {
            // Handle input/output errors such as connection failure
            System.err.println("Error: " + e.getMessage());
        }
    }
}
```

### **Sample Output**

```
Content-type: text/html; charset=UTF-8
Date: Mon Jan 27 16:49:13 NPT 2025
Last modified: Thu Jan 01 05:30:00 NPT 1970
Expiration date: Thu Jan 01 05:30:00 NPT 1970
```

If the URL is incorrect:

```
Error: It is not a valid URL.
```

If there's a connection issue:

```
Error: Connection refused
```

---

### **Example 4: Printing the Entire HTTP Header Using `URLConnection` in Java**

The `URLConnection` class provides methods to access HTTP headers of a web page. HTTP headers contain key-value pairs providing information such as content type, date, server details, and more.


```java
import java.net.*;
import java.io.*;

public class HTTPHeaderPrinter {
    public static void main(String[] args) {
        try {
            // Create a URL object pointing to the target web page
            URL url = new URL("https://www.prime.edu.np/");
            
            // Open a connection to the specified URL
            URLConnection urlConnection = url.openConnection();
            
            // Variable to iterate through header fields
            int i = 1;
            
            // Loop through HTTP headers and print key-value pairs
            while (urlConnection.getHeaderField(i) != null) {
                System.out.println(urlConnection.getHeaderFieldKey(i) + ": " + urlConnection.getHeaderField(i));
                i++;
            }
            
        } catch (MalformedURLException e) {
            // Handle incorrect URL format
            System.err.println("Error: It is not a valid URL.");
        } catch (IOException e) {
            // Handle connection or input-output errors
            System.err.println("Error: " + e.getMessage());
        }
    }
}
```

### **Sample Output**

```
Date: Mon, 27 Jan 2025 11:05:31 GMT
Content-Type: text/html; charset=UTF-8
Transfer-Encoding: chunked
Connection: keep-alive
x-powered-by: PHP/7.4.33
link: <https://prime.edu.np/wp-json/>; rel="https://api.w.org/"
link: <https://prime.edu.np/wp-json/wp/v2/pages/7>; rel="alternate"; title="JSON"; type="application/json"
link: <https://prime.edu.np/>; rel=shortlink
vary: Accept-Encoding
x-turbo-charged-by: LiteSpeed
cf-cache-status: DYNAMIC
Report-To: {"endpoints":[{"url":"https:\/\/a.nel.cloudflare.com\/report\/v4?s=0r%2B2ttxgMyl%2BmrpL3yn3MDAbG6452kC%2BbhhOsRSLasseHEogodbpW8mVk6TVnleQdO5dpiivZNDRTpS8Fi4ae%2F4Eqiy%2FO9GUob9STDruGL5yyHKXI2VQerEwCoAz4XA%3D"}],"group":"cf-nel","max_age":604800}
NEL: {"success_fraction":0,"report_to":"cf-nel","max_age":604800}
Server: cloudflare
CF-RAY: 9088449d59f22789-LYS
alt-svc: h3=":443"; ma=86400
server-timing: cfL4;desc="?proto=TCP&rtt=191449&min_rtt=189723&rtt_var=42623&sent=6&recv=9&lost=0&retrans=0&sent_bytes=3119&recv_bytes=688&delivery_rate=22026&cwnd=252&unsent_bytes=0&cid=3e51b5ebcb6c6520&ts=1340&x=0"

```

If the URL is incorrect:

```
Error: It is not a valid URL.
```

If there's a connection issue:

```
Error: Connection timed out
```

---


### **Example 5: Printing the URL of a `URLConnection` in Java**

The `URLConnection` class allows accessing various properties of a web resource, including retrieving the actual URL after establishing a connection. This can be useful in cases where URL redirections occur.


```java
import java.io.*;
import java.net.*;

public class URLPrinter {
    public static void main(String[] args) {
        try {
            // Create a URL object with the target website
            URL url = new URL("http://www.oreilly.com/");
            
            // Open a connection to the specified URL
            URLConnection urlConnection = url.openConnection();
            
            // Print the URL of the connection
            System.out.println("Connected URL: " + urlConnection.getURL());
            
        } catch (IOException e) {
            // Handle connection or input-output errors
            System.err.println("Error: " + e.getMessage());
        }
    }
}
```

### **Sample Output (Expected Output)**

If the URL is accessed successfully:

```
Connected URL: http://www.oreilly.com/
```

If there is a redirection (e.g., to HTTPS):

```
Connected URL: https://www.oreilly.com/
```

If there is a connection issue:

```
Error: www.oreilly.com: Name or service not known
```

---
### **Example 6:Program to print all response from server**

```java
import java.io.*;
import java.net.*;

public class Example6 {
    public static void main(String[] args) {
        try {
            // Define the URL to connect to
            URL url = new URL("http://www.prime.edu.np");

            // Open an HTTP connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Get the HTTP response code (e.g., 200 for success)
            int responseCode = connection.getResponseCode();
            String responseMessage = connection.getResponseMessage();

            // Print the HTTP response status line
            System.out.println("HTTP/1.x " + responseCode + " " + responseMessage);

            // Print all HTTP headers
            int headerIndex = 1;
            while (connection.getHeaderField(headerIndex) != null) {
                System.out.println(connection.getHeaderFieldKey(headerIndex) + ": " + connection.getHeaderField(headerIndex));
                headerIndex++;
            }

            System.out.println("\n--- Response Content ---");

            // Read and print the response body (HTML content)
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();  // Close the reader after reading the response

        } catch (MalformedURLException e) {
            System.err.println("Invalid URL format.");
        } catch (IOException e) {
            System.err.println("Error in connection: " + e.getMessage());
        }
    }
}
```

### **Sample Output**

```
HTTP/1.x 200 OK
Date: Mon, 27 Jan 2025 11:08:36 GMT
Content-Type: text/html; charset=UTF-8
Transfer-Encoding: chunked
Connection: keep-alive
x-powered-by: PHP/7.4.33
link: <https://prime.edu.np/wp-json/>; rel="https://api.w.org/"
link: <https://prime.edu.np/wp-json/wp/v2/pages/7>; rel="alternate"; title="JSON"; type="application/json"
link: <https://prime.edu.np/>; rel=shortlink
vary: Accept-Encoding
x-turbo-charged-by: LiteSpeed
cf-cache-status: DYNAMIC
Report-To: {"endpoints":[{"url":"https:\/\/a.nel.cloudflare.com\/report\/v4?s=aJ9MqdIY1%2FroQB4xKHk%2BMO%2Bly6zPzRnDqVJroiAYsUU2FX%2BXvsThyvBimV8DUNqWW2UPWrY037t1VZ9LRfomIspPWm1S2PLOLpGZxGD83Z2EHPE2OXCPS5RQML%2Byy70%3D"}],"group":"cf-nel","max_age":604800}
NEL: {"success_fraction":0,"report_to":"cf-nel","max_age":604800}
Server: cloudflare
CF-RAY: 908849257b82e160-MRS
alt-svc: h3=":443"; ma=86400
server-timing: cfL4;desc="?proto=TCP&rtt=133878&min_rtt=132715&rtt_var=50599&sent=6&recv=7&lost=0&retrans=0&sent_bytes=3117&recv_bytes=688&delivery_rate=32370&cwnd=216&unsent_bytes=0&cid=7d07a5b203dc688e&ts=532&x=0"

--- Response Content ---
<!doctype html>
<html dir="ltr" lang="en-US" prefix="og: https://ogp.me/ns#">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="profile" href="https://gmpg.org/xfn/11">
	 <title>Prime College</title>
<link rel="icon" href="https://prime.edu.np/wp-content/themes/prime-college/assets/img/favicon.png">
    <!-- -----Style Library----- -->
    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://prime.edu.np/wp-content/themes/prime-college/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://prime.edu.np/wp-content/themes/prime-college/assets/vendor/fontawesome/css/all.min.css">
    <link
  rel="stylesheet"
  href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css"
/>


.....................

</body>
</html>

```
---
