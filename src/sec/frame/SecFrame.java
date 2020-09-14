/*
 * Created by JFormDesigner on Mon Sep 14 00:04:16 CST 2020
 */

package sec.frame;

import sec.socket.Server;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;

/**
 * @author Brainrain
 */
public class SecFrame extends JFrame {

    public SecFrame() {
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

    private void ConnectButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        tabbedPane1 = new JTabbedPane();
        ServerPanel = new JPanel();
        Filelabel = new JLabel();
        PathtextField = new JTextField();
        FileButton = new JButton();
        scrollPane2 = new JScrollPane();
        ServerTextArea = new JTextArea();
        SendButton = new JButton();
        ClientPanel = new JPanel();
        IPlabel = new JLabel();
        IPtextField = new JTextField();
        Portlabel = new JLabel();
        PorttextField = new JTextField();
        ConnectButton = new JButton();
        scrollPane1 = new JScrollPane();
        ClientTextArea = new JTextArea();
        GenerateButton = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("\u6587\u4ef6\u4f20\u8f93");
        setFont(new Font("\u5e7c\u5706", Font.PLAIN, 17));
        Container contentPane = getContentPane();

        //======== tabbedPane1 ========
        {
            tabbedPane1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 17));
            tabbedPane1.setFocusable(false);

            //======== ServerPanel ========
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
                FileButton.addActionListener(e -> FileButtonActionPerformed(e));

                //======== scrollPane2 ========
                {
                    scrollPane2.setViewportView(ServerTextArea);
                }

                //---- SendButton ----
                SendButton.setText("\u53d1\u9001");
                SendButton.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 15));
                SendButton.setContentAreaFilled(false);
                SendButton.addActionListener(e -> SendButtonActionPerformed(e));

                GroupLayout ServerPanelLayout = new GroupLayout(ServerPanel);
                ServerPanel.setLayout(ServerPanelLayout);
                ServerPanelLayout.setHorizontalGroup(
                    ServerPanelLayout.createParallelGroup()
                        .addGroup(ServerPanelLayout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addGroup(ServerPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(scrollPane2)
                                .addGroup(ServerPanelLayout.createSequentialGroup()
                                    .addComponent(Filelabel)
                                    .addGap(18, 18, 18)
                                    .addComponent(PathtextField, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE)))
                            .addGap(18, 18, 18)
                            .addGroup(ServerPanelLayout.createParallelGroup()
                                .addComponent(FileButton)
                                .addComponent(SendButton))
                            .addContainerGap(46, Short.MAX_VALUE))
                );
                ServerPanelLayout.setVerticalGroup(
                    ServerPanelLayout.createParallelGroup()
                        .addGroup(ServerPanelLayout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addGroup(ServerPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(Filelabel, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                .addComponent(PathtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(FileButton))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(ServerPanelLayout.createParallelGroup()
                                .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
                                .addComponent(SendButton))
                            .addContainerGap(153, Short.MAX_VALUE))
                );
            }
            tabbedPane1.addTab(" \u670d\u52a1\u7aef", ServerPanel);

            //======== ClientPanel ========
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
                ConnectButton.addActionListener(e -> ConnectButtonActionPerformed(e));

                //======== scrollPane1 ========
                {
                    scrollPane1.setViewportView(ClientTextArea);
                }

                //---- GenerateButton ----
                GenerateButton.setText("\u751f\u6210");
                GenerateButton.setFont(GenerateButton.getFont().deriveFont(GenerateButton.getFont().getSize() + 3f));
                GenerateButton.setBorder(UIManager.getBorder("Button.border"));
                GenerateButton.setContentAreaFilled(false);

                GroupLayout ClientPanelLayout = new GroupLayout(ClientPanel);
                ClientPanel.setLayout(ClientPanelLayout);
                ClientPanelLayout.setHorizontalGroup(
                    ClientPanelLayout.createParallelGroup()
                        .addGroup(ClientPanelLayout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addGroup(ClientPanelLayout.createParallelGroup()
                                .addGroup(ClientPanelLayout.createSequentialGroup()
                                    .addComponent(IPlabel)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(IPtextField, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                                    .addGap(18, 18, 18)
                                    .addComponent(Portlabel)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(PorttextField, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                                    .addGap(39, 39, 39)
                                    .addComponent(ConnectButton))
                                .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(GenerateButton)
                            .addGap(43, 43, 43))
                );
                ClientPanelLayout.setVerticalGroup(
                    ClientPanelLayout.createParallelGroup()
                        .addGroup(ClientPanelLayout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addGroup(ClientPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(IPlabel, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                .addComponent(IPtextField)
                                .addComponent(Portlabel)
                                .addComponent(PorttextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(ConnectButton)
                                .addComponent(GenerateButton))
                            .addGap(18, 18, 18)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(169, Short.MAX_VALUE))
                );
            }
            tabbedPane1.addTab("\u5ba2\u6237\u7aef", ClientPanel);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tabbedPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(tabbedPane1, GroupLayout.Alignment.TRAILING)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JTabbedPane tabbedPane1;
    private JPanel ServerPanel;
    private JLabel Filelabel;
    private JTextField PathtextField;
    private JButton FileButton;
    private JScrollPane scrollPane2;
    private JTextArea ServerTextArea;
    private JButton SendButton;
    private JPanel ClientPanel;
    private JLabel IPlabel;
    private JTextField IPtextField;
    private JLabel Portlabel;
    private JTextField PorttextField;
    private JButton ConnectButton;
    private JScrollPane scrollPane1;
    private JTextArea ClientTextArea;
    private JButton GenerateButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public static void main(String[] args) {
        new SecFrame().setVisible(true);
    }
}
