## Unit 1: Introduction [3 Hrs.]


### 1.1 Network Programming Features and Scope

1. Which of the following best describes network programming?
   - a) Writing applications for local use
   - **b) Writing applications that communicate over a network**
   - c) Writing operating systems
   - d) Writing database management systems

2. What is a key feature of network programming?
   - a) Single-user interaction
   - b) File management
   - **c) Data exchange over networks**
   - d) Graphics rendering

3. What is the primary scope of network programming?
   - a) Designing user interfaces
   - **b) Enabling communication between devices**
   - c) Developing desktop applications
   - d) Building hardware components

### 1.2 Network Programming Language, Tools & Platforms

4. Which language is commonly used for network programming?
   - a) HTML
   - **b) Java**
   - c) Photoshop
   - d) SQL

5. What is a widely used tool for network programming?
   - a) Adobe Illustrator
   - b) Microsoft Word
   - **c) Wireshark**
   - d) Google Docs

6. Which platform is known for supporting network programming?
   - **a) UNIX/Linux**
   - b) Android
   - c) Windows Media Player
   - d) iTunes

### 1.3 Client and Server Applications

7. What is the role of a client in a client-server application?
   - **a) To request services**
   - b) To provide services
   - c) To manage databases
   - d) To handle user authentication

8. In a client-server application, what does the server do?
   - a) Sends emails
   - b) Browses the internet
   - **c) Responds to client requests**
   - d) Plays videos

### 1.4 Client-server Model and Software Design

9. What is a primary benefit of the client-server model?
   - a) Single-point failure
   - **b) Centralized control**
   - c) Decentralized data
   - d) Limited scalability

10. Which of the following is a crucial aspect of client-server software design?
    - a) User interface design
    - **b) Network communication protocols**
    - c) Database indexing
    - d) Memory management
_______________________________________________________________________________________________________________________________________________________

## Unit 2: Internet Addresses [4 Hrs.]


### 2.1 The InetAddress Class: Creating New InetAddress Objects, Getter Methods

1. What is the purpose of the InetAddress class in Java?
   - a) To handle file I/O operations
   - b) To create graphical user interfaces
   - **c) To represent an IP address**
   - d) To manage database connections

2. Which method is used to create a new InetAddress object by providing a hostname?
   - a) getHostName()
   - **b) getByName()**
   - c) getAddress()
   - d) getByHost()

### 2.2 Methods, Address Types, Testing Reachability and Object Methods

3. Which method of the InetAddress class is used to test if an address is reachable?
   - a) isReachableByHost()
   - b) canReach()
   - **c) isReachable()**
   - d) canConnect()

4. What type of addresses can InetAddress handle?
   - a) Only IPv4
   - b) Only IPv6
   - **c) Both IPv4 and IPv6**
   - d) Only MAC addresses

### 2.3 Inet4Address and Inet6Address

5. Which class is specifically used to represent an IPv4 address in Java?
   - **a) Inet4Address**
   - b) Inet6Address
   - c) InetAddress
   - d) URL

6. What distinguishes the Inet6Address class?
   - a) It represents MAC addresses
   - b) It represents domain names
   - **c) It represents IPv6 addresses**
   - d) It represents IPv4 addresses

### 2.4 The Network Interface Class: Factory Method & Getter Method

7. What is the role of the Network Interface class in Java?
   - **a) To represent a network interface on the local machine**
   - b) To handle user authentication
   - c) To manage file permissions
   - d) To render graphics

8. Which method in the Network Interface class returns all network interfaces on the machine?
   - a) getInterface()
   - b) listAll()
   - **c) getNetworkInterfaces()**
   - d) getAll()

### 2.5 Some Useful Programs: SpamCheck, Processing Web Server Logfiles

9. What is the primary function of a SpamCheck program?
   - a) To filter images
   - b) To manage databases
   - **c) To detect and filter spam emails**
   - d) To handle file compression

10. What is the purpose of processing web server log files?
    - **a) To analyze web traffic and user behavior**
    - b) To create dynamic web pages
    - c) To send email notifications
    - d) To encrypt web content


