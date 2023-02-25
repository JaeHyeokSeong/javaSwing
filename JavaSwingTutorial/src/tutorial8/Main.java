package tutorial8;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // image location : ./image/kakoImage.jpg
        JFrame jf = new JFrame("Insert image into JPanel");
        jf.setSize(600, 600);
        Dimension frameSize = jf.getSize();
        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        jf.setLocation((windowSize.width - frameSize.width) / 2, (windowSize.height - frameSize.height) / 2);

        ImagePanelPractise ipp = new ImagePanelPractise("./image/kakoImage.jpg");
        jf.add(ipp);
        jf.pack();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
