import java.util.ArrayList;
import java.util.List;

public class Snake {

    Direction direction;
    public List<Point> pList;

    public Snake(Point tail, int lenght, Direction d){

        direction = d;
        pList = new ArrayList<>();
        for (int i = 0; i < lenght; i++) {
            Point p = new Point(tail);
            p.pMove(i, d);
            pList.add(p);
        }
    }

    public List<Point> getpList() {
        return pList;
    }

    public void sMove(){
        Point tail = pList.get(0);
        pList.remove(tail);
        Point head = GetNextPoint();
        pList.add(head);
    }

    public Point GetNextPoint(){
        Point head = pList.get(pList.size()-1);
        Point nextPoint = new Point(head);
        nextPoint.pMove(1,direction);
        return nextPoint;
    }

}
