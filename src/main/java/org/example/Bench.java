package org.example;

import org.example.interfaces.IMapElement;
import org.example.interfaces.Item;

import static org.example.Configuration.*;

public class Bench implements Item, IMapElement {
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
        return "C:\\Users\\walls\\IdeaProjects\\GymSnake\\src\\main\\resources\\bench.png";
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

    @Override
    public String getImagePath() {
        return null;
    }
}