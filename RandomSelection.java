import java.awt.*;
import java.util.Random;
import javax.swing.*;
import javax.swing.JFrame;

public class RandomSelection {
    ReadData rd = new ReadData();
    Records rec = new Records();

    String movieListPre[] = new String[20];
    String movieList[][] = new String[20][6];

    static String lib = "movielib.txt";
    Image bgimg = Toolkit.getDefaultToolkit().getImage("recomendedmoviepage.png");
    Image stockimg = Toolkit.getDefaultToolkit().getImage("stockimg.jpg");
    Font newButtonFont = new Font("Bebas Neue", Font.BOLD, 15);

    public RandomSelection() {
        movieListPre = rd.readFile(lib, movieListPre.length);
        movieList = rec.getRecords(movieListPre);

        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(960, 540);

        frame.setContentPane(new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Dimension d = getSize();
                g.drawImage(bgimg, 0, 0, d.width, d.height, this);
                g.drawImage(stockimg, 88, 111, 288, 315, this);
            }
        });

        int max = 6;
        int min = 0;

        int rand = (int) (Math.random() * (max - min + 1) + min);

        // System.out.println(rand);

        String title = movieList[rand][0];
        String year = movieList[rand][1];
        String genre = movieList[rand][3];

        frame.setLayout(null);

        JTextArea MovieInfo = new JTextArea();
        MovieInfo.setEditable(false);
        MovieInfo.append(title + "\n" + year + "\n" + genre);
        MovieInfo.setBounds(394, 114, 292, 64);
        MovieInfo.setBackground(new Color(237, 221, 212));
        MovieInfo.setForeground(Color.BLACK);
        MovieInfo.setFont(newButtonFont);
        frame.add(MovieInfo);

        JTextArea Detail = new JTextArea();
        Detail.setEditable(false);
        Detail.append(
                " CANT PICK WHAT TO WATCH? \n WE HAVE PICKED A MOVIE PERFECT FOR YOU! \n TRY OUR PICK AND TELL US IF YOU LIKE IT :D");
        Detail.setBounds(394, 200, 442, 226);
        Detail.setBackground(new Color(219, 58, 52));
        Detail.setForeground(Color.WHITE);
        Detail.setFont(newButtonFont);
        frame.add(Detail);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public static void main(String args[]) {
        new RandomSelection();
    }
}
