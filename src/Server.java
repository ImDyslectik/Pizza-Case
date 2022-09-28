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
    LinkedList<String> message = new LinkedList<>();

    // constructor for the singleton
    // starts server and waits for a connection with the client
    public Server(int port) {
        try {

            while (true) {
                server = new ServerSocket(port);
                System.out.println("Server Booting Up Awaiting Connection");

                socket = server.accept();
                System.out.println("Connected Succesfull");

                // takes input from the client terminal and prints it into the server terminal
                InputStream inputStream = socket.getInputStream();
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                try {
                    message = (LinkedList<String>) objectInputStream.readObject();
                    
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                for (String enc : message) {
                    System.out.println(enc);
                }
                try {
                    orders = encrypter.decrypt(message);
                } catch (Exception e) {
                    System.out.println("There was a failure during decrypting");
                }
               
                for (String or : orders) {
                    System.out.println(or);
                }
            }
        } catch (IOException i) {
            System.out.println("There is a failure during reading, writing");
        } finally {
            try {
                in.close();
                socket.close();
            } catch (IOException i) {
                System.out.println(i);
            }
        }
    }

    // creates an instance of a server to initialize once because of the singelton
    public static Server getInstance(int port) {
        if (instance == null) {
            instance = new Server(port);
        }
        return instance;
    }

    // close socket, terminating the connection
    public void close() {

    }
}