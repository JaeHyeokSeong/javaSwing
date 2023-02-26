package Project1;

import javax.swing.*;
import java.awt.*;

public class WorkingPage extends JFrame {

    public WorkingPage() {
        super("Working area");
        setSize(600, 400);
        setResizable(false);
        Dimension frameSize = getSize();
        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((windowSize.width - frameSize.width) / 2,
                (windowSize.height - frameSize.height) / 2);

        // absolute layout
        setLayout(null);

        JLabel welcomeLable = new JLabel("Welcome this is working page");
        welcomeLable.setSize(400, 20);
        welcomeLable.setLocation(200, 20);

        add(welcomeLable);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
