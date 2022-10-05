import java.util.LinkedList;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static Server instance;
    private Socket socket = null;
    private ServerSocket server = null;
    LinkedList<String> orders = new LinkedList<>();
    LinkedList<String> rawinput = new LinkedList<>();

    /**
     * Constructor for the singleton
     * Starts server and waits for a connection with the client
     * 
     * @param port is passed on from Main.java containing the port where the Server,
     *             And the Client will be run on
     *             InputStream gets the input from the Client
     */
    public Server(int port) {
        try {
            server = new ServerSocket(port);
            System.out.println("Server Booting Up Awaiting Connection");

            while (true) {
                try {
                    socket = server.accept();
                    System.out.println("Connected Succesfull");

<<<<<<< Updated upstream
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                try {
                    orders = encrypter.decryptList(rawinput);
                } catch (Exception e) {
                    System.out.println("There was a failure during decrypting");
                }
                for (String raw : rawinput) {
                    System.out.println(raw);
                }
                for (String or : orders) {
                    System.out.println(or);
=======
                    // takes input from the client terminal and prints it into the server terminal
                    InputStream inputStream = socket.getInputStream();
                    ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                    try {
                        rawinput = (LinkedList<String>) objectInputStream.readObject();

                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    try {
                        orders = Encrypter.decrypt(rawinput);
                    } catch (Exception e) {
                        System.out.println("There was a failure during decrypting");
                    }
                    for (String or : orders) {
                        System.out.println(or);
                    }
                } catch (IOException i) {
                    System.out.println("There is a failure during reading, writing");
>>>>>>> Stashed changes
                }
            }
        } catch (IOException i) {
            System.out.println("There is a failure during reading, writing");
        }
    }

    // creates an instance of a server to initialize once because of the singelton
    public static Server getInstance(int port) {
        if (instance == null) {
            instance = new Server(port);
        }
        return instance;
    }
}