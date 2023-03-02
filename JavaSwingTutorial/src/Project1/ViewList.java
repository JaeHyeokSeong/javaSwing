package Project1;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class ViewList extends JFrame {
    ViewList() {
        super("view list");
        setSize(800, 500);
        setResizable(false);
        // center a window
        Dimension frameSize = getSize();
        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((windowSize.width - frameSize.width) / 2,
                (windowSize.height - frameSize.height) / 2);
        // absolute layout
        setLayout(null);

        /*
        write a code here
        * */

        window();


        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private void window() {
        String titles[] = new String[] {
                "name", "age", "gender", "phone", "btd", "note"
        };
        int columnSize = 6;
        ArrayList<String> data = mySqlPractise.Main.getCustomer();
        String[][] contents = new String[data.size()][columnSize];

        try {
            for(int i = 0; i < data.size(); i++) {
                String[] tmp = data.get(i).split(",");
                for(int j = 0; j < columnSize; j++) {
                    contents[i][j] = tmp[j];
                    System.out.print("entered ");
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("[error] in changing ArrayList into 2-D array");
        }
        // print
        for(int i = 0; i < contents.length; i++) {
            for(int j = 0; j < contents[i].length; j++) {
                System.out.print(contents[i][j] + " ");
            }
            System.out.println();
        }

        JTable jt = new JTable(contents, titles);
        // editable false
        DefaultTableModel tableModel = new DefaultTableModel(contents, titles) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jt.setModel(tableModel);

        // resize table column
        TableColumnModel tc = jt.getColumnModel();
        tc.getColumn(0).setPreferredWidth(10);
        tc.getColumn(1).setPreferredWidth(5);
        tc.getColumn(2).setPreferredWidth(5);


        JScrollPane jsp = new JScrollPane(jt);
        jsp.setLocation(10, 50);
        jsp.setSize(780, 300);
        add(jsp);

        JLabel searchLabel = new JLabel("Search");
        searchLabel.setLocation(100, 22);
        searchLabel.setSize(100, 15);
        add(searchLabel);

        JTextField searchTextField = new JTextField();
        searchTextField.setLocation(150, 20);;
        searchTextField.setSize(500, 20);
        // add key event
        searchTextField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                String val = searchTextField.getText();
                TableRowSorter<TableModel> trs = new TableRowSorter<TableModel>(jt.getModel());
                jt.setRowSorter(trs);
                trs.setRowFilter(RowFilter.regexFilter(val));
            }
        });
        add(searchTextField);
    }
}
