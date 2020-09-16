/*
 * Created by JFormDesigner on Mon Sep 14 17:26:19 CST 2020
 */

package sec.frame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Brainrain
 */
public class StartFrame extends JFrame {
    public StartFrame() {
        initComponents();
    }

    private void ServerButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        new ServerFrame().setVisible(true);

        //this.dispose();
    }

    private void ClientButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        new ClientFrame().setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ServerButton = new JButton();
        label1 = new JLabel();
        ClientButton = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("开始");
        //---- ServerButton ----
        ServerButton.setText("\u670d\u52a1\u7aef\uff08\u53d1\u9001\u6587\u4ef6\uff09");
        ServerButton.setContentAreaFilled(false);
        ServerButton.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", ServerButton.getFont().getStyle(), ServerButton.getFont().getSize()));
        ServerButton.addActionListener(e -> ServerButtonActionPerformed(e));

        //---- label1 ----
        label1.setText("\u8bf7\u9009\u62e9");
        label1.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", label1.getFont().getStyle(), label1.getFont().getSize() + 2));
        label1.setHorizontalAlignment(SwingConstants.CENTER);

        //---- ClientButton ----
        ClientButton.setText("\u5ba2\u6237\u7aef\uff08\u63a5\u6536\u6587\u4ef6\uff09");
        ClientButton.setContentAreaFilled(false);
        ClientButton.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", ClientButton.getFont().getStyle(), ClientButton.getFont().getSize()));
        ClientButton.addActionListener(e -> ClientButtonActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(134, 134, 134)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(label1, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(ServerButton, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(ClientButton, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))))
                    .addContainerGap(117, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(47, 47, 47)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(ServerButton)
                    .addGap(18, 18, 18)
                    .addComponent(ClientButton)
                    .addContainerGap(99, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JButton ServerButton;
    private JLabel label1;
    private JButton ClientButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        new StartFrame().setVisible(true);
    }
}
