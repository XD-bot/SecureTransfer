package sec.socket;

import sec.crypto.RsaClass;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.Key;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.Random;

public class Server {
    String clientAddress;
    Integer clientPort;
    private Integer port;
    ServerSocket serverSocket = null;
    Socket socket = null;
    RsaClass rsaClass = null;
    Map<Integer, Key> keyPair = null;

    private void generatePort(){
        Random random = new Random();
        //端口范围：1024~63334
        Integer port = random.nextInt(64510)+1024;
        this.port = port;
    }
    public void listen(){
        generatePort();
        try {
            serverSocket = new ServerSocket(this.port);
            //开启监听线程
            new Thread(new listenThread(serverSocket)).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成RSA密钥对
     */
    public void generateRsa(){
        rsaClass = new RsaClass();
        try {
            keyPair = rsaClass.generateKeyPair();
            System.out.println(keyPair.get(1));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

    }
    public void send(String filePath){

    }
    public Integer getPort(){
        return this.port;
    }

}


//监听线程
class listenThread implements Runnable{
    private ServerSocket serverSocket ;
    private Socket socket;
    public listenThread(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    @Override
    public void run() {
        try {
            System.out.println("-----开始监听"+serverSocket.getLocalPort()+"端口----");
            socket = serverSocket.accept();
            System.out.println("----与"+socket.getInetAddress()+":"+socket.getPort()+"建立连接----");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//发送文件线程
class sendThread implements Runnable{

    @Override
    public void run() {

    }
}