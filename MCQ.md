### **Unit 1: Introduction**  
1. What is the primary purpose of network programming?  
   a) To design hardware components  
   b) To enable communication between devices over a network  
   **c) To develop software that facilitates data exchange over networks**  
   d) To create standalone desktop applications  

2. Which of the following is NOT a network programming language?  
   a) Java  
   b) Python  
   **c) HTML**  
   d) C++  

3. In the client-server model, the client is responsible for:  
   **a) Requesting services or resources**  
   b) Storing all the data permanently  
   c) Managing the entire network  
   d) Providing services to multiple servers  

4. Which protocol is commonly used in client-server applications?  
   a) FTP  
   **b) HTTP**  
   c) SMTP  
   d) All of the above  

5. What is a key feature of network programming?  
   a) Single-user interaction  
   **b) Inter-process communication over a network**  
   c) Only local file handling  
   d) No need for protocols  

6. Which tool is commonly used for network debugging?  
   a) Eclipse  
   **b) Wireshark**  
   c) Photoshop  
   d) MySQL  

7. In network programming, what does "server" refer to?  
   a) A physical computer only  
   **b) A software application providing services**  
   c) A client-side application  
   d) A network cable  

8. Which of the following is a network programming platform?  
   a) Android Studio  
   **b) Node.js**  
   c) Microsoft Word  
   d) Adobe Reader  

9. The client-server model is based on:  
   a) Peer-to-peer communication only  
   **b) Request-response architecture**  
   c) Only hardware interaction  
   d) No specific structure  

10. Which is NOT a part of network software design?  
    a) Protocol selection  
    b) Error handling  
    **c) Graphic design**  
    d) Data serialization  

11. What is a common use of network programming?  
    a) Creating video games  
    **b) Building web applications**  
    c) Writing standalone text editors  
    d) None of the above  

12. Which language is widely used for server-side programming?  
    a) HTML  
    **b) Java**  
    c) CSS  
    d) XML  

13. The scope of network programming includes:  
    a) Only local machine processes  
    **b) Distributed systems and internet applications**  
    c) Only hardware maintenance  
    d) None of the above  

---

### **Unit 2: Internet Addresses**  
1. The `InetAddress` class is used to represent:  
   a) A file path  
   **b) An IP address**  
   c) A URL  
   d) A MAC address  

2. Which method checks if an IP address is reachable?  
   a) `getHostName()`  
   **b) `isReachable()`**  
   c) `getAddress()`  
   d) `toString()`  

3. `Inet4Address` represents:  
   **a) IPv4 addresses**  
   b) IPv6 addresses  
   c) MAC addresses  
   d) Domain names  

4. Which class represents a network interface?  
   a) `InetSocketAddress`  
   **b) `NetworkInterface`**  
   c) `URL`  
   d) `DatagramPacket`  

5. The `getByName()` method of `InetAddress` returns:  
   a) A port number  
   **b) An IP address for a given hostname**  
   c) A MAC address  
   d) A URL  

6. Which method retrieves all IP addresses of a host?  
   a) `getLocalHost()`  
   **b) `getAllByName()`**  
   c) `getHostAddress()`  
   d) `getLoopbackAddress()`  

7. What does `Inet6Address` represent?  
   a) IPv4 addresses  
   **b) IPv6 addresses**  
   c) MAC addresses  
   d) HTTP URLs  

8. Which method gets the hostname from an `InetAddress`?  
   **a) `getHostName()`**  
   b) `getAddress()`  
   c) `isReachable()`  
   d) `getByName()`  

9. The `NetworkInterface` class helps in:  
   a) Creating web pages  
   **b) Managing network interfaces**  
   c) Writing files  
   d) None of the above  

10. Which method checks if an IP is a loopback address?  
    a) `isSiteLocalAddress()`  
    **b) `isLoopbackAddress()`**  
    c) `isAnyLocalAddress()`  
    d) `isMulticastAddress()`  

11. Which class is used for spam checking?  
    a) `URL`  
    **b) `InetAddress`**  
    c) `Socket`  
    d) `ServerSocket`  

12. Which method returns the raw IP address in bytes?  
    a) `getHostName()`  
    **b) `getAddress()`**  
    c) `toString()`  
    d) `getHostAddress()`  

