import org.example.Configuration;
import org.example.Direction;
import org.example.Snake;
import static org.junit.jupiter.api.Assertions.*;

import org.example.Testosterone;
import org.junit.jupiter.api.Test;
//todo
public class TestosteroneTest {
    @Test
    public void BonusTest(){
        Configuration testCfg = new Configuration(100,1,1,1,1,10, 1, 1, 1);
        int[][] x = new int[1][1],y = new int[1][1];
        x[0][0] = 5;
        y[0][0] =5;
        Snake snake = new Snake(x, y);
        Testosterone tesc = new Testosterone(1,1);
        tesc.applyEffect(snake);
        assertEquals(5,snake.getAnabolicDose());
    }
}
