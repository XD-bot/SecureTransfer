import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class testClientSocket {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("127.0.0.1", 39373);
        InputStream is = null;
        OutputStream os = null;
        is = socket.getInputStream();
        os = socket.getOutputStream();
        os.write("我是来自客户端的数据".getBytes());
        os.flush();
        os.close();
        is.close();
        socket.close();
    }
}
