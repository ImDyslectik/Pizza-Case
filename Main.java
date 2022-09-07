
public class Main {
    // Server boolean to make sure wheter or not to run the client or server side
    private static boolean isServer = false;

    public static void main(String args[]) {

        if (isServer == true) {
            Server.main(args);
            // make instance of a server window or GUI and do the same for client

        } else {
            Client.main(args);
        }
    }
}
