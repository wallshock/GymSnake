import org.example.Configuration;
import org.example.Direction;
import org.example.Snake;
import static org.junit.jupiter.api.Assertions.*;

import org.example.Testosterone;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

//todo
public class TestosteroneTest {
    @Test
    public void BonusTest(){
        Configuration testCfg = new Configuration(100,1,1,1,1,10, 1, 1, 1);
        ArrayList<ArrayList<Integer>> x= new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> y= new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> row1 = new ArrayList<Integer>();
        ArrayList<Integer> col1 = new ArrayList<Integer>();
        row1.add(5);
        col1.add(5);
        y.add(row1);
        x.add(col1);
        Snake snake = new Snake(x, y);
        Testosterone tesc = new Testosterone(1,1);
        tesc.applyEffect(snake);
        assertEquals(5,snake.getAnabolicDose());
    }
}
