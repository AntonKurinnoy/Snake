import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SnakeGame extends JPanel implements ActionListener{

    public static int WIDTH = 20;
    public static int HEIGHT = 20;
    public static int SCALE = 30;
    public static String NAME = "MY GAME!!!";
    public static final int SPEED = 5;

    public SnakeGame() throws InterruptedException {
        t.start();
    }

    Timer t = new Timer(1000/SPEED, this);
    Point p = new Point(100,100);
    Snake snake = new Snake(p,3,Direction.RIGHT);

    public void paint(Graphics g){

        g.setColor(color(50, 50, 100));
        g.fillRect(0, 0, WIDTH*SCALE, HEIGHT*SCALE);


        g.setColor(color(255, 255, 0));
        for (int x = 0; x <= WIDTH*SCALE; x+=SCALE) {
            g.drawLine(x,0,x,HEIGHT*SCALE);
        }
        for (int y = 0; y <= HEIGHT*SCALE; y+=SCALE) {
            g.drawLine(0,y,WIDTH*SCALE,y);
        }

        for (int i = 0; i < snake.pList.size(); i++) {
            g.setColor(color(255, 0, 0));
            g.fillRect(snake.pList.get(i).getX(),snake.pList.get(i).getY(),SCALE,SCALE);
        }


    }

    public Color color(int red, int green, int blue){
        return new Color(red, green, blue);
    }

    public static void main(String[] args) throws InterruptedException {

        JFrame frame = new JFrame(SnakeGame.NAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH*SCALE+7,HEIGHT*SCALE-1);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(new SnakeGame());
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        snake.sMove();
        repaint();
    }

}
