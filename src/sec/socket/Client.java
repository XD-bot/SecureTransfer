package sec.socket;

import java.io.IOException;
import java.net.Socket;

public class Client {

    String serverIp ;
    Integer serverPort ;

    public void connect(String serverIp,Integer serverPort){
        new Thread(new connectThread(serverIp,serverPort)).start();
    }
}

class connectThread implements Runnable{

    String serverIp ;
    Integer serverPort ;
    Socket socket ;
    connectThread(String serverIp,Integer serverPort){
        this.serverIp = serverIp;
        this.serverPort = serverPort;
    }
    @Override
    public void run() {
        try {
            socket = new Socket(serverIp,serverPort);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}