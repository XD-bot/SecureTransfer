/*
 * Created by JFormDesigner on Mon Sep 14 17:48:05 CST 2020
 */

package sec.frame;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Brainrain
 */
public class ClientFrame extends JFrame {
    public ClientFrame() {
        initComponents();
    }

    private void FileButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void ConnectButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        String serverIp = IPtextField.getText();
        String serverPort = PorttextField.getText();
        Socket socket = null;
        try {
             socket = new Socket(serverIp,Integer.parseInt(serverPort));
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        ServerTextArea = new JTextArea();
        IPlabel = new JLabel();
        IPtextField = new JTextField();
        Portlabel = new JLabel();
        PorttextField = new JTextField();
        ConnectButton = new JButton();
        GenerateButton = new JButton();

        //======== this ========
        setTitle("\u670d\u52a1\u7aef");
        setFont(new Font("\u4eff\u5b8b", Font.PLAIN, 12));
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
			ConnectButtonActionPerformed(e);
		});

            //---- GenerateButton ----
            GenerateButton.setText("\u751f\u6210");
            GenerateButton.setFont(GenerateButton.getFont().deriveFont(GenerateButton.getFont().getSize() + 3f));
            GenerateButton.setBorder(UIManager.getBorder("Button.border"));
            GenerateButton.setContentAreaFilled(false);

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(ServerTextArea, GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(GenerateButton, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
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
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(ServerTextArea, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
                            .addComponent(GenerateButton))
                        .addContainerGap(37, Short.MAX_VALUE))
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
    private JTextArea ServerTextArea;
    private JLabel IPlabel;
    private JTextField IPtextField;
    private JLabel Portlabel;
    private JTextField PorttextField;
    private JButton ConnectButton;
    private JButton GenerateButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
