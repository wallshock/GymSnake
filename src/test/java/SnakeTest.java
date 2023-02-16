import org.example.*;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SnakeTest {
    @Test
    void ConstructorTest(){
        Configuration testCfg = new Configuration(1,1,1,1,1,10, 1, 1, 1);
        ArrayList<ArrayList<Integer>> x= new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> y= new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> row1 = new ArrayList<Integer>();
        ArrayList<Integer> col1 = new ArrayList<Integer>();
        row1.add(5);
        col1.add(5);
        y.add(row1);
        x.add(col1);
        Snake snake = new Snake(x, y);
        assertEquals(5, snake.getX().get(0).get(0));
        assertEquals(5, snake.getY().get(0).get(0));
    }
    @Test
    void MoveTest(){
        Configuration testCfg = new Configuration(1,1,1,1,1,10, 1, 1, 1);
        ArrayList<ArrayList<Integer>> x= new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> y= new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> row1 = new ArrayList<Integer>();
        ArrayList<Integer> col1 = new ArrayList<Integer>();
        row1.add(5);
        col1.add(5);
        y.add(row1);
        x.add(col1);
        Snake snake = new Snake(x, y);
        snake.move();
        assertEquals(5, snake.getX().get(0).get(0));
        assertEquals(4, snake.getY().get(0).get(0));
    }

    @Test
    void ChangeDirectionTest(){
        Configuration testCfg = new Configuration(1,1,1,1,1,10, 1, 1, 1);
        ArrayList<ArrayList<Integer>> x= new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> y= new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> row1 = new ArrayList<Integer>();
        ArrayList<Integer> col1 = new ArrayList<Integer>();
        row1.add(5);
        col1.add(5);
        y.add(row1);
        x.add(col1);
        Snake snake = new Snake(x, y);
        snake.changeDirection(Direction.RIGHT);
        snake.move();
        assertEquals(6, snake.getX().get(0).get(0));
        assertEquals(5, snake.getY().get(0).get(0));
    }
    @Test
    void MapBoundaryTest() {
        Configuration testCfg = new Configuration(1,1,1,1,1,5, 1, 1, 1);
        ArrayList<ArrayList<Integer>> x= new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> y= new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> row1 = new ArrayList<Integer>();
        ArrayList<Integer> col1 = new ArrayList<Integer>();
        row1.add(4);
        col1.add(4);
        y.add(row1);
        x.add(col1);
        Snake snake = new Snake(x, y);
        snake.changeDirection(Direction.DOWN);
        snake.move();
        assertEquals(4, snake.getX().get(0).get(0));
        assertEquals(0, snake.getY().get(0).get(0));
    }
    @Test
    void ThickerSnakeMoveTest() {
        Configuration testCfg = new Configuration(1, 1, 1, 1, 1, 10, 1, 2, 1);
        ArrayList<ArrayList<Integer>> x = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> y = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> ys = new ArrayList<Integer>();
        ArrayList<Integer> xs = new ArrayList<Integer>();
        xs.add(4);
        ys.add(4);
        xs.add(5);
        ys.add(4);
        x.add(xs);
        y.add(ys);
        Snake snake = new Snake(x, y);
        snake.move();
        snake.changeDirection(Direction.RIGHT);
        snake.move();
        assertEquals(6, snake.getX().get(0).get(0));
        assertEquals(3, snake.getY().get(0).get(0));
        assertEquals(6, snake.getX().get(0).get(1));
        assertEquals(4, snake.getY().get(0).get(1));
        snake.move();
        snake.move();
        assertEquals(8, snake.getX().get(0).get(0));
        assertEquals(3, snake.getY().get(0).get(0));
        assertEquals(8, snake.getX().get(0).get(1));
        assertEquals(4, snake.getY().get(0).get(1));
        snake.changeDirection(Direction.DOWN);
        snake.move();
        assertEquals(8, snake.getX().get(0).get(0));
        assertEquals(5, snake.getY().get(0).get(0));
        assertEquals(7, snake.getX().get(0).get(1));
        assertEquals(5, snake.getY().get(0).get(1));
        snake.move();
        snake.move();
        snake.changeDirection(Direction.LEFT);
        snake.move();
        assertEquals(6, snake.getX().get(0).get(0));
        assertEquals(7, snake.getY().get(0).get(0));
        assertEquals(6, snake.getX().get(0).get(1));
        assertEquals(6, snake.getY().get(0).get(1));
        snake.move();
        snake.changeDirection(Direction.DOWN);
        snake.move();
        assertEquals(6, snake.getX().get(0).get(0));
        assertEquals(8, snake.getY().get(0).get(0));
        assertEquals(5, snake.getX().get(0).get(1));
        assertEquals(8, snake.getY().get(0).get(1));
        snake.changeDirection(Direction.RIGHT);
        snake.move();
        assertEquals(7, snake.getX().get(0).get(0));
        assertEquals(7, snake.getY().get(0).get(0));
        assertEquals(7, snake.getX().get(0).get(1));
        assertEquals(8, snake.getY().get(0).get(1));
        snake.changeDirection(Direction.UP);
        snake.move();
        assertEquals(6, snake.getX().get(0).get(0));
        assertEquals(6, snake.getY().get(0).get(0));
        assertEquals(7, snake.getX().get(0).get(1));
        assertEquals(6, snake.getY().get(0).get(1));
        System.out.println(x);
        System.out.println(y);
        snake.move();
        snake.changeDirection(Direction.LEFT);
        snake.move();
        assertEquals(5, snake.getX().get(0).get(0));
        assertEquals(6, snake.getY().get(0).get(0));
        assertEquals(5, snake.getX().get(0).get(1));
        assertEquals(5, snake.getY().get(0).get(1));
        snake.changeDirection(Direction.UP);
        snake.move();
        assertEquals(5, snake.getX().get(0).get(0));
        assertEquals(4, snake.getY().get(0).get(0));
        assertEquals(6, snake.getX().get(0).get(1));
        assertEquals(4, snake.getY().get(0).get(1));
    }
    @Test
    void SteroidApplicationTest() {
        Configuration testCfg = new Configuration(100, 1, 1, 1, 2, 10, 5, 1, 1);
        ArrayList<ArrayList<Integer>> x = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> y = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> ys = new ArrayList<Integer>();
        ArrayList<Integer> xs = new ArrayList<Integer>();
        xs.add(3);
        ys.add(3);
        x.add(xs);
        y.add(ys);
        ArrayList<Integer> ys1 = new ArrayList<Integer>();
        ArrayList<Integer> xs1 = new ArrayList<Integer>();
        xs1.add(4);
        ys1.add(3);
        x.add(xs1);
        y.add(ys1);
        ArrayList<Integer> ys2 = new ArrayList<Integer>();
        ArrayList<Integer> xs2 = new ArrayList<Integer>();
        xs2.add(5);
        ys2.add(3);
        x.add(xs2);
        y.add(ys2);
        ArrayList<Integer> ys3 = new ArrayList<Integer>();
        ArrayList<Integer> xs3 = new ArrayList<Integer>();
        xs3.add(5);
        ys3.add(4);
        x.add(xs3);
        y.add(ys3);
        ArrayList<Integer> ys4 = new ArrayList<Integer>();
        ArrayList<Integer> xs4 = new ArrayList<Integer>();
        xs4.add(5);
        ys4.add(5);
        x.add(xs4);
        y.add(ys4);
        Snake snake = new Snake(x, y);
        snake.addToBackpack(new Deadlift(2,2));
        snake.addToBackpack(new MongolianSalesman(2,2));
        snake.changeDirection(Direction.DOWN);
        snake.move();
        snake.changeDirection(Direction.RIGHT);
        snake.move();
        assertEquals(snake.getLength(),5);
        snake.changeDirection(Direction.UP);
        snake.move();
        assertEquals(snake.getLength(),6);
        snake.move();
        assertEquals(snake.getLength(),7);
        snake.move();
        assertEquals(snake.getLength(),7);
    }

}
