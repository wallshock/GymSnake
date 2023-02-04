package org.example;

public class Deadlift implements Item {
    @Override
    public void applyEffect(Snake snake) {
        // add BD to snake length
        snake.setLength(snake.getLength() + BD);
    }
}
