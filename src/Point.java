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

    /*public Color setColor(int red, int green, int blue){
        return new Color(red,green,blue);
    }*/

    public void draw(Graphics g){
        g.drawString(this.sym,this.x,this.y);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                ", sym=" + sym +
                '}';
    }
}
