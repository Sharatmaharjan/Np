### Unit 12: Remote Method Invocation (RMI)

Remote Method Invocation (RMI) is a Java API that allows an object residing in one Java Virtual Machine (JVM) to invoke methods on an object residing in another JVM. This capability enables the development of distributed applications where objects on different JVMs can communicate and collaborate.

#### 12.1 Defining and Implementing RMI Service Interface

This section covers how to define and implement an RMI service interface, which is the core of creating an RMI application.

### Steps to Define and Implement RMI Service Interface

#### 1. Define the RMI Service Interface

The RMI service interface is a standard Java interface that extends the `Remote` interface. Each method in this interface must throw a `RemoteException`.

**Example:**

```java
import java.rmi.Remote;
import java.rmi.RemoteException;

// Define the RMI Service Interface
public interface Calculator extends Remote {
    int add(int a, int b) throws RemoteException;
    int subtract(int a, int b) throws RemoteException;
}
```

In this example, the `Calculator` interface defines two remote methods: `add` and `subtract`. Each method throws a `RemoteException` to handle network-related exceptions.

#### 2. Implement the RMI Service Interface

The implementation of the RMI service interface provides the actual code for the remote methods. The implementation class must extend `UnicastRemoteObject` and implement the defined interface.

**Example:**

```java
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

// Implement the RMI Service Interface
public class CalculatorImpl extends UnicastRemoteObject implements Calculator {

    // Constructor
    protected CalculatorImpl() throws RemoteException {
        super();
    }

    // Implement the add method
    @Override
    public int add(int a, int b) throws RemoteException {
        return a + b;
    }

    // Implement the subtract method
    @Override
    public int subtract(int a, int b) throws RemoteException {
        return a - b;
    }
}
```

In this example:
- `CalculatorImpl` extends `UnicastRemoteObject`, which provides functionality for remote object creation.
- The constructor of `CalculatorImpl` calls the superclass constructor to handle remote object creation.
- The `add` and `subtract` methods provide the actual implementation for the remote methods defined in the `Calculator` interface.

#### 3. Create the RMI Server

The RMI server registers the implementation of the remote interface with the RMI registry, making it available to clients.

**Example:**

```java
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

// Create the RMI Server
public class RMIServer {
    public static void main(String[] args) {
        try {
            // Create an instance of the implementation class
            CalculatorImpl calculator = new CalculatorImpl();

            // Start the RMI registry on port 1099
            LocateRegistry.createRegistry(1099);

            // Bind the remote object to a name in the RMI registry
            Naming.rebind("rmi://localhost:1099/CalculatorService", calculator);

            System.out.println("RMI Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

In this example:
- The RMI registry is started on port 1099.
- The `CalculatorImpl` instance is bound to the name "CalculatorService" in the RMI registry using the `Naming.rebind` method.

#### 4. Create the RMI Client

The RMI client looks up the remote object in the RMI registry and invokes methods on it.

**Example:**

```java
import java.rmi.Naming;

