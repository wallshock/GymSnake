package org.example;

public class Bench implements Item {
    @Override
    public void applyEffect(Snake snake) {
        // add BP to snake speed
        snake.setSpeed(snake.getSpeed() + BP);
    }
}