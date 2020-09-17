/*
 * Created by JFormDesigner on Mon Sep 14 17:39:40 CST 2020
 */

package sec.frame;

import sec.socket.Server;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
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
            File file = jfc.getSelectedFile();
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
    }

    private void DisconntButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void StartButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        server.listen();
        ServerTextArea.append("----开始监听端口"+server.getPort()+"----\n");
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        Filelabel = new JLabel();
        PathtextField = new JTextField();
        FileButton = new JButton();
        ServerTextArea = new JTextArea();
        SendButton = new JButton();
        DisconntButton = new JButton();
        StartButton = new JButton();
        server = new Server();
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

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(Filelabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PathtextField, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE))
                            .addComponent(ServerTextArea))
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(FileButton, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
                            .addComponent(StartButton, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
                            .addComponent(SendButton, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
                            .addComponent(DisconntButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(24, Short.MAX_VALUE))
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
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(StartButton)
                                .addGap(18, 18, 18)
                                .addComponent(SendButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(DisconntButton))
                            .addComponent(ServerTextArea, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(74, Short.MAX_VALUE))
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
    private JLabel Filelabel;
    private JTextField PathtextField;
    private JButton FileButton;
    private JTextArea ServerTextArea;
    private JButton SendButton;
    private JButton DisconntButton;
    private JButton StartButton;
    private Server server;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
