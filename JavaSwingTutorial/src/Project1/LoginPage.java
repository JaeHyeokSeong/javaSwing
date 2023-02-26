package Project1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame {

    private JTextField idTextField;
    private JPasswordField passwordTextField;
    private JButton loginButton, clearButton;

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
        menus[1].add(idTextField = new JTextField(10));
        menus[2].add(new JLabel("PWD "));
        menus[3].add(passwordTextField = new JPasswordField(10));

        // add events to login and clear buttons
        loginButton = new JButton("Login");
        clearButton = new JButton("Clear");
        loginButton.addActionListener(new EventHandler());
        clearButton.addActionListener(new EventHandler());
        menus[4].add(loginButton);
        menus[5].add(clearButton);

        for(int i = 0; i < 6; i++) {
            mainPanel.add(menus[i]);
        }

        add(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    class EventHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == loginButton) {
                // sample id = "1234" and password = "1234"
                if(idTextField.getText().equals("1234") && new String(passwordTextField.getPassword()).equals("1234")) {
                    System.out.println("login success");
                }
                else {
                    System.out.println("login fail");
                    JOptionPane.showMessageDialog(null, "Login fail", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
            else if(e.getSource() == clearButton) {
                idTextField.setText("");
                passwordTextField.setText("");
            }
        }
    }
}
