import java.awt.*;
import java.util.List;

public class Figure {
    protected List<Point> pList;

    public void draw(Graphics g){
        for (Point point : pList) {
            point.draw(g);
        }
    }
}
