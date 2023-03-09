package tutorialRadionButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RadioButtonPractise extends JFrame {

    public RadioButtonPractise() {
        super("radio button practise");
        setSize(600, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JRadioButton korButton = new JRadioButton("Korean");
        JRadioButton engButton = new JRadioButton("English");
        JRadioButton chinButton = new JRadioButton("Chinese");

        // raido button 들 중에서 하나만 선택가능하도록 하기위해서 그룹화를 한다.
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(korButton);
        buttonGroup.add(engButton);
        buttonGroup.add(chinButton);

        korButton.setSize(300, 30);
        korButton.setLocation(100, 100);
        engButton.setSize(300, 30);
        engButton.setLocation(100, 150);
        chinButton.setSize(300, 30);
        chinButton.setLocation(100, 200);

        Font font = new Font("Arial", Font.BOLD, 24);
        korButton.setFont(font);
        engButton.setFont(font);
        chinButton.setFont(font);

        // korean default select option
        korButton.setSelected(true);

        // event
        korButton.addActionListener(new RadioButtonEvent());
        engButton.addActionListener(new RadioButtonEvent());
        chinButton.addActionListener(new RadioButtonEvent());

        // 유저가 선택하면 개발자 입장에서 나타나는 값
        korButton.setActionCommand("kor");
        engButton.setActionCommand("eng");
        chinButton.setActionCommand("chi");

        add(korButton);
        add(engButton);
        add(chinButton);

        setVisible(true);
    }

    class RadioButtonEvent implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("selected language : " + e.getActionCommand());
        }
    }
}
