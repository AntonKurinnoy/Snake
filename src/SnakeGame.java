import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SnakeGame extends JPanel implements ActionListener{

    public static int WIDTH = 20;
    public static int HEIGHT = 20;
    public static int SCALE = 30;
    public static String NAME = "MY GAME!!!";
    public static final int SPEED = 5;

    public SnakeGame() {
        t.start();
        addKeyListener(new Keyboard());
        setFocusable(true);
    }

    Timer t = new Timer(1000/SPEED, this);
    Point p = new Point(WIDTH*SCALE/5,HEIGHT*SCALE/5);
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
            g.setColor(color(255, 255, 0));
            g.fillRoundRect(snake.pList.get(i).getX()+2,snake.pList.get(i).getY()+2,SCALE-2,SCALE-2,30,30);
        }


    }

    public Color color(int red, int green, int blue){
        return new Color(red, green, blue);
    }

    public static void main(String[] args) {

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

    private class Keyboard extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            char key = e.getKeyChar();

            if(key == KeyEvent.VK_RIGHT) snake.direction = Direction.RIGHT;
            if(key == KeyEvent.VK_LEFT) snake.direction = Direction.LEFT;
            if(key == KeyEvent.VK_UP) snake.direction = Direction.UP;
            if(key == KeyEvent.VK_DOWN) snake.direction = Direction.DOWN;

        }
    }

}
