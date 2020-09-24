package sec.socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SendFile implements Runnable {
    private String filePath;
    private Socket socket;
    private InputStream is;
    private OutputStream os;
    private Integer flag;   //flag = 1: 发送文件; flag=0:发送公钥
    SendFile(Socket socket,Integer flag){
        this.socket = socket;
        this.flag = flag;
    }
    @Override
    public void run() {

    }
}