13. What is the purpose of `getNetworkInterfaces()`?  
    a) To fetch all open ports  
    **b) To list all network interfaces**  
    c) To get IP addresses only  
    d) To block network traffic  

---

### **Unit 3: URLs and URIs**  
1. A URL stands for:  
   a) Uniform Resource Locator  
   **b) Both a and c**  
   c) Universal Resource Locator  
   d) None of the above  

2. Which class is used to parse URLs in Java?  
   a) `URI`  
   **b) `URL`**  
   c) `InetAddress`  
   d) `Socket`  

3. What does `URLEncoder.encode()` do?  
   a) Decodes a URL  
   **b) Encodes a URL string**  
   c) Opens a connection  
   d) None of the above  

4. Which method retrieves the protocol of a URL?  
   a) `getHost()`  
   **b) `getProtocol()`**  
   c) `getPort()`  
   d) `getFile()`  

5. A URI can be:  
   a) Absolute  
   b) Relative  
   **c) Both a and b**  
   d) Neither  

6. Which class is more strict in syntax: `URL` or `URI`?  
   a) `URL`  
   **b) `URI`**  
   c) Both are the same  
   d) Neither  

7. What does `URL.openStream()` return?  
   a) A `Socket` object  
   **b) An `InputStream`**  
   c) A `String`  
   d) A `File`  

8. Which method resolves a relative URI against a base URI?  
   a) `compareTo()`  
   **b) `resolve()`**  
   c) `normalize()`  
   d) `relativize()`  

9. What is `x-www-form-urlencoded` used for?  
   a) Encrypting data  
   **b) Encoding form data in URLs**  
   c) Creating cookies  
   d) None of the above  

10. Which class manages proxy settings?  
    a) `Proxy`  
    b) `ProxySelector`  
    **c) Both a and b**  
    d) None  

11. Which method retrieves query parameters from a URL?  
    a) `getPath()`  
    **b) `getQuery()`**  
    c) `getRef()`  
    d) `getAuthority()`  

12. Which class is used for password authentication?  
    a) `PasswordField`  
    **b) `Authenticator`**  
    c) `CookieManager`  
    d) `URLConnection`  

13. What does `URI.normalize()` do?  
    a) Resolves relative paths  
    **b) Removes redundant path segments**  
    c) Encodes the URI  
    d) Decodes the URI  

---

### **Unit 4: HTTP**  
1. What does HTTP stand for?  
   a) Hyper Transfer Text Protocol  
   **b) Hypertext Transfer Protocol**  
   c) High Transfer Text Protocol  
   d) Hyperlink Transfer Protocol  

2. Which HTTP method retrieves data from a server?  
   **a) GET**  
   b) POST  
   c) PUT  
   d) DELETE  

3. What is the purpose of HTTP Keep-Alive?  
   a) To terminate connections immediately  
   **b) To maintain a persistent connection**  
   c) To encrypt data  
   d) To block requests  

4. Which HTTP method is used to send data to a server?  
   a) GET  
   **b) POST**  
   c) HEAD  
   d) OPTIONS  

5. What does the HTTP request body contain?  
   a) Only headers  
   **b) Data sent to the server (e.g., form data)**  
   c) Only URLs  
   d) None of the above  

6. Which class manages cookies in Java?  
   a) `Cookie`  
   **b) `CookieManager`**  
   c) `HttpCookie`  
   d) `URLConnection`  

7. What is the role of `CookieStore`?  
   a) To delete all cookies  
   **b) To store and retrieve HTTP cookies**  
   c) To block cookies  
   d) To encrypt cookies  

8. Which HTTP method is idempotent?  
   **a) GET**  
   b) POST  
   c) Both a and b  
   d) None  

9. What is the default port for HTTP?  
   a) 443  
   **b) 80**  
   c) 8080  
   d) 21  

10. Which header field indicates the content type in HTTP?  
    a) `Content-Length`  
    **b) `Content-Type`**  
    c) `Host`  
    d) `User-Agent`  

11. What does the HTTP `HEAD` method do?  
    a) Sends data to the server  
    **b) Retrieves headers only (no body)**  
    c) Deletes a resource  
    d) None of the above  

