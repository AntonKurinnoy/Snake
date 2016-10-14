import java.util.ArrayList;
import java.util.List;

public class Snake {

    Direction direction;
    List<Point> pList;

    Snake(Point tail, int lenght, Direction d){

        direction = d;
        pList = new ArrayList<>();
        for (int i = 0; i < lenght; i++) {
            Point p = new Point(tail);
            p.pMove(i, d);
            pList.add(p);
        }
    }

    void sMove(){

        Point tail = pList.get(0);

        if ((pList.get(pList.size()-1).getX() == SnakeGame.foodOld.getX()) &&
                (pList.get(pList.size()-1).getY() == SnakeGame.foodOld.getY())) {
            Point head = getNextPoint();
            pList.add(head);
        }
        else{
            Point head = getNextPoint();
            pList.add(head);
            pList.remove(tail);
        }
    }

    private Point getNextPoint(){

        Point head = pList.get(pList.size()-1);
        Point nextPoint = new Point(head);
        nextPoint.pMove(1,direction);

        if ((nextPoint.getX() == SnakeGame.food.getX()) &&
                (nextPoint.getY() == SnakeGame.food.getY())) {
            SnakeGame.foodOld.setX(SnakeGame.food.getX());
            SnakeGame.foodOld.setY(SnakeGame.food.getY());
            SnakeGame.food = new Point().createFood();
        }
        return nextPoint;
    }

    boolean sBreak(){
        boolean sBreak = false;

        Point head = pList.get(pList.size()-1);

        for (int i = 0; i < pList.size()-1; i++) {
            if ((head.getX() == pList.get(i).getX()) && (head.getY() == pList.get(i).getY())) sBreak = true;
        }

        if ( (head.getX() < 0) || (head.getY() < 0) ||
                (head.getX() > 570) || (head.getY() > 540) ) sBreak = true;

        return sBreak;
    }

}
