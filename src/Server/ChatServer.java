package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

    public static void acceptClients(ServerSocket serverS){
        while (true){
            try {
                Socket socket = serverS.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        int port = 4444;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            acceptClients(serverSocket);

        } catch (IOException e) {
            System.out.println("Cannot Connect to Port " + port);
            e.printStackTrace();
            System.exit(1);
        }
    }
}
