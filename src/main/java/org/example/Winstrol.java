package org.example;

public class Winstrol implements Item {
    @Override
    public void applyEffect(Snake snake) {
        // add 3/4th of LD to snake's anabolic dose
        snake.setAnabolicDose(snake.getAnabolicDose() + 3 * LD / 4);
    }
}