package org.example;

import static org.example.Configuration.LD;

public class MongolianSalesman implements Item {

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

    public MongolianSalesman(int x, int y) {
        this.x = x;
        this.y = y;
    }@Override
    public void applyEffect(Snake snake) {
        // add 99/100th of LD to snake's anabolic dose
        snake.setAnabolicDose(snake.getAnabolicDose() + 99 * LD / 100);
    }
}