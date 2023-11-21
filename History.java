import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class History {
    ReadData rd = new ReadData();
    Records rec = new Records();
    Sorter s = new Sorter();
    SearchInput2 si2 = new SearchInput2();

    String historyPre[] = new String[20];
    String historyList[][] = new String[20][6];

    static String hist = "history.txt";
    Font newButtonFont = new Font("Bebas Neue", Font.BOLD, 9);
    Image img = Toolkit.getDefaultToolkit().getImage("historypage.png");

    public History() {
        historyPre = rd.readFile(hist, historyList.length);
        historyList = rec.getRecords(historyPre);

        String[] columnNames = { "Title",
                "Year",
                "Director",
                "Genre" };

        JFrame frame = new JFrame("History");

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(960, 540);

        frame.setContentPane(new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Dimension d = getSize();
                g.drawImage(img, 0, 0, d.width, d.height, this);
            }
        });

        JTable table = new JTable(historyList, columnNames);
        table.setDefaultEditor(Object.class, null);

        JScrollPane scrollableList = new JScrollPane();
        scrollableList.setBounds(208, 134, 529, 299);
        scrollableList.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollableList.getViewport().add(table);

        frame.add(scrollableList);

        frame.setLayout(null);

        JButton Name = new JButton("Name");
        Name.setBounds(208, 96, 65, 29);
        Name.setBackground(new Color(219, 58, 52));
        frame.add(Name);
        Name.setFont(newButtonFont);

        Name.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String str = e.getActionCommand();
                if (str.equals("Name")) {
                    historyList = s.sort(historyList, 0);
                    table.setModel(new DefaultTableModel(historyList, columnNames));
                }
            }
        });

        JButton Genre = new JButton("Genre");
        Genre.setBounds(277, 96, 65, 29);
        Genre.setBackground(new Color(219, 58, 52));
        frame.add(Genre);
        Genre.setFont(newButtonFont);

        Genre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String str = e.getActionCommand();
                if (str.equals("Genre")) {
                    historyList = s.sort(historyList, 3);
                    table.setModel(new DefaultTableModel(historyList, columnNames));
                }
            }
        });

        JButton Year = new JButton("Year");
        Year.setBounds(347, 96, 65, 29);
        Year.setBackground(new Color(219, 58, 52));
        frame.add(Year);
        Year.setFont(newButtonFont);

        Year.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String str = e.getActionCommand();
                if (str.equals("Year")) {
                    historyList = s.sort(historyList, 2);
                    table.setModel(new DefaultTableModel(historyList, columnNames));
                }
            }
        });

        JButton Delete = new JButton("Delete");
        Delete.setBounds(417, 96, 65, 29);
        Delete.setBackground(new Color(219, 58, 52));
        frame.add(Delete);
        Delete.setFont(newButtonFont);

        Delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String str = e.getActionCommand();
                if (str.equals("Delete")) {
                    String selectedData = null;

                    int[] selectedRow = table.getSelectedRows();
                    int[] selectedColumns = table.getSelectedColumns();

                    for (int i = 0; i < selectedRow.length; i++) {
                        for (int j = 0; j < selectedColumns.length; j++) {
                            selectedData = (String) table.getValueAt(selectedRow[i], selectedColumns[j]);
                        }
                    }
                    try {
                        si2.keyInput(hist, historyList, 0, selectedData);
                    } catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                ;
            }
        });

        JButton closeCat = new JButton("Close");
        closeCat.setBounds(670, 93, 67, 30);
        closeCat.setBackground(new Color(219, 58, 52));
        frame.add(closeCat);
        closeCat.setFont(newButtonFont);

        closeCat.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String str = e.getActionCommand();
                if (str.equals("Close")) {
                    try {
                        frame.dispose();
                    } catch (Exception ex) {
                        System.out.print("Error");
                    }
                }
            }

        });

        frame.setVisible(true);
    }

    public static void main(String args[]) {
        new History();
    }
}