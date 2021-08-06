package Server;

import Client.Client;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer {

    public static void acceptClients(ServerSocket serverS){
        ArrayList<ClientTread> clients = new ArrayList<ClientTread>();
        while (true){
            try {
                Socket socket = serverS.accept();
                ClientTread client = new ClientTread(socket);
                Thread thread = new Thread(client);
                thread.start();
                clients.add(client);
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
