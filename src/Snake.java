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

    //реализация передвижения змейки
    void sMove(){

        Point tail = pList.get(0);

        //если змейка съела еду, то последнее звено(хвост) не убирается
        if ((pList.get(pList.size()-1).getX() == SnakeGame.foodOld.getX()) &&
                (pList.get(pList.size()-1).getY() == SnakeGame.foodOld.getY())) {
            Point head = getNextPoint();
            pList.add(head);
        }
        //если змейка не съедает еду, то последнее звено(хвост) удаляется
        else{
            Point head = getNextPoint();
            pList.add(head);
            pList.remove(tail);
        }
    }

    //метод, генерирующий след. точку для змейки при передвижении
    private Point getNextPoint(){

        Point head = pList.get(pList.size()-1);
        Point nextPoint = new Point(head);
        nextPoint.pMove(1,direction);

        //в момент, когда змейка съедает еду генерируется новая. Чтоб реализовать возможность
        //корректного отображения увеличения змейки запоминаем старые координаты еды
        if ((nextPoint.getX() == SnakeGame.food.getX()) &&
                (nextPoint.getY() == SnakeGame.food.getY())) {
            SnakeGame.foodOld.setX(SnakeGame.food.getX());
            SnakeGame.foodOld.setY(SnakeGame.food.getY());
            SnakeGame.food = new Point().createFood();
        }
        return nextPoint;
    }

    //варианты прерывания игры
    boolean sBreak(){
        boolean sBreak = false;

        Point head = pList.get(pList.size()-1);

        //проверка не съела ли змейка свой хвост
        for (int i = 0; i < pList.size()-1; i++) {
            if ((head.getX() == pList.get(i).getX()) && (head.getY() == pList.get(i).getY())) sBreak = true;
        }

        //проверка не вышла ли змейка за границы поля
        if ( (head.getX() < 0) || (head.getY() < 0) ||
                (head.getX() > 570) || (head.getY() > 540) ) sBreak = true;

        return sBreak;
    }

}
