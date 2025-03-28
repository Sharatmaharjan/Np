### **InetAddress Class in Java**

The **`InetAddress`** class in Java belongs to the `java.net` package and represents an Internet Protocol (IP) address, both IPv4 and IPv6. It provides methods to resolve hostnames to IP addresses and vice versa, as well as utility methods for network-related operations.

---

### **Features of `InetAddress`**
1. **Hostname Resolution**: Convert a domain name (e.g., `www.google.com`) into its corresponding IP address.
2. **Reverse Lookup**: Find the hostname associated with an IP address.
3. **Support for IPv4 and IPv6**: Handles both types of addresses.
4. **No Public Constructor**: Objects of `InetAddress` are created using static factory methods.

---

### **Common Factory Methods in `InetAddress`**
1. **`getByName(String host)`**: Resolves a hostname into an IP address.
2. **`getAllByName(String host)`**: Resolves a hostname into all its associated IP addresses.
3. **`getLocalHost()`**: Gets the local machine's IP address and hostname.
4. **`getByAddress(byte[] addr)`**: Returns an `InetAddress` object for a given raw IP address.
5. **`isReachable(int timeout)`**: Checks if the address is reachable within the specified timeout.

---

### **Important Methods**
- **`getHostName()`**: Returns the hostname of the IP address.
- **`getHostAddress()`**: Returns the IP address in textual format.
- **`toString()`**: Combines hostname and IP address as a string.

---

### **Examples**

#### **1. Resolving a Hostname to IP Address**

```java
import java.net.InetAddress;

public class InetAddressExample {
    public static void main(String[] args) {
        try {
            // Resolving hostname to IP address
            InetAddress address = InetAddress.getByName("www.google.com");
            System.out.println("Hostname: " + address.getHostName());
            System.out.println("IP Address: " + address.getHostAddress());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
```

**Sample Output**:
```
Hostname: www.google.com
IP Address: 142.250.183.68
```

---

#### **2. Retrieving All IP Addresses for a Hostname**

```java
import java.net.InetAddress;

public class MultipleAddressesExample {
    public static void main(String[] args) {
        try {
            // Getting all IP addresses for a hostname
            InetAddress[] addresses = InetAddress.getAllByName("www.google.com");
            System.out.println("All IP Addresses for www.google.com:");
            for (InetAddress addr : addresses) {
                System.out.println(addr.getHostAddress());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
```

**Sample Output**:
```
All IP Addresses for www.google.com:
142.250.183.68
142.250.183.100
142.250.183.138
142.250.183.101
142.250.183.102
142.250.183.113
```

---

#### **3. Getting the Local Host Information**

```java
import java.net.InetAddress;

public class LocalHostExample {
    public static void main(String[] args) {
        try {
            // Getting local machine's IP and hostname
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("Local Hostname: " + localHost.getHostName());
            System.out.println("Local IP Address: " + localHost.getHostAddress());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
```

**Sample Output**:
```
Local Hostname: my-computer
Local IP Address: 192.168.1.10
```

---

#### **4. Checking if an Address is Reachable**

```java
import java.net.InetAddress;

public class ReachabilityExample {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("www.google.com");
            if (address.isReachable(5000)) {
                System.out.println(address.getHostName() + " is reachable.");
            } else {
                System.out.println(address.getHostName() + " is not reachable.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
```

**Sample Output**:
```
www.google.com is reachable.
```

---

#### **5. Reverse DNS Lookup**

```java
import java.net.InetAddress;

public class ReverseDNSExample {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("142.250.183.68");
            System.out.println("IP Address: " + address.getHostAddress());
            System.out.println("Hostname: " + address.getHostName());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
```

**Sample Output**:
```
IP Address: 142.250.183.68
Hostname: lhr25s08-in-f4.1e100.net
```

---

### **Key Points to Remember**
1. **Static Factory Methods**: Use methods like `getByName` or `getLocalHost` to create instances.
2. **Exceptions**: `UnknownHostException` is thrown when the hostname/IP address cannot be resolved.
3. **IPv6 Support**: Works for both IPv4 and IPv6 addresses.
4. **Reachability**: Useful for network diagnostics and monitoring.
---


### **1. `public boolean isAnyLocalAddress()`**
- **Purpose**: This method checks if the IP address is the "any local" address (`0.0.0.0` for IPv4 or `::/128` for IPv6). It is used to refer to a non-specific local address.
- **Returns**: `true` if the address is the any local address; otherwise, `false`.

### **Example**:
```java
InetAddress inet = InetAddress.getByName("0.0.0.0");
System.out.println(inet.isAnyLocalAddress());  // true for IPv4 any local address
```