12. Which class is used for HTTP URL connections in Java?  
    a) `Socket`  
    **b) `HttpURLConnection`**  
    c) `InetAddress`  
    d) `DatagramPacket`  

13. What is the purpose of the `User-Agent` header?  
    a) To identify the server  
    **b) To identify the client (browser/application)**  
    c) To encrypt requests  
    d) To block requests  

---

### **Unit 5: URLConnections**  
1. What does `URLConnection` represent?  
   a) A physical network cable  
   **b) A connection to a URL resource**  
   c) A DNS server  
   d) A file system  

2. Which method opens a connection to a URL?  
   a) `connect()`  
   **b) `openConnection()`**  
   c) `getInputStream()`  
   d) `getHeaderFields()`  

3. What does `URLConnection.setDoOutput(true)` enable?  
   a) Only reading data  
   **b) Writing data to the server**  
   c) Closing the connection  
   d) None of the above  

4. Which method retrieves HTTP response headers?  
   a) `getContent()`  
   **b) `getHeaderFields()`**  
   c) `getURL()`  
   d) `getLastModified()`  

5. What is the purpose of `useCaches` in `URLConnection`?  
   a) To disable all caching  
   **b) To control whether cached data is used**  
   c) To delete caches  
   d) To encrypt cached data  

6. Which method sets a timeout for `URLConnection`?  
   a) `setReadTimeout()`  
   **b) `setConnectTimeout()`**  
   c) `setDoInput()`  
   d) `setAllowUserInteraction()`  

7. What does `HttpURLConnection` extend?  
   a) `Socket`  
   **b) `URLConnection`**  
   c) `InetAddress`  
   d) `DatagramPacket`  

8. Which HTTP method is set via `HttpURLConnection.setRequestMethod()`?  
   a) `GET`  
   b) `POST`  
   **c) Both a and b**  
   d) None  

9. What is the purpose of `getResponseCode()`?  
   a) To get the URL  
   **b) To get the HTTP status code (e.g., 200, 404)**  
   c) To close the connection  
   d) To read data  

10. Which class guesses MIME types?  
    a) `URLEncoder`  
    **b) `MimeType`**  
    c) `Socket`  
    d) `ProxySelector`  

11. What does `setRequestProperty()` do in `URLConnection`?  
    a) Closes the connection  
    **b) Sets an HTTP request header**  
    c) Reads data  
    d) None of the above  

12. Which method reads data from a `URLConnection`?  
    a) `getOutputStream()`  
    **b) `getInputStream()`**  
    c) `getHeaderField()`  
    d) `disconnect()`  

13. What is the role of `ifModifiedSince` in `URLConnection`?  
    a) To always fetch new data  
    **b) To fetch data only if modified after a given time**  
    c) To block requests  
    d) To delete old data  

---

### **Unit 6: Socket for Clients**  
1. What is a socket in networking?  
   a) A physical port  
   **b) An endpoint for communication between two machines**  
   c) A protocol  
   d) A URL  

2. Which class is used for client-side sockets in Java?  
   a) `ServerSocket`  
   **b) `Socket`**  
   c) `DatagramSocket`  
   d) `URLConnection`  

3. What does `Socket.getInputStream()` return?  
   a) An output stream to the server  
   **b) An input stream to read data from the server**  
   c) A file stream  
   d) None of the above  

4. Which method checks if a socket is connected?  
   a) `isClosed()`  
   **b) `isConnected()`**  
   c) `isBound()`  
   d) `isOutputShutdown()`  

5. What does `SO_TIMEOUT` do in socket programming?  
   a) Sets a timeout for connection establishment  
   **b) Sets a timeout for read operations**  
   c) Closes the socket immediately  
   d) None of the above  

6. Which option disables Nagle’s algorithm in TCP?  
   **a) `TCP_NODELAY`**  
   b) `SO_KEEPALIVE`  
   c) `SO_LINGER`  
   d) `SO_REUSEADDR`  

7. What is the purpose of `SO_KEEPALIVE`?  
   a) To terminate idle connections  
   **b) To check if the connection is still alive**  
   c) To encrypt data  
   d) To block connections  

