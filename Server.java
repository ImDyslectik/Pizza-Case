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
            System.out.println("Client Connected");

            // takes input from the client terminal and prints it into the server terminal
            in = new DataInputStream(
                    new BufferedInputStream(socket.getInputStream()));

            String line = "";

            while (!line.equals("true")) {
                try {
                    line = in.readUTF();
                    System.out.println(line);

                } catch (IOException i) {
                    System.out.println(i);
                }
            }
            System.out.println("Closing connection");

            // close socket, terminating the connection
            socket.close();
            in.close();
        } catch (IOException i) {
            System.out.println(i);
        }
    }

    public static void main(String args[]) {
        Server server = new Server(5000);
    }
}