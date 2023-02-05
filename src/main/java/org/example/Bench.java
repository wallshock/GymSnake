package org.example;

import static org.example.Configuration.*;

public class Bench implements Item {
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

    public Bench(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void applyEffect(Snake snake) {
        // add BP to snake speed
        snake.setSpeed(snake.getSpeed() + BP);
    }
}