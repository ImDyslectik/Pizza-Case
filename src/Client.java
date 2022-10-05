import java.net.*;
import java.util.LinkedList;
import java.io.*;

public class Client {
    // initialize socket and input output streams
    private Socket socket = null;
    private static Client instance;

    // constructor to put ip address and port
    // establish a connection

    public Client(String address, int port) {
        try {
<<<<<<< Updated upstream
            while (true) {
                socket = new Socket(address, port);
                System.out.println("Connected");
                OrderManager MyOrder = new OrderManager();
                MyOrder.Bestel();
                LinkedList<String> get = MyOrder.getOrder();
                LinkedList<String> message = encrypter.encryptList(get);
                // takes input from terminal, this needs to be changed to input from the GUI
=======
            socket = new Socket(address, port);
            System.out.println("Connected");
            OrderManager MyOrder = new OrderManager();
            MyOrder.Bestel();
            LinkedList<String> get = MyOrder.getOrder();
            LinkedList<String> message = Encrypter.encrypt(get);
            // takes input from terminal, this needs to be changed to input from the GUI
>>>>>>> Stashed changes

            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(message);
        } catch (UnknownHostException u) {
            System.out.println("Unknown host,zet je internet effe aan ofzo");
        } catch (IOException i) {
            System.out.println("There is a failure during reading, writing");
        } finally {
            try {
                socket.close();
            } catch (IOException i) {
                System.out.println(i);
            }
        }
    }
}