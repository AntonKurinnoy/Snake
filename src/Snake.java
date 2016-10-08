import java.util.ArrayList;

public class Snake extends Figure{

    public Snake(Point tail, int lenght, Direction direction){

        pList = new ArrayList<>();
        for (int i = 0; i < lenght; i++) {
            Point p = new Point(tail);
            p.Move(i, direction);
            pList.add(p);
        }
    }
}
