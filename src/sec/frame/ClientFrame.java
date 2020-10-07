/*
 * Created by JFormDesigner on Mon Sep 14 17:48:05 CST 2020
 */

package sec.frame;

import sec.crypto.DesClass;
import sec.crypto.MD5Class;
import sec.crypto.RsaClass;
import sec.socket.Client;
import sec.socket.GenerateKey;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Brainrain
 */
public class ClientFrame extends JFrame {
    public ClientFrame() {
        initComponents();
    }

    public static void main(String[] args) {
        new ClientFrame().setVisible(true);
    }

    private void ConnectButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        String serverIp = IPtextField.getText();
        String serverPort = PorttextField.getText();

        clientSocket = new Client();
        clientSocket.setServerIp(serverIp);
        clientSocket.setServerPort(Integer.parseInt(serverPort));
        clientSocket.setjTextArea(ClientTextArea);
        thread = new Thread(clientSocket);
        thread.start();
        Integer flag ;
        try {
            thread.join();
            flag = clientSocket.getFlag();
            if (0 == flag) {
                System.out.println("----服务器" + clientSocket.getServerIp() + "建立连接----");
                this.ClientTextArea.append("----服务器" + clientSocket.getServerIp() + ":" + clientSocket.getServerPort() + "建立连接----\n");
                this.socket = clientSocket.getSocket();
                try {
                    inputStream = socket.getInputStream();
                    outputStream = socket.getOutputStream();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            } catch(InterruptedException ex){
                ex.printStackTrace();
            }



    }

    private void GenerateButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        generateKey = new GenerateKey();

        generateKey.setjTextArea(this.ClientTextArea);
        Thread thread1 = new Thread(generateKey);
        thread1.start();

        try {
            thread1.join();
            Map keyPair = generateKey.getKeyPair();

            clientPubKeyStr = generateKey.getPublicKey();
            clientPriKeyStr = generateKey.getPrivateKey();
            outputStream.write(clientPubKeyStr.getBytes());
            socket.shutdownOutput();

            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String serverPubKeyString = null;
            String readBufferStr = null;
            StringBuffer tmp = new StringBuffer();

            Thread.sleep(5000);


            serverPubKeyString = br.readLine().replace("\\","");

            int firstByte = inputStream.read();
            int length = inputStream.available();
            byte[] b = new byte[length+1];
            b[0] = (byte)firstByte;
            inputStream.read(b,1,length);
            System.out.println("---------------------------------");
//            System.out.println(tmp.toString());
            //DES密钥
            //0 - 215
            //216 -
            System.out.println(length);
            for (byte b1 : b) {
                System.out.print(b1+" ");
            }
            System.out.println();
            desStrBytes = new byte[128];
            System.arraycopy(b,0,desStrBytes,0,128);
            for (byte b1 : b) {
                System.out.print(b1+" ");
            }
            byte []signBytes = new byte[128];
            System.arraycopy(b,128,signBytes,0,128);

            System.out.println("des长度"+desStrBytes.length);
            System.out.println("公钥长度"+serverPubKeyString.getBytes().length);


            try {
                serverPubKey = rsaClass.getPublicKey(serverPubKeyString);
            } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
                ex.printStackTrace();
            }
            System.out.println("服务器RSA公钥："+serverPubKeyString);
            RSAPrivateKey privateKey = rsaClass.getPrivateKey(clientPriKeyStr);
            System.out.println("DES bytes"+Arrays.toString(desStrBytes));
            System.out.println("DES密钥："+ Arrays.toString(rsaClass.decrypt(desStrBytes, privateKey)));
            System.out.println("签名长度："+signBytes.length);

            for (byte signByte : signBytes) {
                System.out.print(signByte+" ");
            }
            ClientTextArea.append("----服务器RSA公钥----\n");
            ClientTextArea.append(serverPubKeyString+"\n");
            ClientTextArea.append("----已接收文件----\n");

        


        } catch (InterruptedException | IOException | NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        } catch (InvalidKeySpecException ex) {
            ex.printStackTrace();
        } catch (NoSuchPaddingException ex) {
            ex.printStackTrace();
        } catch (InvalidKeyException ex) {
            ex.printStackTrace();
        } catch (IllegalBlockSizeException ex) {
            ex.printStackTrace();
        } catch (BadPaddingException ex) {
            ex.printStackTrace();
        }

    }

    private void ModifyButtonActionPerformed(ActionEvent e) {
        // TODO add your code here


        try {
            //RSA公钥解密签名
            byte[] deServerSign = rsaClass.decrypt(desStrBytes, serverPubKey);

            //RSA私钥解密DES密钥
            RSAPrivateKey clientPriKey = rsaClass.getPrivateKey(clientPriKeyStr);
            byte[] deDesKey = rsaClass.decrypt(enDesKey.getBytes(), clientPriKey);

            //生成MD5摘要
            String fileStr = DesClass.decrypt(fileString, Arrays.toString(deDesKey));
            String md5FileSign = MD5Class.getMD5(fileStr);

            if (md5FileSign.equals(deServerSign.toString())){
                System.out.println("发送的文件摘要和生成的一致");
            }
            else {
                System.out.println("错误");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        IPlabel = new JLabel();
        IPtextField = new JTextField();
        Portlabel = new JLabel();
        PorttextField = new JTextField();
        ConnectButton = new JButton();
        GenerateButton = new JButton();
        scrollPane1 = new JScrollPane();
        ClientTextArea = new JTextArea();
        ModifyButton = new JButton();
        rsaClass = new RsaClass();
        //======== this ========
        setTitle("\u5ba2\u6237\u7aef");
        setFont(new Font("\u4eff\u5b8b", Font.PLAIN, 12));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();

        //======== panel1 ========
        {

            //---- IPlabel ----
            IPlabel.setText("IP\u5730\u5740\uff1a");
            IPlabel.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, IPlabel.getFont().getSize() + 3));

            //---- IPtextField ----
            IPtextField.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));

            //---- Portlabel ----
            Portlabel.setText("\u7aef\u53e3\uff1a");
            Portlabel.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, Portlabel.getFont().getSize() + 3));

            //---- PorttextField ----
            PorttextField.setFont(new Font("\u5e7c\u5706", Font.PLAIN, 15));

            //---- ConnectButton ----
            ConnectButton.setText("\u8fde\u63a5");
            ConnectButton.setFont(ConnectButton.getFont().deriveFont(ConnectButton.getFont().getSize() + 3f));
            ConnectButton.setBorder(UIManager.getBorder("Button.border"));
            ConnectButton.setContentAreaFilled(false);
            ConnectButton.addActionListener(e -> {
			ConnectButtonActionPerformed(e);
		});

            //---- GenerateButton ----
            GenerateButton.setText("\u751f\u6210");
            GenerateButton.setFont(GenerateButton.getFont().deriveFont(GenerateButton.getFont().getSize() + 3f));
            GenerateButton.setBorder(UIManager.getBorder("Button.border"));
            GenerateButton.setContentAreaFilled(false);
            GenerateButton.addActionListener(e -> GenerateButtonActionPerformed(e));

            //======== scrollPane1 ========
            {

                //---- ClientTextArea ----
                ClientTextArea.setLineWrap(true);
                ClientTextArea.setWrapStyleWord(true);
                scrollPane1.setViewportView(ClientTextArea);
            }

            //---- ModifyButton ----
            ModifyButton.setText("\u9a8c\u8bc1");
            ModifyButton.setFont(ModifyButton.getFont().deriveFont(ModifyButton.getFont().getSize() + 3f));
            ModifyButton.setBorder(UIManager.getBorder("Button.border"));
            ModifyButton.setContentAreaFilled(false);
            ModifyButton.addActionListener(e -> {
			ModifyButtonActionPerformed(e);
		});

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 386, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(GenerateButton, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ModifyButton, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(IPlabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IPtextField, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Portlabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PorttextField, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                                .addComponent(ConnectButton, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)))
                        .addGap(28, 28, 28))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(IPlabel, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                            .addComponent(IPtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(Portlabel, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                            .addComponent(PorttextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(ConnectButton))
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(GenerateButton)
                                .addGap(18, 18, 18)
                                .addComponent(ModifyButton))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(48, Short.MAX_VALUE))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JLabel IPlabel;
    private JTextField IPtextField;
    private JLabel Portlabel;
    private JTextField PorttextField;
    private JButton ConnectButton;
    private JButton GenerateButton;
    private JScrollPane scrollPane1;
    private JTextArea ClientTextArea;
    private JButton ModifyButton;
    private Client clientSocket;
    private Thread thread;
    private Socket socket;
    private GenerateKey generateKey;
    private InputStream inputStream;
    private OutputStream outputStream;
    private String clientPubKeyStr;
    private String clientPriKeyStr;
    private String enDesKey;
    private PublicKey serverPubKey;
    private byte []desStrBytes;
    private String fileMessage;
    private File file;
    private String fileString;
    private RsaClass rsaClass;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