### **2. `public boolean isLoopbackAddress()`**
- **Purpose**: This method checks if the address is a loopback address (e.g., `127.0.0.1` for IPv4 or `::1` for IPv6). Loopback addresses are used to refer to the local machine.
- **Returns**: `true` if the address is a loopback address; otherwise, `false`.

### **Example**:
```java
InetAddress inet = InetAddress.getByName("127.0.0.1");
System.out.println(inet.isLoopbackAddress());  // true for IPv4 loopback address
```

### **3. `public boolean isLinkLocalAddress()`**
- **Purpose**: This method checks if the address is a link-local address. These addresses are used for communication within a single network segment (e.g., `169.254.x.x` for IPv4 or `fe80::/10` for IPv6).
- **Returns**: `true` if the address is a link-local address; otherwise, `false`.

### **Example**:
```java
InetAddress inet = InetAddress.getByName("169.254.0.1");
System.out.println(inet.isLinkLocalAddress());  // true for IPv4 link-local address
```

### **4. `public boolean isSiteLocalAddress()`**
- **Purpose**: This method checks if the address is a site-local address. Site-local addresses are used within an organization or site (e.g., `10.x.x.x` or `192.168.x.x` for IPv4 or `fec0::/10` for IPv6).
- **Returns**: `true` if the address is a site-local address; otherwise, `false`.

### **Example**:
```java
InetAddress inet = InetAddress.getByName("192.168.1.1");
System.out.println(inet.isSiteLocalAddress());  // true for IPv4 site-local address
```

### **5. `public boolean isMulticastAddress()`**
- **Purpose**: This method checks if the address is a multicast address (e.g., `224.0.0.0` to `239.255.255.255` for IPv4 or `ff00::/8` for IPv6).
- **Returns**: `true` if the address is a multicast address; otherwise, `false`.

### **Example**:
```java
InetAddress inet = InetAddress.getByName("224.0.0.1");
System.out.println(inet.isMulticastAddress());  // true for IPv4 multicast address
```

### **6. `public boolean isMCGlobal()`**
- **Purpose**: This method checks if the multicast address is globally scoped. Global multicast addresses are in the range `ff0x::/8` (for IPv6) or `224.0.0.0` to `239.255.255.255` (for IPv4).
- **Returns**: `true` if the address is a global multicast address; otherwise, `false`.

### **Example**:
```java
InetAddress inet = InetAddress.getByName("233.0.0.1");
System.out.println(inet.isMCGlobal());  // true for a global IPv4 multicast address
```

### **7. `public boolean isMCNodeLocal()`**
- **Purpose**: This method checks if the multicast address is node-local (for communication within a single host, like `ff01::/8` for IPv6 or `224.0.0.1` for IPv4).
- **Returns**: `true` if the address is a node-local multicast address; otherwise, `false`.

### **Example**:
```java
InetAddress inet = InetAddress.getByName("ff01::1");
System.out.println(inet.isMCNodeLocal());  // true for node-local multicast address
```

### **8. `public boolean isMCLinkLocal()`**
- **Purpose**: This method checks if the multicast address is link-local, meaning it can be used only within the scope of a single network segment (like `ff02::/8` for IPv6 or `224.0.0.0` to `224.0.0.255` for IPv4).
- **Returns**: `true` if the address is a link-local multicast address; otherwise, `false`.

### **Example**:
```java
InetAddress inet = InetAddress.getByName("ff02::1");
System.out.println(inet.isMCLinkLocal());  // true for IPv6 link-local multicast address
```

### **9. `public boolean isMCSiteLocal()`**
- **Purpose**: This method checks if the multicast address is site-local, meaning it is scoped to a site (e.g., `ff05::/8` for IPv6 or `233.x.x.x` for IPv4).
- **Returns**: `true` if the address is a site-local multicast address; otherwise, `false`.

### **Example**:
```java
InetAddress inet = InetAddress.getByName("ff05::1");
System.out.println(inet.isMCSiteLocal());  // true for site-local multicast address
```

### **10. `public boolean isMCOrgLocal()`**
- **Purpose**: This method checks if the multicast address is organization-local, meaning it is scoped to an organization (e.g., `ff08::/8` for IPv6 or `233.x.x.x` for IPv4).
- **Returns**: `true` if the address is an organization-local multicast address; otherwise, `false`.

### **Example**:
```java
InetAddress inet = InetAddress.getByName("ff08::1");
System.out.println(inet.isMCOrgLocal());  // true for organization-local multicast address
```

