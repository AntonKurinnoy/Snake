import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class HorizontalLine {

    List<Point> pList;

    public HorizontalLine(int xLeft, int xRight, int y, String c) {
        pList = new ArrayList<>();
        for (int x = xLeft; x <= xRight; x++) {
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