// Create the RMI Client
public class RMIClient {
    public static void main(String[] args) {
        try {
            // Look up the remote object in the RMI registry
            Calculator calculator = (Calculator) Naming.lookup("rmi://localhost:1099/CalculatorService");

            // Invoke methods on the remote object
            int sum = calculator.add(5, 3);
            int difference = calculator.subtract(5, 3);

            // Print the results
            System.out.println("Sum: " + sum);
            System.out.println("Difference: " + difference);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

In this example:
- The client looks up the `CalculatorService` in the RMI registry using the `Naming.lookup` method.
- The client invokes the `add` and `subtract` methods on the remote object and prints the results.

### Summary

- **Defining the RMI Service Interface**: Create a Java interface that extends `Remote` and defines the methods to be invoked remotely, throwing `RemoteException`.
- **Implementing the RMI Service Interface**: Create a class that extends `UnicastRemoteObject` and implements the interface, providing the method implementations.
- **Creating the RMI Server**: Register the implementation object with the RMI registry to make it available to clients.
- **Creating the RMI Client**: Look up the remote object in the RMI registry and invoke its methods.

---

### 12.2 Creating an RMI Server and Client

In this section, we'll go through the steps to create an RMI server and client. We'll use the `Calculator` example from the previous section to illustrate the process.

#### 1. Creating the RMI Server

The RMI server will create an instance of the remote object, bind it to a name in the RMI registry, and start the registry to listen for client requests.

**RMI Server Example**:

1. **Define the Remote Interface**:
    ```java
    import java.rmi.Remote;
    import java.rmi.RemoteException;

    public interface Calculator extends Remote {
        int add(int a, int b) throws RemoteException;
        int subtract(int a, int b) throws RemoteException;
    }
    ```

2. **Implement the Remote Interface**:
    ```java
    import java.rmi.RemoteException;
    import java.rmi.server.UnicastRemoteObject;

    public class CalculatorImpl extends UnicastRemoteObject implements Calculator {

        protected CalculatorImpl() throws RemoteException {
            super();
        }

        @Override
        public int add(int a, int b) throws RemoteException {
            return a + b;
        }

        @Override
        public int subtract(int a, int b) throws RemoteException {
            return a - b;
        }
    }
    ```

3. **Create the Server**:
    ```java
    import java.rmi.Naming;
    import java.rmi.registry.LocateRegistry;

    public class RMIServer {
        public static void main(String[] args) {
            try {
                // Create an instance of the implementation class
                CalculatorImpl calculator = new CalculatorImpl();

                // Start the RMI registry on port 1099
                LocateRegistry.createRegistry(1099);

                // Bind the remote object to a name in the RMI registry
                Naming.rebind("rmi://localhost:1099/CalculatorService", calculator);

                System.out.println("RMI Server is running...");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    ```

#### 2. Creating the RMI Client

The RMI client will look up the remote object in the RMI registry and invoke its methods.

**RMI Client Example**:

1. **Create the Client**:
    ```java
    import java.rmi.Naming;

    public class RMIClient {
        public static void main(String[] args) {
            try {
                // Look up the remote object in the RMI registry
                Calculator calculator = (Calculator) Naming.lookup("rmi://localhost:1099/CalculatorService");

                // Invoke methods on the remote object
                int sum = calculator.add(5, 3);
                int difference = calculator.subtract(5, 3);

                // Print the results
                System.out.println("Sum: " + sum);
                System.out.println("Difference: " + difference);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    ```


### Explanation

1. **RMI Server**:
    - **Create an Instance**: The server creates an instance of the remote object (`CalculatorImpl`).
    - **Start the RMI Registry**: The registry is started on port 1099.
    - **Bind the Remote Object**: The remote object is bound to the name `CalculatorService` in the registry using `Naming.rebind()`.

2. **RMI Client**:
    - **Look Up the Remote Object**: The client looks up the `CalculatorService` in the RMI registry using `Naming.lookup()`.
    - **Invoke Remote Methods**: The client invokes the `add` and `subtract` methods on the remote object and prints the results.
---

### 12.3 Running the RMI System

Running an RMI (Remote Method Invocation) system involves several steps, including starting the RMI registry, running the RMI server, and executing the RMI client. Here's a detailed guide on how to properly run and test your RMI system.

### Steps to Run the RMI System

#### 1. **Compile the Java Programs**

Make sure that all your Java source files are compiled. Assuming you have the following files:
- `Calculator.java` (Remote interface)
- `CalculatorImpl.java` (Remote object implementation)
- `RMIServer.java` (RMI server)
- `RMIClient.java` (RMI client)

Compile all of these files using the `javac` command:
```sh
javac Calculator.java CalculatorImpl.java RMIServer.java RMIClient.java
```

#### 2. **Start the RMI Registry**

The RMI registry is a service that allows remote objects to be registered and looked up. It needs to be running before the RMI server can bind objects to it.

You can start the RMI registry from the command line. Open a terminal or command prompt and run:
```sh
rmiregistry
```
By default, `rmiregistry` listens on port 1099, which is the default port used by the RMI system. Ensure this command is run in the directory where your compiled classes are located or set the classpath accordingly.

#### 3. **Run the RMI Server**

After starting the RMI registry, run the RMI server. The server creates an instance of the remote object and binds it to the RMI registry.

Execute the following command to start the RMI server:
```sh
java RMIServer
```
This will start the server, which will register the remote object with the RMI registry.

#### 4. **Run the RMI Client**

With the server running, you can now run the RMI client. The client looks up the remote object in the RMI registry and invokes remote methods on it.

Execute the following command to start the RMI client:
```sh
java RMIClient
```
The client will connect to the RMI registry, look up the `CalculatorService`, and invoke methods on it. It will then print the results of these method invocations.

### Summary of Commands

1. **Compile**:
   ```sh
   javac Calculator.java CalculatorImpl.java RMIServer.java RMIClient.java
   ```

2. **Start the RMI Registry**:
   ```sh
   rmiregistry
   ```

3. **Run the RMI Server**:
   ```sh
   java RMIServer
   ```

4. **Run the RMI Client**:
   ```sh
   java RMIClient
   ```

### Common Issues and Troubleshooting

- **Class Not Found Exception**: Ensure that all classes are compiled and the classpath is set correctly. The `rmiregistry` and the RMI server should be executed in the directory where the compiled classes are located or ensure the classpath includes the directory where the classes are located.

- **RemoteException**: This indicates network or RMI configuration issues. Check that the RMI registry is running and that the server is bound to the correct address and port.

- **Address Already in Use**: If you receive this error, make sure that the port used by the RMI registry or server is not already in use by another process.
