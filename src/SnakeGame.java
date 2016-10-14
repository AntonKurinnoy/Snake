import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SnakeGame extends JPanel implements ActionListener{

    private static int WIDTH = 20;
    private static int HEIGHT = 20;
    static int SCALE = 30;
    private static String NAME = "MY GAME!!!";
    private static final int SPEED = 3;

    private SnakeGame() {
        t.start();
        addKeyListener(new KeyboardListener());
        setFocusable(true);
    }

    private Timer t = new Timer(1000/SPEED, this);
    private static Point p = new Point(WIDTH*SCALE/5,HEIGHT*SCALE/5);
    static Snake snake = new Snake(p,5,Direction.RIGHT);
    static Point food = new Point().createFood();
    static Point foodOld = new Point(food.getX(),food.getY());


    public void paint(Graphics g){

        g.setColor(color(189,183,107));
        g.fillRect(0, 0, WIDTH*SCALE, HEIGHT*SCALE);


        g.setColor(color(255,255,255));
        for (int x = 0; x <= WIDTH*SCALE; x+=SCALE) {
            g.drawLine(x,0,x,HEIGHT*SCALE);
        }
        for (int y = 0; y <= HEIGHT*SCALE; y+=SCALE) {
            g.drawLine(0,y,WIDTH*SCALE,y);
        }

        for (int i = 0; i < snake.pList.size(); i++) {
            g.setColor(color(240, 230, 15));
            g.fillRoundRect(snake.pList.get(i).getX()+2,snake.pList.get(i).getY()+2,SCALE-2,SCALE-2,30,30);
            if (i == snake.pList.size()-1) {
                g.setColor(color(0,0,255));
                g.fillRoundRect(snake.pList.get(i).getX()+2,snake.pList.get(i).getY()+2,SCALE-2,SCALE-2,30,30);
            }
        }

        g.setColor(color(100,105,90));
        g.fill3DRect(food.getX()+2,food.getY()+2,SCALE-2,SCALE-2,true);

    }

    private Color color(int red, int green, int blue){
        return new Color(red, green, blue);
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame(SnakeGame.NAME);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(WIDTH*SCALE+7,HEIGHT*SCALE-1);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(new SnakeGame());
        frame.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        snake.sMove();
        if (snake.sBreak()) {
            JOptionPane.showMessageDialog(null,"LOSER!");
            t.stop();
        }
        repaint();
    }

}
