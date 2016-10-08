import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class VerticalLine {

    List<Point> pList;

    public VerticalLine(int x, int yUp, int yDown, String c) {
        pList = new ArrayList<>();
        for (int y = yUp; y <= yDown; y++) {
            Point p = new Point(x,y,c);
            pList.add(p);
        }
    }

    public void Draw(Graphics g){
        for (Point point : pList) {
            point.draw(g);
        }
    }
}
