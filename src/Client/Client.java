package Client;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Socket socket = null;
        System.out.print("Enter Username: ");
        Scanner sc = new Scanner(System.in);
        String username = sc.next();
        sc.close();
        int port = 4444;

        try {
            socket = new Socket("localhost", port);
            Thread.sleep(1000);
            Thread server = new Thread(new ServerTread(socket, username));
            server.start();

        } catch (IOException e) {
            System.err.println("Fatal Connection Error");
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
