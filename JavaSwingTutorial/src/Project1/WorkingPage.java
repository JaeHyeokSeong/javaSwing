package Project1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static mySqlPractise.Main.createCustomer;
import static mySqlPractise.Main.createTable;

public class WorkingPage extends JFrame {

    public WorkingPage() {
        super("Working area");
        setSize(600, 500);
        setResizable(false);
        Dimension frameSize = getSize();
        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((windowSize.width - frameSize.width) / 2,
                (windowSize.height - frameSize.height) / 2);

        // absolute layout
        setLayout(null);

        JLabel welcomeLable = new JLabel("Enter your information");
        welcomeLable.setSize(400, 20);
        welcomeLable.setLocation(200, 20);

        add(welcomeLable);

        // implements menu bar
        setJMenuBar(setMenuBar());

        // implements components to fill user's information
        setUserInformation();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    private JMenuBar setMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        // file menu
        JMenu fileMenu = new JMenu("File");
        // file menu items
        JMenuItem openMenuItem = new JMenuItem("Open");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        // add menu items
        fileMenu.add(openMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);
        // file menu items events
        openMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("open menu item has clicked");
            }
        });

        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("exit menu item has clicked");
                System.exit(0);
            }
        });
        // about menu
        JMenu aboutMenu = new JMenu("About");

        menuBar.add(fileMenu);
        menuBar.add(aboutMenu);

        return menuBar;
    }

    private void setUserInformation() {
        // JLabel
        JLabel nameLabel = new JLabel("name");
        nameLabel.setSize(50, 20);
        nameLabel.setLocation(100, 50);

        JLabel ageLabel = new JLabel("age");
        ageLabel.setSize(50, 20);
        ageLabel.setLocation(100, 90);

        JLabel genderLabel = new JLabel("gender");
        genderLabel.setSize(50, 20);
        genderLabel.setLocation(100, 130);

        JLabel phoneLabel = new JLabel("phone");
        phoneLabel.setSize(50, 20);
        phoneLabel.setLocation(100, 170);

        JLabel birthdayLabel = new JLabel("btd");
        birthdayLabel.setSize(50, 20);
        birthdayLabel.setLocation(100, 210);

        JLabel noteLabel = new JLabel("note");
        noteLabel.setSize(50, 20);
        noteLabel.setLocation(100, 250);

        // JTextField
        JTextField nameTextField = new JTextField();
        nameTextField.setSize(300, 20);
        nameTextField.setLocation(200, 50);

        JTextField ageTextField = new JTextField();
        ageTextField.setSize(300, 20);
        ageTextField.setLocation(200, 90);

        // combo box 으로 설정하기
        JComboBox<String> genderComboBox = new JComboBox<String>(new String[]{"male", "female"});
        genderComboBox.setSize(300, 20);
        genderComboBox.setLocation(200, 130);

        JTextField phoneTextField = new JTextField();
        phoneTextField.setSize(300, 20);
        phoneTextField.setLocation(200, 170);

        JTextField birthdayTextField = new JTextField();
        birthdayTextField.setSize(300, 20);
        birthdayTextField.setLocation(200, 210);

        JTextArea noteTextArea = new JTextArea();
        noteTextArea.setSize(300, 50);
        noteTextArea.setLocation(200, 250);
        JScrollPane jp = new JScrollPane(noteTextArea);
        jp.setSize(300, 50);
        jp.setLocation(200, 250);

        JButton submitButton = new JButton("submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] userInformation = new String[] {
                    nameTextField.getText(), ageTextField.getText(),
                        genderComboBox.getSelectedItem().toString(),
                        phoneTextField.getText(),
                        birthdayTextField.getText(),
                        noteTextArea.getText()
                };
                // print entered values
                for(String txt : userInformation) {
                    System.out.println(txt);
                }
                // save entered values into sql server
                mySqlPractise.Main.createTable();
                boolean created = mySqlPractise.Main.createCustomer(nameTextField.getText(), ageTextField.getText(),
                        genderComboBox.getSelectedItem().toString(), phoneTextField.getText(),
                        birthdayTextField.getText(), noteTextArea.getText());

                if(created) {
                    JOptionPane.showMessageDialog(null, "submitted", "information", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "fail", "warning", JOptionPane.WARNING_MESSAGE);
                }
                // clear entered values
                nameTextField.setText("");
                ageTextField.setText("");
                phoneTextField.setText("");
                birthdayLabel.setText("");
                noteTextArea.setText("");
            }
        });
        submitButton.setSize(200, 50);
        submitButton.setLocation(300, 350);

        add(nameLabel);
        add(ageLabel);
        add(genderLabel);
        add(phoneLabel);
        add(birthdayLabel);
        add(noteLabel);

        add(nameTextField);
        add(ageTextField);
        add(genderComboBox);
        add(phoneTextField);
        add(birthdayTextField);
        add(jp);

        add(submitButton);
    }
}
