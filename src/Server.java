import java.util.LinkedList;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static Server instance;
    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream in = null;
    LinkedList<String> orders = new LinkedList<>();

    public Server(int port) {
        // starts server and waits for a connection with the client
        try {
            server = new ServerSocket(port);
            System.out.println("Server Booting Up Awaiting Connection");

            socket = server.accept();
            System.out.println("Connected Succesfull");

            // takes input from the client terminal and prints it into the server terminal
            InputStream inputStream = socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            try {
                orders = (LinkedList<String>) objectInputStream.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            for (String or : orders) {
                System.out.println(or);
            }
            close();
            System.out.println("Closing connection");
        } catch (IOException i) {
            System.out.println("There is a failure during reading, writing");
        }
    }

    // constructor for the singleton, also put a thread sleep for the boot up
    private Server() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    // creates an instance of a server to initialize once because of the singelton
    public static Server getInstance() {
        if (instance == null) {
            instance = new Server();
        }
        return instance;
    }

    // close socket, terminating the connection
    public void close() {
        try {
            in.close();
            socket.close();
        } catch (IOException i) {
            System.out.println(i);
        }
    }
}