____________________________________________________________________________________________________________________________________________________________________________________________

## Unit 3: URLs and URIs [5 Hrs.]

### 3.1 URIs: URLs and Relative URLs

1. What does URI stand for?
   - a) Uniform Resource Internet
   - **b) Uniform Resource Identifier**
   - c) Unified Resource Index
   - d) Universal Resource Interface

2. Which of the following is an example of a relative URL?
   - a) **"/images/pic.jpg"**
   - b) "http://example.com/images/pic.jpg"
   - c) "ftp://fileserver.com/data"
   - d) "mailto:info@example.com"

### 3.2 The URL Class: Creating New URLs, Retrieving Data From a URL, Splitting a URL into Pieces, Equality & Comparison and Conversion

3. Which method in the URL class is used to create a new URL object?
   - a) createURL()
   - **b) new URL()**
   - c) generateURL()
   - d) buildURL()

4. How can you retrieve data from a URL in Java?
   - a) URL.openStream()
   - **b) URL.getContent()**
   - c) URL.readData()
   - d) URL.loadContent()

5. Which method is used to compare two URLs for equality in Java?
   - a) URL.equalsIgnoreCase()
   - **b) URL.equals()**
   - c) URL.compare()
   - d) URL.match()

6. Which of the following is NOT a part of a URL?
   - a) Protocol
   - **b) File path**
   - c) Host
   - d) Port

### 3.3 The URI Class: Constructing a URI, The Parts of the URI, Resolving Relative URIs, Equality & Comparison and String Representation

7. How do you create a new URI object in Java?
   - a) URI.newInstance()
   - b) URI.build()
   - **c) new URI()**
   - d) URI.create()

8. Which method is used to resolve a relative URI against a base URI?
   - **a) URI.resolve()**
   - b) URI.combine()
   - c) URI.concat()
   - d) URI.join()

9. What method would you use to get a string representation of a URI?
   - a) toString()
   - **b) toASCIIString()**
   - c) toCharArray()
   - d) toURIStr()

### 3.4 x-www-form-urlencoded: URL Encoder and URL Decoder

10. What is the purpose of URL encoding?
    - a) To encrypt URLs
    - b) To convert URLs to a secure format
    - **c) To encode characters in URLs that are not valid**
    - d) To compress URLs

11. Which method in Java is used to URL encode a string?
    - a) URLEncoder.encodeToURL()
    - b) URL.encodeString()
    - **c) URLEncoder.encode()**
    - d) URLStringEncoder.encode()

12. How do you decode a URL encoded string in Java?
    - a) URLDecoder.decodeString()
    - b) URL.decode()
    - **c) URLDecoder.decode()**
    - d) URLEncode.decode()

### 3.5 Proxies: System Properties, The ProxyClass and The ProxySelector Class

13. What is the purpose of a proxy server?
    - a) To store user credentials
    - **b) To act as an intermediary between a client and server**
    - c) To manage database transactions
    - d) To encode data

14. Which Java class is used to represent a proxy?
    - a) ProxyServer
    - b) ProxyAgent
    - **c) Proxy**
    - d) ProxyManager

15. How can you set system properties for proxies in Java?
    - a) Proxy.setProperties()
    - b) Proxy.configure()
    - **c) System.setProperty()**
    - d) ProxyManager.setProperties()

16. What is the role of the ProxySelector class?
    - a) To encode data
    - b) To manage user sessions
    - **c) To select the appropriate proxy for a connection**
    - d) To authenticate users

### 3.6 Communicating with Server-Side Programs Through GET

17. What HTTP method is typically used to send data to a server-side program while retrieving a resource?
    - **a) GET**
    - b) POST
    - c) PUT
    - d) DELETE

18. How can you send a GET request in Java?
    - a) URLConnection.sendGet()
    - b) HTTPClient.getRequest()
    - **c) HttpURLConnection.setRequestMethod("GET")**
    - d) WebClient.sendGet()

### 3.7 Accessing Password-Protected Sites: The Authenticator Class, The PasswordAuthentication Class and The JPasswordField Class

