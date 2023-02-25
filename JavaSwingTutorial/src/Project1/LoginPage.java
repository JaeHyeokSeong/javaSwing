package Project1;

import javax.swing.*;
import java.awt.*;

public class LoginPage extends JFrame {

    public LoginPage() {
        super("Login");
        setSize(350, 200);
        setResizable(false);
        Dimension frameSize = getSize();
        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((windowSize.width - frameSize.width) / 2,
                (windowSize.height - frameSize.height) / 2);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 3));

        JPanel[] menus = new JPanel[6];
        for(int i = 0; i < menus.length; i++) {
            menus[i] = new JPanel(new FlowLayout(FlowLayout.CENTER));
        }

        menus[0].add(new JLabel("ID "));
        menus[1].add(new JTextField(10));
        menus[2].add(new JLabel("PWD "));
        menus[3].add(new JTextField(10));
        menus[4].add(new JButton("Login"));
        menus[5].add(new JButton("Clear"));

        for(int i = 0; i < 6; i++) {
            mainPanel.add(menus[i]);
        }

        add(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