8. Which method writes data to a socket?  
   a) `getInputStream()`  
   **b) `getOutputStream()`**  
   c) `getPort()`  
   d) `close()`  

9. What does `Socket.setSoLinger()` control?  
   a) Connection timeout  
   **b) How long the socket waits for unsent data on close**  
   c) Read buffer size  
   d) None  

10. Which class represents a socket address?  
    a) `InetSocketAddress`  
    **b) `SocketAddress`**  
    c) `NetworkInterface`  
    d) `Proxy`  

11. What is the default value of `SO_REUSEADDR`?  
    a) `true`  
    **b) `false`**  
    c) Depends on OS  
    d) None  

12. Which method binds a socket to a local address?  
    a) `connect()`  
    **b) `bind()`**  
    c) `close()`  
    d) `getLocalPort()`  

13. What does `Socket.getPort()` return?  
    a) The local port  
    **b) The remote port**  
    c) The IP address  
    d) None  

---

### **Unit 7: Socket for Servers**  
1. Which class is used for server-side sockets in Java?  
   a) `Socket`  
   **b) `ServerSocket`**  
   c) `DatagramSocket`  
   d) `URL`  

2. What does `ServerSocket.accept()` do?  
   a) Closes the server  
   **b) Waits for and accepts a client connection**  
   c) Sends data  
   d) None  

3. Which method sets the `SO_TIMEOUT` for `ServerSocket`?  
   **a) `setSoTimeout()`**  
   b) `setReceiveBufferSize()`
   c) `setReuseAddress()`  
   d) `close()`  

4. What is the purpose of `SO_REUSEADDR`?  
   a) To block connections  
   **b) To allow reusing a bound port**  
   c) To encrypt data  
   d) None  

5. Which method gets the local port of a `ServerSocket`?  
   a) `getPort()`  
   **b) `getLocalPort()`**  
   c) `getInetAddress()`  
   d) `close()`  

6. What does a multithreaded server do?  
   a) Handles one client at a time  
   **b) Handles multiple clients concurrently**  
   c) Only accepts connections  
   d) None  

7. Which method closes a `ServerSocket`?  
   a) `shutdown()`  
   **b) `close()`**  
   c) `disconnect()`  
   d) `stop()`  

8. What is the role of `ServerSocketChannel`?  
   a) For UDP communication  
   **b) For non-blocking server sockets**  
   c) For HTTP requests  
   d) None  

9. Which option sets the receive buffer size?  
   a) `SO_SNDBUF`  
   **b) `SO_RCVBUF`**  
   c) `SO_LINGER`  
   d) `TCP_NODELAY`  

10. What does `ServerSocket.getInetAddress()` return?  
    a) The client’s IP  
    **b) The server’s bound IP**  
    c) The remote port  
    d) None  

11. Which method binds a `ServerSocket` to a port?  
    a) `connect()`  
    **b) `bind()`**  
    c) `accept()`  
    d) `close()`  

12. What is the default backlog value in `ServerSocket`?  
    a) 10  
    **b) 50**  
    c) 100  
    d) 1  

13. Which exception is thrown if a port is already in use?  
    a) `IOException`  
    **b) `BindException`**  
    c) `SocketException`  
    d) `UnknownHostException`  

---

### **Unit 8: Secure Sockets (SSL/TLS)**
1. What does SSL stand for in network security?
   a) Secure Socket Layer
   b) Server Security Layer
   c) Simple Security Layer
   **d) Secure Sockets Layer**

2. Which class is used to create secure client sockets in Java?
   a) SSLSocketFactory
   **b) SSLSocket**
   c) SecureSocket
   d) SSLClientSocket

3. What is the primary purpose of SSL handshaking?
   a) To increase connection speed
   **b) To establish secure parameters**
   c) To reduce bandwidth
   d) To bypass firewalls

4. Which port is typically used for HTTPS connections?
   a) 80
   **b) 443**
   c) 8080
   d) 21

5. What does TLS stand for?
   **a) Transport Layer Security**
   b) Transfer Layer Security
   c) Transmission Link Security
   d) Transport Link Security

6. Which method is used to enable all security protocols in Java?
   a) setEnabledProtocols()
   **b) setEnabledCipherSuites()**
   c) setSecurityProtocol()
   d) enableAllSecurity()

