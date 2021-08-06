package Server;

import Client.Client;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer {

    private static ArrayList<ClientTread> clients;

    public static void acceptClients(ServerSocket serverS, ArrayList<ClientTread> clients){
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

    public static ArrayList<ClientTread> getClients(){
        return clients;
    }
    public static void main(String[] args) {
        ArrayList<ClientTread> clients = new ArrayList<ClientTread>();
        int port = 4444;
        try {
            System.out.println("Sucssesfuly Created Server!!");
            ServerSocket serverSocket = new ServerSocket(port);
            acceptClients(serverSocket, clients);

        } catch (IOException e) {
            System.out.println("Cannot Connect to Port " + port);
            e.printStackTrace();
            System.exit(1);
        }
    }
}