### Summary of Methods:
- `isAnyLocalAddress()`: Checks for the any local address (e.g., `0.0.0.0`).
- `isLoopbackAddress()`: Checks for the loopback address (e.g., `127.0.0.1` or `::1`).
- `isLinkLocalAddress()`: Checks for link-local addresses (e.g., `169.254.x.x` or `fe80::/10`).
- `isSiteLocalAddress()`: Checks for site-local addresses (e.g., `10.x.x.x`, `192.168.x.x`).
- `isMulticastAddress()`: Checks for multicast addresses (e.g., `224.0.0.0` to `239.255.255.255` or `ff00::/8`).
- `isMCGlobal()`: Checks if the multicast address is globally scoped.
- `isMCNodeLocal()`: Checks if the multicast address is node-local.
- `isMCLinkLocal()`: Checks if the multicast address is link-local.
- `isMCSiteLocal()`: Checks if the multicast address is site-local.
- `isMCOrgLocal()`: Checks if the multicast address is organization-local.

---
```
import java.net.*;

public class HostnameComparison {
    public static void main(String[] args) {
        try {
            // Getting InetAddress objects for two different hostnames
            InetAddress example1 = InetAddress.getByName("www.google.com");
            InetAddress example2 = InetAddress.getByName("google.com");

            // Comparing the two InetAddress objects
            if (example1.equals(example2)) {
                System.out.println("www.google.com is the same as google.com");
            } else {
                System.out.println("www.google.com is not the same as google.com");
            }

        } catch (UnknownHostException ex) {
            System.out.println("Host lookup failed.");
        }
    }
}
```
---
### SpamCheck
```
import java.net.*;
import java.util.Scanner;

public class SpamCheck {
    public static final String BLACKHOLE = "sbl.spamhaus.org";

    public static void main(String[] args) throws UnknownHostException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the IP address to check: ");
        String ipAddress = scanner.nextLine().trim();

        if (isSpammer(ipAddress)) {
            System.out.println(ipAddress + " is a known spammer.");
        } else {
            System.out.println(ipAddress + " appears legitimate.");
        }

        scanner.close();
    }

    private static boolean isSpammer(String ip) {
        try {
            InetAddress address = InetAddress.getByName(ip);
            byte[] quad = address.getAddress(); // Get IP as byte array

            String query = BLACKHOLE;
            for (byte octet : quad) {
                int unsignedByte = octet < 0 ? octet + 256 : octet;
                query = unsignedByte + "." + query;
            }

            InetAddress.getByName(query); // DNS lookup
            return true;  // If successful, IP is listed in Spamhaus
        } catch (UnknownHostException e) {
            return false; // IP is not listed in Spamhaus
        }
    }
}
```

```
          +------------------------+
          |  User enters IP address |
          +-----------+------------+
                      |
                      v
          +-----------+------------+
          | Reverse the IP address  |
          +-----------+------------+
                      |
                      v
          +-----------+------------+
          | Construct Spamhaus Query|
          +-----------+------------+
                      |
                      v
          +-----------+------------+
          | Perform DNS lookup      |
          +-----------+------------+
                      |
          +-----------+------------+
          |    Is IP in Spamhaus?   |
          +------+-----------+-----+
                 |           |
              Yes|           |No
                 v           v
      +----------------+   +--------------------+
      | IP is listed   |   | IP is not listed    |
      | as spam        |   | in Spamhaus         |
      +----------------+   +--------------------+
                 |                   |
                 v                   v
    +---------------------------+   +---------------------------+
    | Print: "IP is spam"        |   | Print: "IP is NOT spam"    |
    +---------------------------+   +---------------------------+

```

---
### WebLog
```
import java.io.*; 
import java.net.*;

public class Weblog {
    public static void main(String[] args) {
        // Hardcoded file path for Windows desktop (update with actual username)
        String filePath = "C:\\Users\\YourUsername\\Desktop\\weblog.txt";

        try (FileInputStream fin = new FileInputStream(filePath);
             Reader in = new InputStreamReader(fin);
             BufferedReader bin = new BufferedReader(in)) {

            String entry;
            while ((entry = bin.readLine()) != null) {
                // Separate out the IP address
                int index = entry.indexOf(' ');
                if (index == -1) continue;  // Skip invalid lines

                String ip = entry.substring(0, index);
                String theRest = entry.substring(index);

                // Ask DNS for the hostname and print it out
                try {
                    InetAddress address = InetAddress.getByName(ip);
                    System.out.println(address.getHostName() + theRest);
                } catch (UnknownHostException ex) {
                    System.err.println("Unable to resolve IP: " + ip);
                }
            }
        } catch (IOException ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
    }
}
```
### Explanation:
### **1. Import Necessary Packages**
```java
import java.io.*; 
import java.net.*;
```
- **`java.io.*`**: This package includes classes for input and output (I/O) operations such as reading from and writing to files.
- **`java.net.*`**: This package provides classes for network operations, like resolving IP addresses to hostnames.

