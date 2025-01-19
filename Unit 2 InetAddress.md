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
