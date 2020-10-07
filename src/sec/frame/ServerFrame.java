/*
 * Created by JFormDesigner on Mon Sep 14 17:39:40 CST 2020
 */

package sec.frame;

import sec.crypto.DesClass;
import sec.crypto.MD5Class;
import sec.crypto.RsaClass;
import sec.socket.GenerateKey;
import sec.socket.Server;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.Map;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Brainrain
 */
public class ServerFrame extends JFrame {
    public static void main(String[] args) {
        new ServerFrame().setVisible(true);
    }
    public ServerFrame() {
        initComponents();
    }

    private void FileButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        JFileChooser jfc = new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int returnVal = jfc.showOpenDialog(this);
        if (returnVal == 0){
            file = jfc.getSelectedFile();
            if(file.isDirectory()){
                System.out.println("文件夹："+file.getAbsolutePath());
            }else if(file.isFile()){
                System.out.println("文件:"+file.getAbsolutePath());
            }
            this.PathtextField.setText(file.getAbsolutePath());
        }
        else if (returnVal == 1) {
            jfc.cancelSelection();
        }
    }

    private void SendButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        try {
            thread.join();
            socket = serverSocket.getSocket();
            System.out.println(socket.getInetAddress()+":"+socket.getPort());
            GenerateKey generateKey = new GenerateKey();
            try {
                inputStream = socket.getInputStream();
                BufferedReader br=new BufferedReader(new InputStreamReader(inputStream));
                String clientPubKeyString = null;
                while (!((clientPubKeyString=br.readLine())==null)) {

                    ServerTextArea.append("客户端的RSA公钥："+clientPubKeyString+"\n");
                    //获取客户端的公钥
                    clientPubKey = rsaClass.getPublicKey(clientPubKeyString);

                }
                //生成RSA密钥对
                generateKey.setjTextArea(this.ServerTextArea);
                Thread thread = new Thread(generateKey);
                thread.start();
                thread.join();
                String serverPriKeyString = generateKey.getPrivateKey();
                String serverPubKeyString = generateKey.getPublicKey();
                serverPubKey = rsaClass.getPublicKey(serverPubKeyString);
                serverPriKey = rsaClass.getPrivateKey(serverPriKeyString);

                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));


                bufferedWriter.write(serverPubKeyString);
                bufferedWriter.newLine();
                bufferedWriter.flush();

                //默认DES密钥为"test1234"
                this.ServerTextArea.append("----默认DES密钥为:test1234----\n");
                //用客户端的RSA公钥加密DES密钥,将加密后的Des密钥发送到客户端
                byte[] enDesKey = rsaClass.encrypt(DesKey.getBytes(), clientPubKey);
                socket.getOutputStream().write(enDesKey);
                socket.getOutputStream().flush();
                System.out.println("DES：");
                for (byte b : enDesKey) {
                    System.out.print(b+" ");
                }
                System.out.println();
                //MD5生成摘要
                String fileMessage = MD5Class.getMD5(file);
                System.out.println("摘要："+fileMessage.getBytes());
                //用服务端的RSA私钥加密摘要，生成签名
                byte[] sign = rsaClass.encrypt(fileMessage.getBytes(), serverPubKey);
                System.out.println("签名长度"+sign.length);
                System.out.println("签名：");
                for (byte b : sign) {
                    System.out.print(b+" ");
                }

                socket.getOutputStream().write(sign);
                socket.getOutputStream().flush();
                System.out.println("RSA公钥长度"+serverPubKeyString.length());
                System.out.println("签名长度"+128);

                //发送文件
               FileInputStream fileInputStream = new FileInputStream(file.getPath());
               byte[] buffer = new byte[1024];
               int len = 0;
               while ((len = fileInputStream.read(buffer)) != -1) {
                    socket.getOutputStream().write(buffer,0,len);
               }

               fileInputStream.close();


                bufferedWriter.flush();
                socket.shutdownOutput();

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }



    }

    private void DisconntButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        try {
            serverSocket.closeSocket();
            ServerTextArea.append("连接已关闭\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void StartButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        Integer port = Integer.parseInt(PorttextField.getText());
        if (port < 1024 || port > 65535){
            JOptionPane.showMessageDialog(this,"端口范围:1024 ~ 65535","错误",JOptionPane.ERROR_MESSAGE);
        }
        else {
            serverSocket.setPort(port);
            serverSocket.setTextArea(this.ServerTextArea);
            thread = new Thread(serverSocket);
            ServerTextArea.append("----开始监听端口" + serverSocket.getPort() + "----\n");
            thread.start();


        }
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        Filelabel = new JLabel();
        PathtextField = new JTextField();
        FileButton = new JButton();
        SendButton = new JButton();
        DisconntButton = new JButton();
        StartButton = new JButton();
        Filelabel2 = new JLabel();
        PorttextField = new JTextField();
        scrollPane1 = new JScrollPane();
        ServerTextArea = new JTextArea();
        serverSocket = new Server();
        thread = null;
        socket = null;
        rsaClass = new RsaClass();
        desClass = new DesClass();
        clientPubKey = null;
        file = null;
        keyPair = null;
        serverPriKey = null;
        serverPubKey = null;
        DesKey = "test1234";
        //======== this ========
        setTitle("\u670d\u52a1\u7aef");
        setFont(new Font("\u4eff\u5b8b", Font.PLAIN, 12));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();

        //======== panel1 ========
        {

            //---- Filelabel ----
            Filelabel.setText("\u6587\u4ef6\u8def\u5f84\uff1a");
            Filelabel.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, Filelabel.getFont().getSize() + 3));

            //---- PathtextField ----
            PathtextField.setFont(PathtextField.getFont().deriveFont(PathtextField.getFont().getSize() + 3f));

            //---- FileButton ----
            FileButton.setText("\u6d4f\u89c8");
            FileButton.setContentAreaFilled(false);
            FileButton.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, FileButton.getFont().getSize() + 3));
            FileButton.addActionListener(e -> {
			FileButtonActionPerformed(e);

		});

            //---- SendButton ----
            SendButton.setText("\u53d1\u9001");
            SendButton.setContentAreaFilled(false);
            SendButton.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, SendButton.getFont().getSize() + 3));
            SendButton.addActionListener(e -> {
			SendButtonActionPerformed(e);
		});

            //---- DisconntButton ----
            DisconntButton.setText("\u65ad\u5f00\u8fde\u63a5");
            DisconntButton.setContentAreaFilled(false);
            DisconntButton.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, DisconntButton.getFont().getSize() + 3));
            DisconntButton.addActionListener(e -> {

			DisconntButtonActionPerformed(e);
		});

            //---- StartButton ----
            StartButton.setText("\u5f00\u542f");
            StartButton.setContentAreaFilled(false);
            StartButton.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, StartButton.getFont().getSize() + 3));
            StartButton.addActionListener(e -> {

			StartButtonActionPerformed(e);
		});

            //---- Filelabel2 ----
            Filelabel2.setText("\u7aef\u53e3\uff1a");
            Filelabel2.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, Filelabel2.getFont().getSize() + 3));

            //---- PorttextField ----
            PorttextField.setFont(PorttextField.getFont().deriveFont(PorttextField.getFont().getSize() + 3f));

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(ServerTextArea);
            }

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                        .addComponent(Filelabel)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                        .addComponent(Filelabel2)
                                        .addGap(35, 35, 35)))
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(PorttextField, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(PathtextField, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE)))
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 406, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(FileButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(StartButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SendButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DisconntButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(18, Short.MAX_VALUE))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(Filelabel, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                            .addComponent(PathtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(FileButton))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(StartButton)
                            .addComponent(Filelabel2, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                            .addComponent(PorttextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(SendButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(DisconntButton))
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(37, Short.MAX_VALUE))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(15, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JLabel Filelabel;
    private JTextField PathtextField;
    private JButton FileButton;
    private JButton SendButton;
    private JButton DisconntButton;
    private JButton StartButton;
    private JLabel Filelabel2;
    private JTextField PorttextField;
    private JScrollPane scrollPane1;
    private JTextArea ServerTextArea;
    private Server serverSocket;
    private Thread thread;
    private Socket socket;
    private InputStream inputStream;
    private OutputStream outputStream;
    private RsaClass rsaClass;
    private PublicKey clientPubKey;
    private File file;
    private Map<Integer,String> keyPair;
    private PublicKey serverPubKey;
    private PrivateKey serverPriKey;
    private String DesKey;
    private DesClass desClass;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
