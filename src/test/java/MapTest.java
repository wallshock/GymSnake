import org.example.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class MapTest {
    @Test
    public void ConstructorTest(){
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
        Map map = new Map(Configuration.N,snake);
        map.print();
    }
}