7. What is the purpose of a keystore in SSL?
   **a) To store private keys and certificates**
   b) To cache SSL sessions
   c) To store encrypted data
   d) To log security events

8. Which class manages SSL server sockets?
   a) SSLServer
   **b) SSLServerSocket**
   c) SecureServer
   d) TLSSocket

9. What is session resumption in SSL/TLS?
   a) Terminating old sessions
   **b) Reusing previous session parameters**
   c) Creating multiple sessions
   d) None of the above

10. Which component verifies server authenticity in SSL?
    **a) Certificate Authority (CA)**
    b) IP address
    c) MAC address
    d) HTTP headers

11. What does hostname verification ensure in SSL?
    a) Server speed
    **b) Certificate matches the hostname**
    c) Data encryption strength
    d) Protocol version

12. Which Java class handles SSL context configuration?
    a) SSLConfig
    **b) SSLContext**
    c) SecurityManager
    d) KeyManager

13. What is the purpose of the TrustManager in SSL?
    a) To generate keys
    **b) To verify remote credentials**
    c) To encrypt data
    d) To manage sessions

### **Unit 9: Non-Blocking I/O**
1. What is the main advantage of NIO over traditional IO?
   a) Simpler programming model
   **b) Better performance with many connections**
   c) Stronger security
   d) Built-in compression

2. Which package contains Java NIO classes?
   a) java.io
   **b) java.nio**
   c) java.net
   d) java.security

3. What is a Buffer in NIO?
   **a) A container for data of a primitive type**
   b) A network interface
   c) A security protocol
   d) A thread pool

4. Which method flips a buffer?
   a) clear()
   **b) flip()**
   c) rewind()
   d) compact()

5. What does Selector do in NIO?
   a) Encrypts data
   **b) Monitors multiple channels for I/O readiness**
   c) Compresses data
   d) Manages threads

6. Which class represents a non-blocking socket channel?
   a) Socket
   **b) SocketChannel**
   c) NioSocket
   d) AsyncSocket

7. What is the purpose of SelectionKey?
   **a) Represents a channel registered with a selector**
   b) Encrypts network data
   c) Manages thread pools
   d) Caches data

8. Which buffer method prepares for reading after writing?
   a) clear()
   **b) flip()**
   c) mark()
   d) reset()

9. What does Channel represent in NIO?
   a) A physical connection
   **b) A conduit for I/O operations**
   c) A security tunnel
   d) A protocol handler

10. Which NIO feature helps with scalability?
    **a) Selectors**
    b) Buffers
    c) Charsets
    d) FileLock

11. What is DirectBuffer in NIO?
    **a) A buffer that uses native memory**
    b) A buffer for TCP connections
    c) A buffer for UDP packets
    d) A thread-safe buffer

12. Which method checks if a channel is connected?
    a) isOpen()
    **b) isConnected()**
    c) isRegistered()
    d) isBlocking()

13. What is the purpose of FileChannel?
    a) Network communication
    **b) File I/O operations**
    c) Data encryption
    d) Thread management

### **Unit 10: UDP**
1. What does UDP stand for?
   **a) User Datagram Protocol**
   b) Universal Data Protocol
   c) User Data Packet
   d) Unified Datagram Port

2. Which class represents a UDP packet in Java?
   a) UDPPacket
   **b) DatagramPacket**
   c) UDPSocket
   d) NetworkPacket

3. What is the main characteristic of UDP?
   a) Reliable delivery
   **b) Connectionless communication**
   c) Flow control
   d) Error correction

4. Which class sends/receives UDP packets?
   a) UDPSocket
   **b) DatagramSocket**
   c) NetworkSocket
   d) PacketSocket

5. What is the maximum size of a UDP packet?
   **a) 65,507 bytes**
   b) 1,500 bytes
   c) 1,024 bytes
   d) Unlimited

6. Which method receives a UDP packet?
   a) send()
   **b) receive()**
   c) read()
   d) get()

7. What does SO_BROADCAST socket option enable?
   **a) Sending broadcast packets**
   b) Receiving multicast packets
   c) Encrypting packets
   d) Packet compression

