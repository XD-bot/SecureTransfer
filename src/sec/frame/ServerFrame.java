/*
 * Created by JFormDesigner on Mon Sep 14 17:39:40 CST 2020
 */

package sec.frame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Brainrain
 */
public class ServerFrame extends JFrame {
    public ServerFrame() {
        initComponents();
    }

    private void FileButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        Filelabel = new JLabel();
        PathtextField = new JTextField();
        FileButton = new JButton();
        ServerTextArea = new JTextArea();
        FileButton2 = new JButton();
        FileButton3 = new JButton();

        //======== this ========
        setTitle("\u670d\u52a1\u7aef");
        setFont(new Font("\u4eff\u5b8b", Font.PLAIN, 12));
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
            FileButton.addActionListener(e -> FileButtonActionPerformed(e));

            //---- FileButton2 ----
            FileButton2.setText("\u53d1\u9001");
            FileButton2.setContentAreaFilled(false);
            FileButton2.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, FileButton2.getFont().getSize() + 3));
            FileButton2.addActionListener(e -> FileButtonActionPerformed(e));

            //---- FileButton3 ----
            FileButton3.setText("\u65ad\u5f00\u8fde\u63a5");
            FileButton3.setContentAreaFilled(false);
            FileButton3.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, FileButton3.getFont().getSize() + 3));
            FileButton3.addActionListener(e -> FileButtonActionPerformed(e));

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
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(FileButton3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(FileButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(FileButton2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(28, Short.MAX_VALUE))
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
                                .addComponent(FileButton2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(FileButton3))
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
    private JButton FileButton2;
    private JButton FileButton3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
