import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Catalog {
    ReadData rd = new ReadData();
    Records rec = new Records();
    Sorter s = new Sorter();

    String movieListPre[] = new String[20];
    String movieList[][] = new String[20][6];

    static String lib = "movielib.txt";
    Font newButtonFont = new Font("Bebas Neue", Font.BOLD, 9);
    Image img = Toolkit.getDefaultToolkit().getImage("catalog.png");

    public Catalog() {
        movieListPre = rd.readFile(lib, movieListPre.length);
        movieList = rec.getRecords(movieListPre);

        String[] columnNames = { "Title",
                "Year",
                "Director",
                "Genre" };

        JFrame frame = new JFrame("Catalog");

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

        JTable table = new JTable(movieList, columnNames);
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
                    movieList = s.sort(movieList, 0);
                    table.setModel(new DefaultTableModel(movieList, columnNames));
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
                    movieList = s.sort(movieList, 3);
                    table.setModel(new DefaultTableModel(movieList, columnNames));
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
                    movieList = s.sort(movieList, 2);
                    table.setModel(new DefaultTableModel(movieList, columnNames));
                }
            }
        });

        JButton closeCat = new JButton("Close");
        closeCat.setBounds(670, 96, 67, 29);
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
        new Catalog();
    }
}