19. Which class in Java is used to provide authentication for accessing password-protected sites?
    - a) PasswordManager
    - **b) Authenticator**
    - c) CredentialProvider
    - d) UserAuthenticator

20. What is the purpose of the PasswordAuthentication class in Java?
    - a) To store encrypted files
    - **b) To store user credentials for authentication**
    - c) To manage user sessions
    - d) To encode URLs

_______________________________________________________________________________________________________________________________________________________________________

## Unit 4: HTTP [2 Hrs.]

### 4.1 The protocol: Keep-Alive

1. What is the primary purpose of the Keep-Alive header in HTTP?
   - a) To close the connection after each request
   - **b) To maintain the connection for multiple requests**
   - c) To encrypt the connection
   - d) To authenticate the user

2. Which of the following is a benefit of using Keep-Alive in HTTP?
   - a) Increased encryption
   - **b) Reduced latency**
   - c) Increased bandwidth usage
   - d) Reduced security

### 4.2 HTTP Methods

3. Which HTTP method is used to retrieve data from a server?
   - **a) GET**
   - b) POST
   - c) PUT
   - d) DELETE

4. Which HTTP method is used to submit data to be processed by a server?
   - a) GET
   - **b) POST**
   - c) PUT
   - d) DELETE

5. What does the HTTP method PUT do?
   - a) Retrieves data from the server
   - b) Deletes data on the server
   - **c) Updates or creates a resource on the server**
   - d) Submits a search query to the server

6. Which HTTP method is idempotent, meaning multiple identical requests should have the same effect as a single request?
   - **a) PUT**
   - b) POST
   - c) GET
   - d) DELETE

### 4.3 The Request Body

7. In which HTTP methods can the request body be included?
   - a) GET and DELETE
   - **b) POST and PUT**
   - c) PUT and DELETE
   - d) GET and POST

8. What kind of data can be included in the HTTP request body?
   - a) Only text data
   - b) Only JSON data
   - **c) Text, JSON, XML, and binary data**
   - d) Only URL-encoded form data

### 4.4 Cookies: CookieManager and CookiesStore

9. What is the purpose of cookies in HTTP?
   - **a) To store session data and track user information**
   - b) To encrypt HTTP requests
   - c) To authenticate users
   - d) To cache web pages

10. Which class in Java is used to manage cookies?
    - a) CookieHandler
    - **b) CookieManager**
    - c) CookieStore
    - d) CookieContainer


_______________________________________________________________________________________________________________________________________________________


## Unit 5: URLConnections [5 Hrs.]

### 5.1 Opening URLConnections

1. Which method is used to open a connection to a URL in Java?
   - a) URL.open()
   - **b) URL.openConnection()**
   - c) URL.connect()
   - d) URL.createConnection()

2. What type of object is returned by the URL.openConnection() method?
   - a) HttpURLConnection
   - b) DataInputStream
   - **c) URLConnection**
   - d) URLStream

### 5.2 Reading Data from Server

3. Which method of URLConnection is used to get an InputStream to read data from the server?
   - a) getOutputStream()
   - b) readData()
   - **c) getInputStream()**
   - d) getReader()

4. How can you read the content of a URLConnection as a string in Java?
   - a) InputStream.readAll()
   - **b) Using BufferedReader and InputStreamReader**
   - c) URLConnection.getContent()
   - d) URLConnection.readString()

### 5.3 Reading Header: Retrieving Specific Header Fields and Retrieving Arbitrary Header Fields

5. Which method retrieves the value of a specific header field from a URLConnection?
   - a) getHeader()
   - **b) getHeaderField()**
   - c) readHeader()
   - d) getHeaderValue()

6. How can you retrieve all header fields from a URLConnection?
   - **a) getHeaderFields()**
   - b) getAllHeaders()
   - c) getAllFields()
   - d) readHeaders()

### 5.4 Cache: Web Cache for Java

7. What is the primary purpose of a web cache?
   - a) To encrypt data
   - b) To authenticate users
   - **c) To store and reuse frequently accessed data**
   - d) To compress data

