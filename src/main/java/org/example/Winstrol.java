package org.example;

import static org.example.Configuration.LD;

import org.example.interfaces.IMapElement;
import org.example.interfaces.Item;
public class Winstrol implements Item, IMapElement {
    public final int x;
    public final int y;

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    public Winstrol(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public void applyEffect(Snake snake) {
        // add 3/4th of LD to snake's anabolic dose
        snake.setAnabolicDose(snake.getAnabolicDose() + 3 * LD / 4);
    }

    @Override
    public String getImagePath() {
        return null;
    }
}