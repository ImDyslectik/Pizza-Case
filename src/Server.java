import java.net.*;
import java.io.*;

public class Server {
    // initialize socket and input stream
    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream in = null;

    // constructor with a starting port to initialize the server :) :) :)
    public Server(int port) {
        // starts server and waits for a connection with the client
        try {
            server = new ServerSocket(port);
            System.out.println("Server Booting Up");

            socket = server.accept();
            System.out.println("Connected Succesfull");

            // takes input from the client terminal and prints it into the server terminal
            in = new DataInputStream(
                    new BufferedInputStream(socket.getInputStream()));

            // make a kewl Jframe
            ServerGUI CAL = new ServerGUI();
            CAL.ShowGUI();
            String line = "";

            while (!line.equals("exit")) {
                try {
                    line = in.readUTF();
                    System.out.println(line);

                } catch (IOException i) {
                    System.out.println(i);
                }
            }
            close();
            System.out.println("Closing connection");
        } catch (IOException i) {
            System.out.println("There is a failure during reading, writing");
        }
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