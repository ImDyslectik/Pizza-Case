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

            // takes input from terminal, this needs to be changed to input from the GUI
            input = new DataInputStream(System.in);

            // sends output to the socket, this needs to be translated back to a list /
            // array and set into the GUI or terminal
            out = new DataOutputStream(socket.getOutputStream());
        } catch (UnknownHostException u) {
            System.out.println("Unknown host,zet je internet effe aan ofzo");
        } catch (IOException i) {
            System.out.println("There is a failure during reading, writing");
        }
        // ClientGUI CAL = new ClientGUI();
        // CAL.ShowGUI();

        // OrderManager bestel = new OrderManager();
        // bestel.Bestel();
        // LinkedList<String> get = bestel.getOrder();
        // for (String or : get) {
        // System.out.println(or);
        // }

        // string to read message from input
        String line = "";

        // keep reading until "Over" is input
        while (!line.equals("Over")) {
            try {
                line = input.readLine();
                out.writeUTF(line);
            } catch (IOException i) {
                System.out.println(i);
            }
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