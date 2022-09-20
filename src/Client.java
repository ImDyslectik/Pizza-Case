import java.net.*;
import java.util.LinkedList;
import java.io.*;

public class Client {
    // initialize socket and input output streams
    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream out = null;

    // constructor to put ip address and port
    public Client(String address, int port) {
        // establish a connection

        try {
            socket = new Socket(address, port);
            System.out.println("Connected");
            OrderManager MyOrder = new OrderManager();
            MyOrder.Bestel();
            LinkedList<String> get = MyOrder.getOrder();
            // takes input from terminal, this needs to be changed to input from the GUI
            
            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            
            objectOutputStream.writeObject(get);
        } catch (UnknownHostException u) {
            System.out.println("Unknown host,zet je internet effe aan ofzo");
        } catch (IOException i) {
            System.out.println("There is a failure during reading, writing");
        }

        close();
    }

    // close the connection
    public void close() {
        try {
            input.close();
            out.close();
            socket.close();
        } catch (IOException i) {
            System.out.println(i);
        }
    }
}