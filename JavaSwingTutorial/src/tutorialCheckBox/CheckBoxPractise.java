package tutorialCheckBox;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CheckBoxPractise extends JFrame {
    private JCheckBox hamburgerCheckBox;
    private JCheckBox pizzaCheckBox;
    private JCheckBox cokeCheckBox;
    private JTextArea receipt;

    public CheckBoxPractise() {
        super("check box practise");
        setLayout(null);
        setSize(400, 300);
        setResizable(false);
        // 화면 중앙에 출력
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // write components here
        menu();
        displayReceipt();
        orderMenu();

        // set visible true
        setVisible(true);
    }

    void menu() {
        JLabel menuLabel = new JLabel("menu");
        menuLabel.setSize(50, 20);
        menuLabel.setLocation(70, 40);

        hamburgerCheckBox = new JCheckBox("hamburger");
        hamburgerCheckBox.setSize(100, 20);
        hamburgerCheckBox.setLocation(70, 80);

        pizzaCheckBox = new JCheckBox("pizza");
        pizzaCheckBox.setSize(100, 20);
        pizzaCheckBox.setLocation(70, 110);

        cokeCheckBox = new JCheckBox("coke");
        cokeCheckBox.setSize(100, 20);
        cokeCheckBox.setLocation(70, 140);

        add(menuLabel);
        add(hamburgerCheckBox);
        add(pizzaCheckBox);
        add(cokeCheckBox);
    }
    void orderMenu() {
        JButton orderButton = new JButton("order");
        orderButton.setSize(50, 20);
        orderButton.setLocation(60, 180);

        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> selectedMenu = new ArrayList<String>();
                Date date = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                if(hamburgerCheckBox.isSelected()) selectedMenu.add(hamburgerCheckBox.getText());
                if(pizzaCheckBox.isSelected()) selectedMenu.add(pizzaCheckBox.getText());
                if(cokeCheckBox.isSelected()) selectedMenu.add(cokeCheckBox.getText());

                String menu_txt = "";
                for(String menu : selectedMenu) {
                    menu_txt += (menu + '\n');
                }
                int result = JOptionPane.showConfirmDialog(null, menu_txt, "confirm menu", JOptionPane.YES_NO_OPTION);
                // yes == 0
                if(result == 0) {
                    String timeInfo = formatter.format(date) + "\n";
                    String txt = "Thank you\n\n" + timeInfo + "\n" + menu_txt;
                    receipt.setEditable(true);
                    receipt.setText(txt);
                    receipt.setEditable(false);
                }
            }
        });
        add(orderButton);
    }

    void displayReceipt() {
        JLabel receiptLabel = new JLabel("receipt");
        receiptLabel.setSize(50, 20);
        receiptLabel.setLocation(220, 40);

        receipt = new JTextArea();
        receipt.setSize(150, 130);
        receipt.setLocation(220, 70);
        receipt.setEditable(false);

        add(receiptLabel);
        add(receipt);
    }

}
