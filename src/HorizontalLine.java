import java.util.ArrayList;

public class HorizontalLine extends Figure{

    public HorizontalLine(int xLeft, int xRight, int y, String c) {
        pList = new ArrayList<>();
        for (int x = xLeft; x <= xRight; x++) {
            Point p = new Point(x,y,c);
            pList.add(p);
        }
    }
}
