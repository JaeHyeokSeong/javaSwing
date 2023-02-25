package tutorial8;
import javax.swing.*;
import java.awt.*;

public class ImagePanelPractise extends JPanel{

    private Image img;

    public ImagePanelPractise(String imgLocation) {
        super();
        this.img = (new ImageIcon(imgLocation)).getImage();
        setSize(new Dimension(img.getWidth(null), img.getHeight(null)));
        setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
        setLayout(null);
    }

//    void init() {
//        jf.setSize(600, 600);
//        Dimension frameSize = jf.getSize();
//        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
//        jf.setLocation((windowSize.width - frameSize.width) / 2, (windowSize.height - frameSize.height) / 2);
//        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }
}
