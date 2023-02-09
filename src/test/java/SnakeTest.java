import org.example.Configuration;
import org.example.Direction;
import org.example.Snake;
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

}
