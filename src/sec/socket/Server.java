package sec.socket;

import sec.crypto.RsaClass;

import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.Key;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.Random;

public class Server implements Runnable{
    String clientAddress;
    Integer clientPort;
    private Integer port;
    ServerSocket serverSocket = null;
    Socket socket = null;
    RsaClass rsaClass = null;
    Map<Integer, Key> keyPair = null;
    JTextArea textArea = null;

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
    public void setPort(Integer port){
        this.port = port;
    }
    public Integer getClientPort(){
        return this.clientPort;
    }
    public String getClientAddress(){
        return this.clientAddress;
    }
    public void closeSocket() throws IOException {
        if (this.socket != null){
            socket.close();
        }
        if (this.serverSocket != null){
            serverSocket.close();
        }
    }
    public Socket getSocket(){
        return this.socket;
    }
    public void setTextArea(JTextArea textArea){
        this.textArea = textArea;
    }
    public void displayInformation(JTextArea textArea){
        textArea.append("----与"+this.getSocket().getInetAddress()+":"+this.getSocket().getPort()+"建立连接----\n");
    }
    @Override
    public void run() {
        try {
            this.serverSocket = new ServerSocket(this.port);
            System.out.println("---服务端：开始监听端口"+port);
            this.socket = serverSocket.accept();
            this.clientAddress = socket.getInetAddress().toString();
            this.clientPort = socket.getPort();
            System.out.println("---与"+this.clientAddress+":"+this.clientPort+"建立连接---\n");
            displayInformation(this.textArea);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



