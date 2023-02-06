import org.example.Configuration;
import org.example.Direction;
import org.example.Snake;
import org.junit.jupiter.api.Test;

public class SnakeTest {
    @Test
    void ConstructorTest(){
        Configuration testCfg = new Configuration(1,1,1,1,1,10, InitialLength, InitialWidth, InitialSpeed);
        Snake snake = new Snake(5, 5);
        assertEquals(5, snake.getX());
        assertEquals(5, snake.getY());
    }
    @Test
    void MoveTest(){
        Configuration testCfg = new Configuration(1,1,1,1,1,10, InitialLength, InitialWidth, InitialSpeed);
        Snake snake = new Snake(5, 5);
        snake.move();
        assertEquals(5, snake.getX());
        assertEquals(4, snake.getY());
    }

    @Test
    void ChangeDirectionTest(){
        Configuration testCfg = new Configuration(1,1,1,1,1,10, InitialLength, InitialWidth, InitialSpeed);
        Snake snake = new Snake(5, 5);
        snake.changeDirection(Direction.RIGHT);
        snake.move();
        assertEquals(6, snake.getX());
        assertEquals(5, snake.getY());
    }
    @Test
    void MapBoundaryTest() {
        Configuration testCfg = new Configuration(1,1,1,1,1,10, InitialLength, InitialWidth, InitialSpeed);
        Snake snake = new Snake(4, 4);
        snake.changeDirection(Direction.DOWN);
        snake.move();
        assertEquals(4, snake.getX());
        assertEquals(0, snake.getY());
    }

}
