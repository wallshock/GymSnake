import org.example.Configuration;
import org.example.Direction;
import org.example.Snake;
import static org.junit.jupiter.api.Assertions.*;

import org.example.Winstrol;
import org.junit.jupiter.api.Test;
//todo
public class WinstrolTest {
    @Test
    public void BonusTest(){
        Configuration testCfg = new Configuration(100,1,1,1,1,10, 1, 1, 1);
        int[][] x = new int[1][1],y = new int[1][1];
        x[0][0] = 5;
        y[0][0] =5;
        Snake snake = new Snake(x, y);
        Winstrol winstrol = new Winstrol(1,1);
        winstrol.applyEffect(snake);
        assertEquals(75,snake.getAnabolicDose());
    }
}
