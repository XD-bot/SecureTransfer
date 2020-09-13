import java.awt.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Sun Sep 13 22:37:41 CST 2020
 */



/**
 * @author unknown
 */
public class testFrame extends JFrame {
    public testFrame() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        tabbedPane1 = new JTabbedPane();
        panel1 = new JPanel();
        label1 = new JLabel();
        textField1 = new JTextField();
        panel2 = new JPanel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== tabbedPane1 ========
        {
            tabbedPane1.setBackground(new Color(204, 204, 204));
            tabbedPane1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
            tabbedPane1.setForeground(Color.black);

            //======== panel1 ========
            {
                panel1.setBackground(Color.white);
                panel1.setLayout(null);

                //---- label1 ----
                label1.setText("text");
                label1.setForeground(Color.black);
                panel1.add(label1);
                label1.setBounds(25, 0, 105, 70);
                panel1.add(textField1);
                textField1.setBounds(new Rectangle(new Point(120, 10), textField1.getPreferredSize()));

                { // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel1.getComponentCount(); i++) {
                        Rectangle bounds = panel1.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel1.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel1.setMinimumSize(preferredSize);
                    panel1.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("\u670d\u52a1\u7aef", panel1);

            //======== panel2 ========
            {
                panel2.setLayout(null);

                { // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel2.getComponentCount(); i++) {
                        Rectangle bounds = panel2.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel2.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel2.setMinimumSize(preferredSize);
                    panel2.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("\u5ba2\u6237\u7aef", panel2);
        }
        contentPane.add(tabbedPane1);
        tabbedPane1.setBounds(0, 0, 400, 270);

        { // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JLabel label1;
    private JTextField textField1;
    private JPanel panel2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        new testFrame().setVisible(true);
    }
}
