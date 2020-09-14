package sec.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable{

    Integer port ;
    String ipAddress;
    String filePath;
    ServerSocket ss;
    Socket socket;

    public Server(){

    }
    public Server(Integer port, String ipAddress, String filePath, ServerSocket ss, Socket socket) {
        this.port = port;
        this.ipAddress = ipAddress;
        this.filePath = filePath;
        this.ss = ss;
        this.socket = socket;
    }
    public void startServer(){

        try {
            this.setPort(8888);
            if(port > 1023 && port < 63336 ){
                ss = new ServerSocket(port);
                System.out.println("启动服务器。。。");
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public ServerSocket getSs() {
        return ss;
    }

    public void setSs(ServerSocket ss) {
        this.ss = ss;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
            startServer();
    }
}