8. Which class in Java can be used to implement a simple web cache?
   - a) CacheManager
   - **b) ResponseCache**
   - c) URLCache
   - d) DataCache

### 5.5 Configuring the Connection

9. What does the doInput field in URLConnection represent?
   - a) Whether the connection allows output
   - **b) Whether the connection allows input**
   - c) Whether the connection uses caches
   - d) Whether the connection allows user interaction

10. Which field determines if user interaction is allowed in URLConnection?
    - a) doOutput
    - **b) allowUserInteraction**
    - c) useCaches
    - d) connected

11. How can you set the connection to use caches in URLConnection?
    - a) setCaching(true)
    - b) enableCaching()
    - **c) setUseCaches(true)**
    - d) allowCaching()

### 5.6 Configuring the Client Request HTTP Header

12. Which method is used to set a request property in the HTTP header of a URLConnection?
    - **a) setRequestProperty()**
    - b) addRequestProperty()
    - c) setHeader()
    - d) addHeader()

13. How do you set the user-agent in an HTTP request header using URLConnection?
    - a) setHeader("User-Agent", "value")
    - **b) setRequestProperty("User-Agent", "value")**
    - c) addRequestProperty("User-Agent", "value")
    - d) setUserAgent("value")

### 5.7 Security Considerations for URLConnections

14. What is a common security consideration when using URLConnection?
    - a) Performance optimization
    - b) Data caching
    - **c) Data confidentiality and integrity**
    - d) User interaction

15. Which class is commonly used to establish secure connections in Java?
    - **a) HttpsURLConnection**
    - b) URLSecureConnection
    - c) SecureURLConnection
    - d) HttpSecureConnection

### 5.8 Guessing MIME Media Types

16. What is the purpose of guessing MIME media types in URLConnection?
    - a) To compress data
    - **b) To determine the type of data being transmitted**
    - c) To authenticate users
    - d) To encrypt data

17. Which method can be used to guess the content type of a URLConnection?
    - a) guessType()
    - b) getContentType()
    - **c) guessContentTypeFromStream()**
    - d) getType()

### 5.9 HttpURLConnection: The Request Methods, Disconnecting from the Server, Handling Server Responses, Proxies and Streaming Mode

18. Which method in HttpURLConnection is used to set the HTTP request method?
    - a) setMethod()
    - b) setRequest()
    - **c) setRequestMethod()**
    - d) setHTTPMethod()

19. How do you disconnect from a server using HttpURLConnection?
    - a) close()
    - **b) disconnect()**
    - c) terminate()
    - d) endConnection()

20. What is the purpose of setting streaming mode in HttpURLConnection?
    - a) To enable data compression
    - **b) To handle large data transfers efficiently**
    - c) To encrypt data
    - d) To authenticate the connection

____________________________________________________________________________________________________________________________________________________________

## Unit 6: Socket for Clients [5 Hrs.]

### 6.1 Introduction to Socket

1. What is a socket in networking?
   - a) A protocol for data encryption
   - b) A hardware device for network connection
   - **c) An endpoint for communication between two machines**
   - d) A software application for browsing the internet

2. Which class in Java is used to create client-side sockets?
   - a) ServerSocket
   - **b) Socket**
   - c) DatagramSocket
   - d) URLConnection

### 6.2 Using Sockets: Investigating Protocols with telnet, Reading from Servers with Sockets, Writing to Servers with Sockets

3. What tool can be used to investigate network protocols by connecting to a server manually?
   - a) ping
   - b) traceroute
   - **c) telnet**
   - d) nslookup

4. How do you read data from a server using a socket in Java?
   - a) socket.getOutputStream()
   - **b) socket.getInputStream()**
   - c) socket.read()
   - d) socket.receive()

5. Which method is used to write data to a server using a socket in Java?
   - a) socket.sendData()
   - b) socket.write()
   - **c) socket.getOutputStream().write()**
   - d) socket.getOutput()

### 6.3 Constructing and Connecting Sockets: Basic Constructors, Picking a Local Interface to Connect From, Constructing Without Connecting, Socket Addresses and Proxy Servers