### **2. Define the Class and Main Method**
```java
public class Weblog {
    public static void main(String[] args) {
```
- **`public class Weblog`**: Declares a public class called `Weblog`.
- **`public static void main(String[] args)`**: The entry point of the program. When the program runs, it begins executing from here.

### **3. Define the File Path**
```java
String filePath = "C:\\Users\\YourUsername\\Desktop\\weblog.txt";
```
- The file path to the log file (`weblog.txt`) is specified here. The file should be located on your **Windows Desktop**. **Update `"YourUsername"`** to match your actual username on your system.
- This is a **hardcoded file path**, which means it's fixed and will not change unless manually edited.

### **4. Open the File for Reading**
```java
try (FileInputStream fin = new FileInputStream(filePath);
     Reader in = new InputStreamReader(fin);
     BufferedReader bin = new BufferedReader(in)) {
```
- **`FileInputStream fin = new FileInputStream(filePath)`**: Opens the file at the specified path (`weblog.txt`) in read mode.
- **`InputStreamReader in = new InputStreamReader(fin)`**: Converts the raw byte stream into a character stream, which is easier to read as text.
- **`BufferedReader bin = new BufferedReader(in)`**: Reads the file line by line efficiently using a buffered reader.

### **5. Read the File Line by Line**
```java
String entry;
while ((entry = bin.readLine()) != null) {
```
- **`entry = bin.readLine()`**: Reads one line from the file at a time.
- The **`while`** loop continues until there are no more lines to read (i.e., `readLine()` returns `null`).

### **6. Extract the IP Address from the Log Entry**
```java
int index = entry.indexOf(' ');
if (index == -1) continue;  // Skip invalid lines

String ip = entry.substring(0, index);
String theRest = entry.substring(index);
```
- **`int index = entry.indexOf(' ')`**: Finds the position of the first space character (`' '`) in the `entry` string. This space separates the IP address from the rest of the log entry.
- **`if (index == -1) continue;`**: If no space is found (i.e., the format of the log entry is incorrect), it skips to the next line.
- **`String ip = entry.substring(0, index)`**: Extracts the IP address from the start of the string up to the first space.
- **`String theRest = entry.substring(index)`**: Extracts the remaining part of the log entry after the IP address.

### **7. Resolve the IP Address to a Hostname**
```java
try {
    InetAddress address = InetAddress.getByName(ip);
    System.out.println(address.getHostName() + theRest);
} catch (UnknownHostException ex) {
    System.err.println("Unable to resolve IP: " + ip);
}
```
- **`InetAddress.getByName(ip)`**: Attempts to resolve the IP address into a hostname (e.g., `google.com`). This makes a DNS query to convert the IP address into a human-readable domain name.
- **`System.out.println(address.getHostName() + theRest)`**: Prints the resolved hostname followed by the rest of the log entry.
- If the IP cannot be resolved (e.g., if it's not a registered hostname), the program catches the exception and prints an error message.
  - **`System.err.println("Unable to resolve IP: " + ip)`**: Prints an error message to standard error (`stderr`) indicating the failure to resolve the IP.

### **8. Handle Input/Output Exceptions**
```java
} catch (IOException ex) {
    System.out.println("Exception: " + ex.getMessage());
}
```
- If there is any issue with reading the file (e.g., file not found), it will be caught here.
- **`System.out.println("Exception: " + ex.getMessage())`**: Prints the exception message to standard output.

### **9. Program Ends**
```java
}
```
- The program ends after all lines have been processed or if an error occurs.

---

### **Summary:**
1. **Fixed File Path**: The program is designed to read a log file (`weblog.txt`) from the Desktop using a fixed file path for a **Windows** environment.
2. **File Reading**: It reads the file line by line using `BufferedReader`.
3. **IP Address Extraction**: It extracts the IP address from each log entry by looking for the first space.
4. **DNS Resolution**: The program tries to resolve the extracted IP address to a hostname (e.g., `google.com`) using `InetAddress.getByName()`.
5. **Output**: If successful, it prints the resolved hostname and the rest of the log entry; if not, it prints an error message.
6. **Error Handling**: If the file can't be read or the IP address can't be resolved, it gracefully handles the errors with appropriate messages.

---

### **Sample Log File:**
sample log file (`weblog.txt`) :
```
192.168.1.1 - - [10/Jan/2025:10:10:10] "GET /index.html HTTP/1.1"
8.8.8.8 - - [10/Jan/2025:11:15:45] "POST /login HTTP/1.1"
```

### **Sample Output:**
```
host1.local - - [10/Jan/2025:10:10:10] "GET /index.html HTTP/1.1"
dns.google - - [10/Jan/2025:11:15:45] "POST /login HTTP/1.1"
```

If the IPs cannot be resolved, it will print something like:
```
Unable to resolve IP: 192.168.1.1
Unable to resolve IP: 8.8.8.8
```

---
