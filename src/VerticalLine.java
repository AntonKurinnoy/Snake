import java.util.ArrayList;

public class VerticalLine extends Figure{

    public VerticalLine(int x, int yUp, int yDown, String c) {
        pList = new ArrayList<>();
        for (int y = yUp; y <= yDown; y++) {
            Point p = new Point(x,y,c);
            pList.add(p);
        }
    }
}
