import org.example.Configuration;
import org.example.Direction;
import org.example.Proviron;
import org.example.Snake;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

//todo
public class ProvironTest {
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
        Proviron prov = new Proviron(1,1);
        prov.applyEffect(snake);
        assertEquals(20,snake.getAnabolicDose());
    }
}
