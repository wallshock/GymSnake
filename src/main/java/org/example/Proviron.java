package org.example;

import static org.example.Configuration.LD;

import org.example.interfaces.IMapElement;
import org.example.interfaces.Item;
public class Proviron implements Item, IMapElement {
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

    @Override
    public String getPath() {
        return "C:\\Users\\walls\\IdeaProjects\\GymSnake\\src\\main\\resources\\proviron.png";
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

    @Override
    public String getImagePath() {
        return null;
    }
}