import org.example.Configuration;
import org.example.Direction;
import org.example.MongolianSalesman;
import org.example.Snake;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
//todo
public class MongolianSalesmanTest {
    @Test
    public void BonusTest(){
        Configuration testCfg = new Configuration(100,1,1,1,1,10, 1, 1, 1);
        int[][] x = new int[1][1],y = new int[1][1];
        x[0][0] = 5;
        y[0][0] =5;
        Snake snake = new Snake(x, y);
        MongolianSalesman mongol = new MongolianSalesman(1,1);
        mongol.applyEffect(snake);
        assertEquals(99,snake.getAnabolicDose());
    }
}
