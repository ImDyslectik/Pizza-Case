import java.net.*;
import java.util.LinkedList;
import java.io.*;

public class Client {
    /**
     * starts client
     * 
     * @param port    is passed on from Main.java containing the port where the
     *                Client will be run on
     * @param address is passed on from Main.java containing the ip adress of the
     *                Client
     *                initialize socket and input output streams
     */
    private Socket socket = null;

    public Client(String address, int port) {
        try {
            socket = new Socket(address, port);
            System.out.println("Connected");
            OrderManager MyOrder = new OrderManager();
            MyOrder.Bestel();
            LinkedList<String> get = MyOrder.getOrder();
            LinkedList<String> message = encrypter.encryptList(get);

            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(message);

        } catch (UnknownHostException u) {
            System.out.println("Unknown host,heeft u wel internet?");
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