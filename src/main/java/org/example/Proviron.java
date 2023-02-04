package org.example;

public class Proviron implements Item {
    @Override
    public void applyEffect(Snake snake) {
        // add 1/5th of LD to snake's anabolic dose
        snake.setAnabolicDose(snake.getAnabolicDose() + LD / 5);
    }
}