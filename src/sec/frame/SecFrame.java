/*
 * Created by JFormDesigner on Mon Sep 14 00:04:16 CST 2020
 */

package sec.frame;

import java.awt.*;
import javax.swing.*;

/**
 * @author Brainrain
 */
public class SecFrame extends JFrame {
    public SecFrame() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        tabbedPane1 = new JTabbedPane();
        ServerPanel = new JPanel();
        ClientPanel = new JPanel();
        IPlabel = new JLabel();
        IPtextField = new JTextField();
        Portlabel = new JLabel();
        PorttextField = new JTextField();

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

                GroupLayout ServerPanelLayout = new GroupLayout(ServerPanel);
                ServerPanel.setLayout(ServerPanelLayout);
                ServerPanelLayout.setHorizontalGroup(
                    ServerPanelLayout.createParallelGroup()
                        .addGap(0, 539, Short.MAX_VALUE)
                );
                ServerPanelLayout.setVerticalGroup(
                    ServerPanelLayout.createParallelGroup()
                        .addGap(0, 411, Short.MAX_VALUE)
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

                GroupLayout ClientPanelLayout = new GroupLayout(ClientPanel);
                ClientPanel.setLayout(ClientPanelLayout);
                ClientPanelLayout.setHorizontalGroup(
                    ClientPanelLayout.createParallelGroup()
                        .addGroup(ClientPanelLayout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addComponent(IPlabel)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(IPtextField, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                            .addGap(18, 18, 18)
                            .addComponent(Portlabel)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(PorttextField, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                            .addGap(212, 212, 212))
                );
                ClientPanelLayout.setVerticalGroup(
                    ClientPanelLayout.createParallelGroup()
                        .addGroup(ClientPanelLayout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addGroup(ClientPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(IPlabel, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                .addComponent(IPtextField)
                                .addComponent(Portlabel)
                                .addComponent(PorttextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(352, Short.MAX_VALUE))
                );
            }
            tabbedPane1.addTab("\u5ba2\u6237\u7aef", ClientPanel);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(15, Short.MAX_VALUE)
                    .addComponent(tabbedPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(14, Short.MAX_VALUE))
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
    private JPanel ClientPanel;
    private JLabel IPlabel;
    private JTextField IPtextField;
    private JLabel Portlabel;
    private JTextField PorttextField;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public static void main(String[] args) {
        new SecFrame().setVisible(true);
    }
}
