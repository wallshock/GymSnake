package org.example;

import static org.example.Configuration.LD;

import org.example.interfaces.IMapElement;
import org.example.interfaces.Item;
public class Testosterone implements Item, IMapElement {
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

    public Testosterone(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public void applyEffect(Snake snake) {
        // add 1/20th of LD to snake's anabolic dose
        snake.setAnabolicDose(snake.getAnabolicDose() + LD / 20);
    }

    @Override
    public String getImagePath() {
        return null;
    }
}