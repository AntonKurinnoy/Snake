import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Program extends Canvas implements Runnable{
    //private static final long serialVersionUID = 1L;
    private boolean running;

    public static int WIDTH = 400;
    public static int HEIGHT = 300;
    public static String NAME = "MY GAME!!!";

    public void start(){
        running = true;
        new Thread(this).start();
    }


    public void run(){
        long lastTime = System.currentTimeMillis();
        long delta;

        init();

        while (running){
            delta = System.currentTimeMillis() - lastTime;
            lastTime = System.currentTimeMillis();
            update(delta);
            render();
        }

    }

    public void init(){

    }

    public void render(){
        BufferStrategy bs = getBufferStrategy();
        if(bs == null){
            createBufferStrategy(2);
            requestFocus();
            return;
        }

        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.cyan);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.dispose();
        bs.show();

    }

    public void update(long delta){

    }

    public static void main(String[] args) {
        Program game = new Program();
        game.setPreferredSize(new Dimension(WIDTH,HEIGHT));

        JFrame frame = new JFrame(Program.NAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(game, BorderLayout.CENTER);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);

        game.start();

    }
}
