import java.awt.*;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.event.*;
import java.io.File;

public class guiMain {
    static String lib = "movielib.txt";
    static String hist = "history.txt";
    NewRecord nr = new NewRecord();
    Font newButtonFont = new Font("Bebas Neue", Font.BOLD, 16);

    Image img = Toolkit.getDefaultToolkit().getImage("mainpage.png");

    public guiMain() {
        JFrame frame = new JFrame("Main Window");
        frame = new JFrame();
        frame.setTitle("NetLog");
        frame.setSize(960, 540);
        frame.setResizable(false);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setContentPane(new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Dimension d = getSize();
                g.drawImage(img, 0, 0, d.width, d.height, this);
            }
        });

        frame.setLayout(null);

        JButton submit = new JButton("...");
        submit.setBounds(621, 321, 59, 39);
        submit.setBackground(new Color(219, 58, 52));
        frame.add(submit);
        submit.setFont(newButtonFont);
        submit.setForeground(Color.WHITE);

        JButton catalog = new JButton("CATALOG");
        catalog.setBounds(766, 19, 164, 111);
        catalog.setBackground(new Color(237, 221, 212));
        frame.add(catalog);
        catalog.setFont(newButtonFont);

        JButton history = new JButton("HISTORY");
        history.setBounds(766, 135, 164, 111);
        history.setBackground(new Color(237, 221, 212));
        frame.add(history);
        history.setFont(newButtonFont);

        String twoLines = "Random\nSelection";
        JButton randomSelection = new JButton("<html>" + twoLines.replaceAll("\\n", "<br>") + "</html>");
        randomSelection.setBounds(766, 250, 164, 112);
        randomSelection.setBackground(new Color(237, 221, 212));
        frame.add(randomSelection);
        randomSelection.setFont(newButtonFont);

        JButton help = new JButton("HELP");
        help.setBounds(766, 366, 164, 111);
        help.setBackground(new Color(237, 221, 212));
        frame.add(help);
        help.setFont(newButtonFont);

        JTextField inputBox = new JTextField("TITLE#YEAR#DIRECTOR#GENRE");
        inputBox.setBounds(283, 320, 337, 40);
        inputBox.setBackground(new Color(40, 61, 59));
        frame.add(inputBox);
        inputBox.setForeground(Color.WHITE);
        inputBox.setFont(newButtonFont);

        frame.setVisible(true);

        // BUTTON FUNCTIONS

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String str = e.getActionCommand();
                if (str.equals("...")) {
                    String textFieldValue = inputBox.getText();
                    nr.addRecord(hist, textFieldValue);
                }
            }
        });

        catalog.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String str = e.getActionCommand();
                if (str.equals("CATALOG")) {
                    try {
                        new Catalog();
                    } catch (Exception ex) {
                        System.out.print("Error");
                    }
                }
            }
        });

        history.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String str = e.getActionCommand();
                if (str.equals("HISTORY")) {
                    try {
                        new History();
                    } catch (Exception ex) {
                        System.out.print("Error");
                    }
                }
            }
        });

        randomSelection.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String str = e.getActionCommand();
                if (str.equals("<html>" + twoLines.replaceAll("\\n", "<br>") + "</html>")) {
                    try {
                        new RandomSelection();
                    } catch (Exception ex) {
                        System.out.print("Error");
                    }
                }
            }
        });

        help.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String str = e.getActionCommand();
                if (str.equals("HELP")) {
                    try {
                        File myFile = new File("ICS4U Help Screen.pdf");
                        Desktop.getDesktop().open(myFile);
                    } catch (Exception ex) {
                        System.out.print("Error");
                    }
                }
            }
        });

    }

    public static void main(String args[]) {
        new guiMain();
    }
}
