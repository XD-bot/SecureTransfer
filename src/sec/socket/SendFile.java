package sec.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SendFile implements Runnable {
    private byte[] buf = new byte[2048];
    private Socket socket;
    private InputStream is;
    private OutputStream os;
    SendFile(Socket socket,byte[] buf){
        this.socket = socket;
        this.buf = buf;
    }

    @Override
    public void run() {
        if (socket == null){
            return;
        }
        try {
            os = socket.getOutputStream();
            os.write(buf);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