6. Which constructor is used to create a socket and immediately connect to a server?
   - a) new Socket()
   - **b) new Socket(String host, int port)**
   - c) new Socket(InetAddress address)
   - d) new Socket(int port)

7. How can you specify a local network interface to use for connecting a socket?
   - a) Socket.setLocalInterface()
   - **b) new Socket(InetAddress localAddr, int localPort, InetAddress remoteAddr, int remotePort)**
   - c) Socket.setInterface()
   - d) Socket.bind()

8. How do you construct a socket without immediately connecting to a server?
   - **a) new Socket()**
   - b) new Socket(int port)
   - c) new Socket(String host, int port)
   - d) new Socket(InetAddress address, int port)

### 6.4 Getting Information about a Socket: Closed or Connected?, toString()

9. How can you check if a socket is connected in Java?
   - a) socket.isOpen()
   - **b) socket.isConnected()**
   - c) socket.isBound()
   - d) socket.isAlive()

10. Which method provides a string representation of a socket?
    - a) toSocketString()
    - b) getString()
    - **c) toString()**
    - d) stringify()

### 6.5 Setting Socket Options: TCP_NODELAY, SO_LINGER, SO_TIMEOUT, SO_RCVBUF and SO_SNDBUF, SO_KEEPALIVE, OOBINLINE, SO_REUSEADDR and IP_TOS Class of Services

11. What does the TCP_NODELAY option do when set on a socket?
    - a) Enables Nagle's algorithm
    - **b) Disables Nagle's algorithm**
    - c) Sets the timeout for connections
    - d) Enables keep-alive messages

12. Which socket option controls the linger time when a socket is closed?
    - a) SO_TIMEOUT
    - **b) SO_LINGER**
    - c) SO_KEEPALIVE
    - d) SO_RCVBUF

13. What is the purpose of the SO_TIMEOUT option in a socket?
    - **a) Sets the timeout for read operations**
    - b) Sets the timeout for write operations
    - c) Sets the timeout for connection establishment
    - d) Sets the timeout for close operations

14. Which socket option sets the size of the receive buffer?
    - a) SO_SNDBUF
    - **b) SO_RCVBUF**
    - c) SO_LINGER
    - d) SO_TIMEOUT

15. What does the SO_KEEPALIVE option enable?
    - a) Immediate data transmission
    - b) Connection timeout
    - **c) Periodic keep-alive messages**
    - d) Data encryption

16. Which option allows sending out-of-band data in a socket?
    - a) SO_TIMEOUT
    - **b) OOBINLINE**
    - c) SO_LINGER
    - d) SO_KEEPALIVE

17. What is the effect of setting the SO_REUSEADDR option on a socket?
    - a) Enables keep-alive messages
    - b) Sets the receive buffer size
    - **c) Allows the socket to bind to an address that is already in use**
    - d) Disables Nagle's algorithm

### 6.6 Socket in GUI Applications: Whois and A Network Client Library

18. What is the purpose of a Whois client in networking?
    - a) To resolve IP addresses
    - b) To transfer files
    - **c) To query information about domain names**
    - d) To encrypt data

19. In a GUI application, how can you display data received from a socket?
    - a) Using a SocketPanel
    - **b) Using a JTextArea**
    - c) Using a SocketField
    - d) Using a DataPane

20. Which Java class is commonly used to create a simple network client library for socket communication?
    - **a) Socket**
    - b) DatagramSocket
    - c) ServerSocket
    - d) URLConnection

__________________________________________________________________________________________________________________________________________________-

## Unit 7: Socket for Servers [5 Hrs.]

### 7.1 Using ServerSockets: Serving Binary Data, Multithreaded Servers, Writing to Servers with Sockets, and Closing Server Sockets

1. Which class in Java is used to create server-side sockets?
   - a) Socket
   - b) DatagramSocket
   - **c) ServerSocket**
   - d) URLConnection

2. How can a server socket accept incoming client connections in Java?
   - a) serverSocket.open()
   - **b) serverSocket.accept()**
   - c) serverSocket.connect()
   - d) serverSocket.listen()

