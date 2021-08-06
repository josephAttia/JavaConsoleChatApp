package Client;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        Socket socket = null;
        int port = 4444;

        try {
            socket = new Socket("localhost", port);
        } catch (IOException e) {
            System.err.println("Fatal Connection Error");
            e.printStackTrace();
        }
    }
}
