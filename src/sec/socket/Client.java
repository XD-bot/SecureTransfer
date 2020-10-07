package sec.socket;

import org.omg.CORBA.INTERNAL;
import sec.crypto.RsaClass;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.security.Key;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class Client implements Runnable{

    String serverIp ;
    Integer serverPort ;
    Socket socket;
    Integer flag = 0;

    JTextArea jTextArea;
    public Integer getServerPort(){
        return this.serverPort;
    }
    public String getServerIp(){
        return this.serverIp;
    }

    public void setServerIp(String serverIp){
        this.serverIp = serverIp;
    }
    public void setServerPort(Integer serverPort){
        this.serverPort = serverPort;
    }

    public void setjTextArea(JTextArea jTextArea) {
        this.jTextArea = jTextArea;
    }

    public Integer getFlag() {
        return flag;
    }

    public Socket getSocket(){
        return this.socket;
    }
    @Override
    public void run() {
        try {
            socket = new Socket(serverIp,serverPort);
            this.serverIp = socket.getInetAddress().toString();
            this.serverPort = socket.getPort();

        } catch (IOException e) {
            flag = 1;
            SwingUtilities.invokeLater(new Runnable(){
                public void run()
                {
                    JOptionPane.showMessageDialog(null, "连接错误","错误",JOptionPane.ERROR_MESSAGE);
                }
            });
            Thread.currentThread().interrupt();
            e.printStackTrace();
            return;
        }
    }
}

