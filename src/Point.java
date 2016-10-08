import java.awt.*;

public class Point {
    public int x;
    public int y;
    public String sym;

    public Point(int x, int y, String sym) {
        this.x = x;
        this.y = y;
        this.sym = sym;
    }

    public Point(Point p) {
        this.x = p.getX();
        this.y = p.getY();
        this.sym = p.getSym();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getSym() {
        return sym;
    }

    public void move(int offset, Direction direction){
        if (direction == Direction.RIGHT){
            x = x + offset;
        }
        if (direction == Direction.LEFT){
            x = x - offset;
        }
        if (direction == Direction.UP){
            y = y + offset;
        }
        if (direction == Direction.DOWN){
            y = y - offset;
        }
    }

    public void clear(Graphics g){
        sym = " ";
        g.drawString(sym,this.x,this.y);

    }

    public void draw(Graphics g){
        g.drawString(this.sym,this.x,this.y);
    }

}
