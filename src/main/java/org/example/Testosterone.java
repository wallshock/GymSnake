package org.example;

public class Testosterone implements Item {
    @Override
    public void applyEffect(Snake snake) {
        // add 1/20th of LD to snake's anabolic dose
        snake.setAnabolicDose(snake.getAnabolicDose() + LD / 20);
    }
}