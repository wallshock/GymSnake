package org.example;

public class MongolianSalesman implements Item {
    @Override
    public void applyEffect(Snake snake) {
        // add 99/100th of LD to snake's anabolic dose
        snake.setAnabolicDose(snake.getAnabolicDose() + 99 * LD / 100);
    }
}