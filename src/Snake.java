import java.awt.*;
import java.util.ArrayList;

public class Snake extends Figure{

    Direction direction;

    public Snake(Point tail, int lenght, Direction d){

        direction = d;
        pList = new ArrayList<>();
        for (int i = 0; i < lenght; i++) {
            Point p = new Point(tail);
            p.move(i, d);
            pList.add(p);
        }
    }

    /*public void move(Graphics g){
        Point tail = pList.get(0);
        pList.remove(tail);
        Point head = GetNextPoint();
        pList.add(head);

        tail.clear(g);
        head.draw(g);
    }

    public Point GetNextPoint(){
        Point head = pList.get(pList.size());
        Point nextPoint = new Point(head);
        nextPoint.move(1,direction);
        return nextPoint;
    }*/

}
