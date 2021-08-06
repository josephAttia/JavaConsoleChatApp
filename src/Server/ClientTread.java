package Server;

import java.net.Socket;

public class ClientTread extends ChatServer implements Runnable{

    private Socket socket;

    public ClientTread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run(){

    }
}
