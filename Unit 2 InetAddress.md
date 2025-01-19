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

!
