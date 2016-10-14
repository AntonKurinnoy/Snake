import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardListener extends KeyAdapter{
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if((key == KeyEvent.VK_RIGHT) && (SnakeGame.snake.direction != Direction.LEFT))
            SnakeGame.snake.direction = Direction.RIGHT;
        else if((key == KeyEvent.VK_LEFT) && (SnakeGame.snake.direction != Direction.RIGHT))
            SnakeGame.snake.direction = Direction.LEFT;
        else if((key == KeyEvent.VK_UP) && (SnakeGame.snake.direction != Direction.DOWN))
            SnakeGame.snake.direction = Direction.UP;
        else if((key == KeyEvent.VK_DOWN) && (SnakeGame.snake.direction != Direction.UP))
            SnakeGame.snake.direction = Direction.DOWN;

    }
}
