
public class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point p) {
        this.x = p.getX();
        this.y = p.getY();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    public void pMove(int offset, Direction direction){
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

    /*public void draw(Graphics g){
        g.drawString(this.sym,this.x,this.y);
    }*/

}