8. Which class provides non-blocking UDP in NIO?
   **a) DatagramChannel**
   b) UDPSocket
   c) NioDatagram
   d) AsyncUDP

9. What is the purpose of setSoTimeout() for UDP?
   **a) Sets maximum wait time for receive()**
   b) Sets packet size limit
   c) Enables encryption
   d) None of the above

10. Which method sends a UDP packet?
    **a) send()**
    b) write()
    c) transmit()
    d) post()

11. What does connect() do for UDP sockets?
    **a) Filters packets from other addresses**
    b) Establishes a connection
    c) Enables reliability
    d) None

12. Which socket option enables port reuse?
    a) SO_KEEPALIVE
    **b) SO_REUSEADDR**
    c) SO_LINGER
    d) SO_BROADCAST

13. What is multicast in UDP?
    **a) Sending to multiple recipients**
    b) Reliable delivery
    c) Encrypted transmission
    d) None

### **Unit 11: IP Multicast**
1. What is a multicast address range?
   a) 0.0.0.0 - 127.255.255.255
   **b) 224.0.0.0 - 239.255.255.255**
   c) 192.168.0.0 - 192.168.255.255
   d) 172.16.0.0 - 172.31.255.255

2. Which class handles multicast in Java?
   a) MulticastSocket
   **b) DatagramSocket**
   c) UDPSocket
   d) NetworkSocket

3. What does TTL stand for in multicast?
   **a) Time To Live**
   b) Transport Layer Type
   c) Transmission Time Limit
   d) Total Traffic Load

4. Which method joins a multicast group?
   **a) joinGroup()**
   b) connect()
   c) subscribe()
   d) addMember()

5. What is the purpose of setInterface()?
   **a) Selects network interface for multicast**
   b) Sets IP address
   c) Configures port
   d) None

6. Which method leaves a multicast group?
   **a) leaveGroup()**
   b) disconnect()
   c) unsubscribe()
   d) removeMember()

7. What is the default TTL for multicast packets?
   **a) 1**
   b) 32
   c) 64
   d) 128

8. Which class represents a multicast group?
   a) MulticastGroup
   **b) InetAddress**
   c) NetworkGroup
   d) UDPGroup

9. What does setTimeToLive() control?
   **a) How far packets travel**
   b) Packet size
   c) Encryption
   d) None

10. Which network devices forward multicast?
    **a) Routers with multicast support**
    b) All switches
    c) Hubs
    d) None

### **Unit 12: RMI**
1. What does RMI stand for?
   **a) Remote Method Invocation**
   b) Remote Machine Interface
   c) Reliable Message Interchange
   d) Resource Management Interface

2. Which design pattern does RMI implement?
   a) Singleton
   **b) Proxy**
   c) Factory
   d) Observer

3. What is the role of rmic compiler?
   **a) Generates stubs and skeletons**
   b) Compiles Java code
   c) Creates interfaces
   d) None

4. Which registry runs RMI services?
   **a) rmiregistry**
   b) javac
   c) java
   d) rmic

5. What must remote objects implement?
   **a) Remote interface**
   b) Serializable
   c) Cloneable
   d) Runnable

6. Which exception occurs in RMI communication?
   **a) RemoteException**
   b) IOException
   c) SQLException
   d) NullPointerException

7. What is a stub in RMI?
   **a) Client-side proxy**
   b) Server implementation
   c) Registry
   d) None

8. Which method exports remote objects?
   **a) UnicastRemoteObject.exportObject()**
   b) RMI.export()
   c) Remote.export()
   d) None

9. What is the default RMI registry port?
   **a) 1099**
   b) 8080
   c) 80
   d) 443

10. How are objects passed in RMI?
    **a) By value using serialization**
    b) By reference
    c) By pointer
    d) None

11. Which class is the base for remote objects?
    **a) UnicastRemoteObject**
    b) RemoteServer
    c) RMIServer
    d) None

12. What is the purpose of Naming.rebind()?
    **a) Registers a remote object**
    b) Connects to a server
    c) Serializes objects
    d) None

13. What security policy does RMI require?
    **a) SecurityManager with proper permissions**
    b) No security needed
    c) SSL encryption
    d) None
