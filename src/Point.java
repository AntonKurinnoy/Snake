import java.util.Random;

public class Point {
    private int x;
    private int y;

    Point(){
    }

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Point(Point p) {
        this.x = p.getX();
        this.y = p.getY();
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    void setX(int x) {
        this.x = x;
    }

    void setY(int y) {
        this.y = y;
    }

    //передвигаем точку в пространстве в одном из направлений
    void pMove(int offset, Direction direction){
        if (direction == Direction.RIGHT){
            x = x + offset*SnakeGame.SCALE;
        }
        else if (direction == Direction.LEFT){
            x = x - offset*SnakeGame.SCALE;
        }
        else if (direction == Direction.UP){
            y = y - offset*SnakeGame.SCALE;
        }
        else if (direction == Direction.DOWN){
            y = y + offset*SnakeGame.SCALE;
        }
    }

    //генерируем еду
    Point createFood(){
        Point food;
        boolean containsB = false;
        Random r = new Random();
        //проверяем не попала ли наша еда на тело змейки
        do {
            food = new Point(r.nextInt(20)*SnakeGame.SCALE, r.nextInt(19)*SnakeGame.SCALE);
            for (int i = 0; i < SnakeGame.snake.pList.size(); i++) {
                if ((SnakeGame.snake.pList.get(i).getX() == food.getX()) &&
                        (SnakeGame.snake.pList.get(i).getY() == food.getY()))
                    containsB = true;
                if (containsB) i = SnakeGame.snake.pList.size();
            }
        }while (containsB);
        return food;
    }


    @Override
    public String toString() {
        return "x= " + x + "y= " + y;
    }
}
