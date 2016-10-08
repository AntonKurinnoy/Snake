import javax.swing.*;
import java.awt.*;

public class SnakeGame extends JPanel {

    public static int WIDTH = 600;
    public static int HEIGHT = 550;
    public static String NAME = "MY GAME!!!";

    public void paint(Graphics g){
        g.setColor(color(50,50,100));
        g.fillRect(0,0,WIDTH,HEIGHT);

        g.setColor(color(255,255,0));

        g.getClipBounds();
        HorizontalLine hLine1 = new HorizontalLine(0,WIDTH,8,"=");
        hLine1.draw(g);
        HorizontalLine hLine2 = new HorizontalLine(0,WIDTH,522,"=");
        hLine2.draw(g);
        VerticalLine vLine1 = new VerticalLine(0,0,HEIGHT,"||");
        vLine1.draw(g);
        VerticalLine vLine2 = new VerticalLine(588,0,HEIGHT,"||");
        vLine2.draw(g);

        Point p = new Point(100,100,"*");
        Snake snake = new Snake(p,50,Direction.RIGHT);
        snake.draw(g);
        //snake.move(g);



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
