package tutorial9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeButtonColor {
    private JButton jb1;
    public ChangeButtonColor() {
        JFrame jf = new JFrame("Testing");
        jf.setSize(500, 500);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel jp = new JPanel();

        jb1 = new JButton("Button 1");
        jb1.setPreferredSize(new Dimension(200, 50));
        jb1.addActionListener(new EventHandler());
        jb1.setBackground(Color.ORANGE);

        jp.add(jb1);
        jf.add(jp);
        jf.setVisible(true);
    }

    class EventHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == jb1) {
                System.out.println("b1 is clicked");
                if(jb1.getBackground() == Color.ORANGE) {
                    jb1.setBackground(Color.GREEN);
                    System.out.println("Changed to Green");
                } else {
                    jb1.setBackground(Color.ORANGE);
                    System.out.println("Changed to Orange");
                }
            }
        }
    }
}
