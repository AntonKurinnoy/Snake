import javax.swing.*;
import java.awt.*;

public class SnakeGame extends JPanel {

    public static int WIDTH = 600;
    public static int HEIGHT = 550;
    public static String NAME = "MY GAME!!!";

    public SnakeGame() {
    }

    public void paint(Graphics g){
        g.setColor(color(50,100,100));
        g.fillRect(0,0,WIDTH,HEIGHT);

        g.setColor(color(0,250,250));
        Point p1 = new Point(100,100,"9jh");
        p1.setColor(0,250,250);
        p1.draw(g);
    }

    public Color color(int red, int green, int blue){
        return new Color(red, green, blue);
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame(SnakeGame.NAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH,HEIGHT);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(new SnakeGame());
        frame.setVisible(true);

    }

}
