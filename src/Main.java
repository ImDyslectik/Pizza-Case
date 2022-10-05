public class Main {
    /**
     * Server boolean to make sure wheter or not to run the client or server side
     * To run the server and client make sure it is on true first,
     * then whilst running the server change it to false and run the program again
     * current IP is set as localhost
     */
    private static boolean isServer = false;

    public static void main(String args[]) {
        String IP = "127.0.0.1";
        int Port = 5555;

        if (isServer == true) {
            Server socketServer = Server.getInstance(Port);
        } else {
            Client client = new Client(IP, Port);
        }
    }
}
