public class Main {
    // Server boolean to make sure wheter or not to run the client or server side
    // To run the server and client make sure it is on true first,
    // then whilst running the server change it to false and run the program again
    // for the client side
    private static boolean isServer = false;

    public static void main(String args[]) {
        // localhost ip adress
        String IP = "127.0.0.1";
        int Port = 5555;

        if (isServer == true) {
            Server server = new Server(Port);

            // make instance of a server window or GUI and do the same for client
            // why doesn't this work atm ??

        } else {

            Client client = new Client(IP, Port);
        }
    }
}