3. What is a primary advantage of a multithreaded server?
   - a) Reduces server memory usage
   - **b) Allows handling multiple client connections simultaneously**
   - c) Increases data encryption
   - d) Simplifies server coding

4. How do you close a server socket in Java?
   - a) serverSocket.terminate()
   - b) serverSocket.stop()
   - **c) serverSocket.close()**
   - d) serverSocket.disconnect()

### 7.2 Logging: What to Log and How to Log

5. Why is logging important in server applications?
   - a) To increase data transmission speed
   - b) To encrypt server data
   - **c) To track server activity and diagnose issues**
   - d) To authenticate users

6. Which Java class is commonly used for logging server activities?
   - **a) java.util.logging.Logger**
   - b) java.util.Log
   - c) java.util.FileHandler
   - d) java.util.Console

### 7.3 Constructing Server Sockets: Constructing Without Binding

7. How do you construct a server socket without binding it to a specific port initially?
   - **a) new ServerSocket()**
   - b) new ServerSocket(int port)
   - c) new ServerSocket(String host)
   - d) new ServerSocket(InetAddress address)

8. How do you bind a server socket to a specific port after it has been constructed?
   - a) serverSocket.open(port)
   - b) serverSocket.connect(port)
   - **c) serverSocket.bind(new InetSocketAddress(port))**
   - d) serverSocket.setPort(port)

### 7.4 Getting Information about Server Socket

9. How can you check if a server socket is bound to a specific address or port?
   - a) serverSocket.isConnected()
   - b) serverSocket.isOpen()
   - **c) serverSocket.isBound()**
   - d) serverSocket.isAlive()

10. Which method provides a string representation of a server socket?
    - a) toServerString()
    - b) getString()
    - **c) toString()**
    - d) stringify()

### 7.5 Socket Options: SO_TIMEOUT, SO_REUSEADDR, SO_RCVBUF, and Class of Service

11. What does the SO_TIMEOUT option do when set on a server socket?
    - a) Enables Nagle's algorithm
    - **b) Sets the timeout for client connection accept operations**
    - c) Sets the timeout for read operations
    - d) Enables keep-alive messages

12. Which socket option allows a server socket to bind to an address that is already in use?
    - a) SO_TIMEOUT
    - b) SO_KEEPALIVE
    - **c) SO_REUSEADDR**
    - d) SO_LINGER

13. What is the purpose of the SO_RCVBUF option in a server socket?
    - a) Sets the size of the send buffer
    - **b) Sets the size of the receive buffer**
    - c) Sets the timeout for connections
    - d) Enables keep-alive messages

14. Which option would you use to specify the class of service for a socket connection?
    - a) SO_TIMEOUT
    - b) SO_RCVBUF
    - **c) IP_TOS**
    - d) SO_REUSEADDR

### 7.6 HTTP Servers: A Single File Server, A Redirector, and A Full-Fledged HTTP Server

15. What is the primary function of an HTTP server?
    - a) To encrypt data
    - **b) To serve web pages and resources to clients**
    - c) To log server activity
    - d) To authenticate users

16. Which of the following describes a single file server?
    - a) **A server that serves a single file to all clients**
    - b) A server that redirects all requests to another server
    - c) A server that provides a complete set of web services
    - d) A server that handles multiple files dynamically

17. What is the role of a redirector in an HTTP server?
    - **a) To forward client requests to another server or resource**
    - b) To encrypt HTTP requests
    - c) To compress data before sending
    - d) To authenticate users

18. How can you create a basic HTTP server in Java?
    - a) Using ServerSocket and manually parsing HTTP requests
    - b) Using HttpURLConnection
    - **c) Using com.sun.net.httpserver.HttpServer**
    - d) Using DatagramSocket

19. What class is commonly used to handle HTTP requests in a full-fledged HTTP server in Java?
    - a) Socket
    - **b) HttpHandler**
    - c) URLConnection
    - d) ServerSocket

20. Which method is used to start an HttpServer instance in Java?
    - a) server.open()
    - b) server.listen()
    - **c) server.start()**
    - d) server.connect()
