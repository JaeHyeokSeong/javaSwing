package Project1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        // implements menu bar
        setJMenuBar(setMenuBar());

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
}
