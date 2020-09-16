

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class testServerSocket {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println(serverSocket.getInetAddress());
        Socket socket = null;
        byte[] buf = new byte[1024];

        System.out.println("Accept进入之前");
        socket = serverSocket.accept();
        System.out.println("Accept进入，成功与客户端连接");
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        String info = null;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
        while ((info=bufferedReader.readLine())!=null) {
            System.out.println(info);
        }


    }
}
