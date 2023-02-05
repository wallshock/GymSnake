package org.example;

import static org.example.Configuration.LD;

public class Proviron implements Item {
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

    public Proviron(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public void applyEffect(Snake snake) {
        // add 1/5th of LD to snake's anabolic dose
        snake.setAnabolicDose(snake.getAnabolicDose() + LD / 5);
    }
}