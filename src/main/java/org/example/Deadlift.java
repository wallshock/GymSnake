package org.example;

import static org.example.Configuration.*;

public class Deadlift implements Item {

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

    public Deadlift(int x, int y) {
        this.x = x;
        this.y = y;
    }@Override
    public void applyEffect(Snake snake) {
        // add BD to snake length
        snake.setLength(snake.getLength() + BD);
    }
}
