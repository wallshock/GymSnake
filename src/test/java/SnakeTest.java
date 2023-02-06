import org.example.Configuration;
import org.example.Direction;
import org.example.Snake;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SnakeTest {
    @Test
    void ConstructorTest(){
        Configuration testCfg = new Configuration(1,1,1,1,1,10, 1, 1, 1);
        int[][] x = new int[1][1],y = new int[1][1];
        x[0][0] = 5;
        y[0][0] =5;
        Snake snake = new Snake(x, y);
        assertEquals(5, snake.getX()[0][0]);
        assertEquals(5, snake.getY()[0][0]);
    }
    @Test
    void MoveTest(){
        Configuration testCfg = new Configuration(1,1,1,1,1,10, 1, 1, 1);
        int[][] x = new int[1][1],y = new int[1][1];
        x[0][0] = 5;
        y[0][0] =5;
        Snake snake = new Snake(x, y);
        snake.move();
        assertEquals(5, snake.getX()[0][0]);
        assertEquals(4, snake.getY()[0][0]);
    }

    @Test
    void ChangeDirectionTest(){
        Configuration testCfg = new Configuration(1,1,1,1,1,10, 1, 1, 1);
        int[][] x = new int[1][1],y = new int[1][1];
        x[0][0] = 5;
        y[0][0] =5;
        Snake snake = new Snake(x, y);
        snake.changeDirection(Direction.RIGHT);
        snake.move();
        assertEquals(6, snake.getX()[0][0]);
        assertEquals(5, snake.getY()[0][0]);
    }
    @Test
    void MapBoundaryTest() {
        Configuration testCfg = new Configuration(1,1,1,1,1,5, 1, 1, 1);
        int[][] x = new int[1][1],y = new int[1][1];
        x[0][0] = 4;
        y[0][0] =4;
        Snake snake = new Snake(x, y);
        snake.changeDirection(Direction.DOWN);
        snake.move();
        assertEquals(4, snake.getX()[0][0]);
        assertEquals(0, snake.getY()[0][0]);
    }

}
